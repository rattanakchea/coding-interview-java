class Solution {
    public int[] productExceptSelf(int[] nums) {
        // as we go from left to right, we keep taking the product of numbers left to a particular number and store it in res.
        // nums = [1,2,3,4]
        // after first pass the res will have [1,1,2,6]
        // we start second pass with keeping the product from right in variable 'right' and update it after processing each number in array
        if (nums.length == 0)
            return new int[0];
        int [] res = new int[nums.length];
        int right = 1;
        res[0] = 1;
        for(int i=1;i<nums.length;i++)
            res[i] = res[i-1]*nums[i-1];
        for(int i = nums.length-1;i>=0;i--)
        {
            res[i] = res[i]*right;
            right = right*nums[i];
        }
        return res;
    }
}