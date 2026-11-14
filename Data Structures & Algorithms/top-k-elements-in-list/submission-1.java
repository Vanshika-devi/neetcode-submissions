class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> h = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            h.put(nums[i],h.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Integer> heap=new PriorityQueue<>(
            (a,b)->h.get(a)-h.get(b)
        );
        for(int key:h.keySet()){
            heap.offer(key);
            if(heap.size()>k){
                heap.poll();
            }
        }
        int [] result=new int[k];
        for(int i=0;i<k;i++){
            result[i]=heap.poll();
        }
        return result;
    }
}
