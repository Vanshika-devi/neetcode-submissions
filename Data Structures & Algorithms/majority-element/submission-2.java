class Solution {
    public int majorityElement(int[] nums) {
        int count=0;
        int el=nums[0];
        for(int i=0;i<nums.length;i++){
            if(el==nums[i]){
                count++;
            }
            if(count==0){
                el=nums[i];
            }
            if(nums[i]!=el){
                count--;
            }
        }
        return el;
    }
}