class Solution {
    public int[] sortArray(int[] nums) {
        if(nums==null || nums.length<=1){
            return nums;
        }
        int left=0;
        int right=nums.length-1;
        mergesort(nums,left,right);
        return nums;
    }
    private void mergesort(int [] arr,int left,int right){
        if(left>=right){
            return;
        }
        int middle=left+(right-left)/2;
        mergesort(arr,left,middle);
        mergesort(arr,middle+1,right);

        merge(arr,left,middle,right);
    }
    private void merge(int [] arr,int left,int mid,int right){
        int i=left;
        int j=mid+1;
        int len=right-left+1;
        int [] temp=new int[len];
        int index=0;
        while(i<=mid && j<=right){
            if(arr[i]<arr[j]){
                temp[index]=arr[i];
                i++;
                index++;
            }
            else{
                temp[index]=arr[j];
                j++;
                index++;
            }
        }
        while(i<=mid){
                temp[index]=arr[i];
                i++;
                index++;
            }
        while(j<=right){
                temp[index]=arr[j];
                j++;
                index++;
            }
        int m=0;
        for(int k=left;k<=right;k++){
            arr[k]=temp[m];
            m++;
        }
    }
}