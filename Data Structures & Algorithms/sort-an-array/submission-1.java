class Solution {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }
        
        int mid = left + (right - left) / 2;
        
        // Split and sort left and right halves
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid + 1, right, temp);
        
        // Merge the sorted halves
        merge(nums, left, mid, right, temp);
    }

    private void merge(int[] nums, int left, int mid, int right, int[] temp) {
        // Copy elements to the temporary array
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left;      // Pointer for left sub-array
        int j = mid + 1;   // Pointer for right sub-array
        int k = left;      // Pointer for merged array

        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                nums[k++] = temp[i++];
            } else {
                nums[k++] = temp[j++];
            }
        }

        // Copy remaining elements from the left sub-array, if any
        while (i <= mid) {
            nums[k++] = temp[i++];
        }
        
        // Remaining elements in the right sub-array are already in place
    }
}