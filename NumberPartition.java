
/*
* this class devides a group of numbers into two groups.
*/
public class NumberPartition{

    /*
	* Check if a characteristic string defines a partition 
    * of the numbers 1...n  such that:
    * (1) both sides are of equal length
    * (2) both sides are of equal sum
    * (3) both sides have equal sums of squared elements.
    * returns false if arguments are null / "incorrect"
	*/
   

	//get a string and return array with the index of the zero value in the string
	private static int[] Zero(String s){ 
    	int count=0;
    	for(int i=0;i<s.length();i=i+1)
    		if(s.charAt(i)=='0')
    			count++;
    	int []zero=new int[count];
    	int j=0;
    	for(int i=0;i<s.length()&&j<zero.length;i=i+1){
    		if(s.charAt(i)=='0'){
    			zero[j]=i+1;
    			j++;
    		}
    	}
    	return zero;
    }
	//get a string and return array with the index of the one value in the string
    private static int[] One(String s){ 
    	int count=0;
    	for(int i=0;i<s.length();i=i+1)
    		if(s.charAt(i)=='1')	
    			count++;
    	int []one=new int[count];
    	int j=0;
    	for(int i=0;i<s.length()&&j<one.length;i=i+1){
    		if(s.charAt(i)=='1'){
    			one[j]=i+1;
    			j++;
    		}
    	}
    	return one;
    }
    // sums the values of all indexes in the array
	private static int ArrSum(int[]arr){
		int sum=0;
		for(int i=0;i<arr.length;i=i+1)
			sum=sum+arr[i];
		return sum;
	}
	// sums the square values of all indexes in the array
	private static int ArrSumSq(int[]arr){
		int sum=0;
		for(int i=0;i<arr.length;i=i+1)
			sum=sum+arr[i]*arr[i];
		return sum;
	}
	
	
	
	//checks if a number with a string meet the requirements to be a "number partition"
    public static boolean isNumberPartition(int n, String s){
        boolean part=false;
        int [] zero;
        int []one;
        if(s!=null)
        	if(n%2==0)
        		if(n==s.length()){
        			zero=Zero(s);
        			one=One(s);
        			if(zero.length==one.length)
        				if(ArrSum(zero)==ArrSum(one))
        					if(ArrSumSq(zero)==ArrSumSq(one))
        						part=true;
        		}
        return part;
    }
        			
        
        
        
        
   


	// a shell function that sends a number to a recursive function
    public static void numberPartition(int n){
		if (n > 0) {
			if(n%2==0){
				String s="";
				
				for(int i=0;i<n;i=i+1)
					s=s+"0";
    	
			numberPartition(n,s,0);
		}
    }
    }

    
    
    
    
	// gets a number and prints the different strings that are the length of the number and are "number partitions" 
    private static void numberPartition(int n ,String s,int index ){	
		if(index==s.length()){
			if(isNumberPartition(n,s))
				System.out.println(s);
    	}
    	else{
    		numberPartition(n,s.substring(0,index)+"0"+s.substring(index+1),index+1);
    		numberPartition(n,s.substring(0,index)+"1"+s.substring(index+1),index+1);
    	}
	}
    	
}



















