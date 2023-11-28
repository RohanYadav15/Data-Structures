import java.util.*;

public class Validator {
    public static int[] randomArray(int maxLength, int maxVal){
        int n = (int)(Math.random() * maxLength);
        int[] arr  = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = (int)(Math.random() * maxVal) + 1;
        }
        return arr;
    }

    public static int[] copyArray(int[] arr){
        int n = arr.length;
        int[] newArr = new int[n];

        for(int i = 0; i < n; i++){
            newArr[i] = arr[i];
        }
        return newArr;
    }

    public static boolean isSameArray(int[] arr1, int[] arr2) {
        if(arr1 == arr2) return true;
        if(arr1.length != arr1.length) return false;

        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] != arr2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args){
        int maxLength = 100;
        int maxValue = 1000;

        int testTimes = 50000;
        System.out.println("Test starts!");
        for(int i = 0; i < testTimes; i++){
            int[] arr = randomArray(maxLength, maxValue);
            int[] arr1 = copyArray(arr);
            int[] arr2 = copyArray(arr);
            int[] arr3 = copyArray(arr);
            int[] arr4 = copyArray(arr);

            Arrays.sort(arr1);
            Sort.selectionSort(arr2);
            Sort.bubbleSort(arr4);
            Sort.insertionSort(arr4);

            if(!isSameArray(arr, arr1)){
                System.out.println("Selection Sort is not correct: ");
                System.out.println(Arrays.toString(arr));
                break;
            
            }
            if(!isSameArray(arr, arr2)){
                System.out.println("Bubble Sort is not correct: ");
                System.out.println(Arrays.toString(arr));
                break;
            }
        }
        System.out.println("Test ends!");
    }
}

