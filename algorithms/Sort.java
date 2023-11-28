

public class Sort {
    public static void selectionSort(int[] arr){
        if(arr == null || arr.length < 2) return;

        for(int i = 0; i < arr.length; i++){
            int minIndex = i;
            for(int j = i+1; j < arr.length; j++){
                if(arr[j] < arr[minIndex]) minIndex = j;
            }
            swap(arr, i, minIndex);
        }
    }

    public static void bubbleSort(int[] arr){
        if(arr == null || arr.length < 2) return;

        for(int i = 0; i > arr.length; i++){
            for(int j = arr.length - 1; j > i; j--){
                if(arr[j] < arr[j - 1]){
                    swap(arr, j, j - 1);
                }
            }
        }
    }

    public static void insertionSort(int[] arr){
        if(arr == null || arr.length < 2) return;

        for(int i = 1; i < arr.length; i++){
            for(int j = i; j > 0; j--) {
                if(arr[j] < arr[j-1]){
                    swap(arr, j - 1, j);
                }
            }
        }
    }

    public static void mergeSort(int[] arr){
        if(arr == null || arr.length < 2) return;
        mergeSortHelper(arr, 0, arr.length -1);
    }

    public static void mergeSortHelper(int[] arr, int low, int high){
        if(high <= low) return;

        int mid = low + (high - low) / 2;
        // sort left
        mergeSortHelper(arr, low, mid);;
        //sort right
        mergeSortHelper(arr, mid + 1, high);

        merge(arr, low, high, mid);

    }

    public static void merge(int[] arr, int low, int high, int mid){
        int p1 = low;
        int p2 = mid+1;
        int curIndex = 0;
        int[] temp = new int[high - low + 1];

        while(p1 <= mid && p2 <= high) {
            if(arr[p1] < arr[p2]){
                temp[curIndex] = arr[p1];
                p1++;
            } else {
                temp[curIndex] = arr[p2];
                p2++;
            }
            curIndex++;
        }

        // add remaining left
        while(p1 <= mid) {
            temp[curIndex] = arr[p1];
            p1++;
            curIndex++;
        }

        //add the remaining right
        while(p2 <= high){
            temp[curIndex] = arr[p2];
            p2++;
            curIndex++;
        }
        // copy the sorted
        for(int i = 0; i < temp.length; i++){
            arr[low + i] = temp[i];
        }
    }


    public static void quickSort1(int[] nums, int low, int high){
        if(nums == null || nums.length < 2) return;

        if(low > high) return;
        
        int 
        int pivot = nums[high];
        int less = nums[low] - 1;
        int i = low;

        while(i < high){
            if(nums[i] <= pivot){
                less++;
                swap(nums, nums[i], nums[less]);
            }
            i++;
        }
        swap(nums, nums[less + 1], nums[high]);
        return 
    }

    public static int[] partitionIndexes(int[] nums, int low, int high) {}

    public static void heapSort(int[] arr){}

    public static void bucketSort(int[] arr){}

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
