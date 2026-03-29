import java.util.Random;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of array: ");
        int length = sc.nextInt();
        int[] array = new int[length];
        for(int i = 0; i < length; i++){
            array[i] = new Random().nextInt(length);
        }
        MergeSort sorter = new MergeSort();
        System.out.print("Unsorted Array: ");
        sorter.displayArray(array);

        System.out.println();

        sorter.sort(array);
        System.out.print("Sorted Array: ");
        sorter.displayArray(array);

    }

    public void displayArray(int[] arr){
        System.out.println("[");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
            if(i < arr.length - 1){
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

    private int[] array;
    private int[] tempMergArr;
    private int length;

    public void sort(int inputArr[]){
        this.array = inputArr;
        this.length = inputArr.length;
        this.tempMergArr = new int[length];
        doMergeSort(0, length - 1);
    }

    private void doMergeSort(int lowerIndex, int higherIndex){
        if(lowerIndex < higherIndex){
            int mid = lowerIndex + (higherIndex - lowerIndex) / 2;
            doMergeSort(lowerIndex, mid);
            doMergeSort(mid + 1, higherIndex);
            mergerParts(lowerIndex, mid, higherIndex);
        }
    }

    private void mergerParts(int lowerIndex,int mid, int higherIndex){
        for(int i = lowerIndex; i <= higherIndex; i++){
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = mid + 1;
        int k = lowerIndex;
        while(i <= mid && j <= higherIndex){
            if(tempMergArr[i] <= tempMergArr[j]){
                array[k] = tempMergArr[i];
                i++;
            }else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }while(i <= mid){
            array[k] = tempMergArr[i];
            k++;
            i++;
        }
    }
}
