class Solution {
    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> queue=new PriorityQueue<>(
            (a,b)->a-b
        );
        for(int i=0;i<nums.length;i++){
            queue.offer(nums[i]);
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=queue.poll();
        }
        return nums;
    }
}