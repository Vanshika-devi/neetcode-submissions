
class Solution {
    public boolean hasDuplicate(int[] nums) {
    HashMap<Integer,Integer> H=new HashMap<>();
    for(int i=0;i<nums.length;i++) {
        if(H.containsKey(nums[i])){
            return true;
        }
        H.put(nums[i],i);
    }  
    return false;
    }
}