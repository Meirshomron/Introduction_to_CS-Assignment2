
/*
* a class that makes a new object that is a map.
*/
public class Map {

	//the field of the map
	private char[][] map;
	
	//makes a new object Map with an array of chars.
	public Map(char[][] map) {
		for(int i=0;i<map.length;i=i+1)
			for(int j=0;j<map.length;j=j+1)
				if((map[i][j]<'A'&&map[i][j]>'Z')||(map[i][j]<'a'&&map[i][j]>'z'))
					map[i][j]='z';
		this.map=map;
	}
	
	// a function that makes a copy of the map and returns the copy.
	public char[][] getMap() {
		char[][] temp=new char[this.map.length][this.map.length];
		for(int i=0;i<this.map.length;i=i+1)
			for(int j=0;j<this.map.length;j=j+1)
				temp[i][j]=this.map[i][j];
			
		return temp;
	}
	
	//a function that returns the char of a maps array in a certain line and column.
	private char getChar(int i,int j){
	  return map[i][j];
	}
	
	
	
	// compares 2 maps if their arrays are the same size with the same values.
	public boolean equals(Map map) {
		boolean equal=false;
		if(this.map.length==map.getMap().length){
			equal=true;
			for(int i=0;i<this.map.length&&equal;i=i+1)
				for(int j=0;j<this.map.length&&equal;j=j+1)
					if(getChar(i,j)==map.getChar(i,j))
						equal=true;
					else equal=false;
			}
		return equal;
	}
	
	/*receives a string and a char and returns true or false if the char appears in the string
	 with consideration to capital letters. 
	*/
	private static boolean isCharIn(char x,String s){
		boolean found=false;
		for(int i=0;i<s.length()&&!found;i=i+1)
			if(x==s.charAt(i)||x+32==s.charAt(i)||x==s.charAt(i)+32)
				found=true;
		return found;
	}
	
	/* a function that receives a string and returns 
	a shortened version of the string without duplicates
	  and with consideration to capital letters. 		
	 */
	private static String array(String s,String w){
		for (int i=0;i<s.length();i=i+1)
			if((isCharIn(s.charAt(i),w))==false)	
				w=s.charAt(i)+w;
		return w;
	}
	
	
	// a function that returns the amount of colors on the map.
	public int numOfColors() {
		int n=0;
		String s="";
		String w="";
		if(map!=null){
			for(int i=0;i<this.map.length;i=i+1)
				for(int j=0;j<this.map.length;j=j+1)	
					if((map[i][j]>='A'&&map[i][j]<='Z')||(map[i][j]>='a'&&map[i][j]<='z'))
						s=s+map[i][j];
			w=array(s,"");
			n=w.length();	
		}
		return n;
	}
	
	
	//receives coordinates and checks if the coordinates are in the map.
	private boolean isValid(int x,int y){
		return (x>=0&&x<map.length&&y>=0&&y<map.length);
	}
	
	//receives coordinates and returns a string with all the neighbor's colors with duplicates.
	private String sArea(int x,int y){
		String s="";
		for(int i=x-1;i<=x+1;i=i+1)
			for(int j=y-1;j<=y+1;j=j+1)
				if(isValid(i,j))
					s=s+map[i][j];
	return s;
	}
	
	// receives a point in the map and returns the number of colors in the area of the point.
	public int numOfColors(Point p) {
		String s="";
		if(isValid(p.getX(),p.getY())){
				s=sArea(p.getX(),p.getY());
				s=array(s,"");
		}
		return s.length();
	}
	
	// receives 2 points and returns if the 2 points are legal neighbors and have the same color.
	public boolean legalNeighbor(Point p1, Point p2) {
		boolean found=false;
		int x=p1.getX();
		int y=p1.getY();
		if(isValid(p1.getX(),p1.getY()))
				if(isValid(p2.getX(),p2.getY()))
						for(int i=x-1;i<=x+1&&!found;i=i+1)
							for(int j=y-1;j<=y+1&&!found;j=j+1){
								if(p2.getX()!=x||p2.getY()!=y)
									if(i==(p2.getX())&&j==(p2.getY()))
											if(map[i][j]==map[x][y]||map[i][j]+32==map[x][y]||map[i][j]-32==map[x][y])
												found=true;
							}
	return found;									
			
			
		}
				
	// a shell function that receives a point and a color and changes the map.
	public void fill(Point p,char color) {
		fill1(p.getX(),p.getY(),map[p.getX()][p.getY()],color);
	}
	
	/* a function that receives a point and a color and changes the color of 
	 * the point and of all the legal neighbors recursively until the neighbor is not legal.
	 */
	private void fill1(int x,int y,char cOrigin,char cNew) {
	if(isValid(x,y)){
		if(map[x][y]==cOrigin){
				map[x][y]=cNew;
					fill1( x-1, y-1, cOrigin, cNew);
					fill1( x-1, y, cOrigin, cNew);
					fill1( x-1, y+1, cOrigin, cNew);
					fill1( x, y-1, cOrigin, cNew);
					fill1( x, y+1, cOrigin, cNew);
					fill1( x+1, y-1, cOrigin, cNew);
					fill1( x+1, y, cOrigin, cNew);
					fill1( x+1, y+1, cOrigin, cNew);
			}			
		}
	}
	
}

