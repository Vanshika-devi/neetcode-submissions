class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> h = new HashMap<>();
        
        // 1. Count frequencies
        for (int i = 0; i < nums.length; i++) {
            h.put(nums[i], h.getOrDefault(nums[i], 0) + 1);
        }
        
        // 2. Change PriorityQueue to store int[] and compare by frequency (index 1)
        PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        
        // 3. Add entries from the HashMap into the heap
        for (Map.Entry<Integer, Integer> entry : h.entrySet()) {
            que.add(new int[] { entry.getKey(), entry.getValue() });
            
            // Keep only the top k elements in the heap
            if (que.size() > k) {
                que.poll();
            }
        }
        
        // 4. Extract the elements from the heap into the result array
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = que.poll()[0]; // Get the element value
        }
        
        return result;
    }
}