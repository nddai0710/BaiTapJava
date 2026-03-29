import java.util.Scanner;

public class Main0 {
    public static final Scanner sc = new Scanner(System.in);
    private static int checkInputInt(){
        while(true){
            try{
                int result = Integer.parseInt(sc.nextLine().trim());
                return result;
            }catch (NumberFormatException e){
                System.out.println("Please enter a number");
                System.out.print("Enter again: ");
            }
        }
    }

    private static int inputSizeOfArray(){
        System.out.print("Enter number of array: ");
        int n = checkInputInt();
        return n;
    }

    private static int[] inputValueOfArray(int n){
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            System.out.print("Enter a[" + i + "]: ");
            a[i] = checkInputInt();
        }
        return a;
    }

    private static void sortArrayBySectionSort(int[] a){
        int len = a.length;
        System.out.print("Unsorted Array: ");
        for(int i = 0; i < len; i++){
            System.out.print(a[i] + " ");
        }

        for(int i = 0; i < len - 1; i++){
            int minIndex = i;
            for(int j = i + 1; j < len; j++){
                if(a[j] < a[minIndex]){
                    minIndex = j;
                }
            }
            if(minIndex != i){
                int temp = a[minIndex];
                a[minIndex] = a[i];
                a[i] = temp;
            }
            if(i==1) break;
        }
        System.out.println();
    }
    private static void print(int[] a){
        System.out.print("Sorted Array: ");
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String[] args) {
        int n = inputSizeOfArray();
        int[] a = inputValueOfArray(n);
        sortArrayBySectionSort(a);
        print(a);
    }
}
