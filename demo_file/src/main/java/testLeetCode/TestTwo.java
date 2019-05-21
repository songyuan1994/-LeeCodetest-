package testLeetCode;

public class TestTwo {
	public static void main(String args[]){
		int[] arr1 = {2,7,11,15};
		int target = 9;
		int[] rel = twoSum(arr1,target);
		System.out.println(rel[0]);
		System.out.println(rel[1]);
	}
	
    public static int[] twoSum(int[] nums, int target) {
    	int sum = 0;
    	int[] result = new int[2];
    	for(int i=0;i<nums.length;i++){
    		for(int j=nums.length-i-1;j>=0;j--){
    			sum = nums[i]+nums[j];
    			if(sum==target){
    				result[0]=i;
    				result[1]=j;
    				return result;
    			}
    		}
    	}
    	
		return result;
    }
	

}
