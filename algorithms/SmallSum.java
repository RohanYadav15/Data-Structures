  import java.util.*;

  public class SmallSum{
    // complete the following methods
    //smallSum() returns the small sum of the whole array.
    public static int smallSum(int[] arr){
        if(arr == null || arr.length < 2) return 0;
        
        return processMergeSort(arr, 0, arr.length - 1);
    }
    //processMergeSort uses merge-sort to sort arr from low to high
    // and returns the small sum of arr from low to high
    public static int processMergeSort(int[] arr, int low, int high){
        if(low >= high) return 0;

        int mid = low + (high - low) / 2;
        int left_sum = processMergeSort(arr, low, mid);
        int right_sum = processMergeSort(arr, mid + 1, high);
        int merge_sum = merge(arr, low, mid, high);

        return (left_sum + right_sum + merge_sum);
    }
    // merge() merges two sorted parts in arr: from low to mid, and from mid+1 to high
    // and returns the small sum of arr from low to high during the merge operation.
    public static int merge(int[] arr, int low, int mid, int high){
        int smallSum = 0;
        int p1 = low;
        int p2 = mid+1;

        int curIndex = 0;
        int[] temp = new int[high - low + 1];

        while(p1 <= mid && p2 <= high){
            if(arr[p1] < arr[p2]){
                temp[curIndex] = arr[p1];
                smallSum += ((high - p2) + 1) * arr[p1];
                p1++;
            }else {
                temp[curIndex] = arr[p2];
                p2++;
            }
            curIndex++;
        }

        while(p1 <= mid){
            temp[curIndex] = arr[p1];
            p1++;
            curIndex++;
        }

        while(p2 <= high) {
            temp[curIndex] = arr[p2];
            p2++;
            curIndex++;
        }

        for(int i = 0; i < temp.length; i++){
            arr[low + i] = temp[i];
        }
        
        return smallSum;

    }

    //test code
    public static void main(String[] args){
        int[] arr = new int[]{1,3,4,2,5};
        System.out.println(smallSum(arr));
        System.out.println(Arrays.toString(arr));
    }
}