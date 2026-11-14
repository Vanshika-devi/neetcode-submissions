class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Build the frequency map
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create the buckets
        // The maximum possible frequency an element can have is nums.length
        List<Integer>[] frequencyBucket = new List[nums.length + 1];
        for (int i = 0; i <= nums.length; i++) {
            frequencyBucket[i] = new ArrayList<>();
        }

        // Put numbers into buckets based on their frequency
        for (int key : count.keySet()) {
            int freq = count.get(key);
            frequencyBucket[freq].add(key);
        }

        // Step 3: Collect the top k elements from the buckets (starting from the highest frequency)
        int[] result = new int[k];
        int index = 0;
        
        for (int i = frequencyBucket.length - 1; i >= 0; i--) {
            for (int num : frequencyBucket[i]) {
                result[index++] = num;
                if (index == k) {
                    return result;
                }
            }
        }
        
        return result;
    }
}