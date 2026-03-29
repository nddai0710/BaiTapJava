import java.util.Scanner;

public class Main {
    public static final Scanner sc = new Scanner(System.in);

    private static int checkInput(){
        while(true){
            try{
                int result = Integer.parseInt(sc.nextLine());
                return result;
            }catch (NumberFormatException e){
                System.out.println("Please enter a number");
                System.out.print("Enter again: ");
            }
        }
    }

    //nhap so vao mang
    private static int inputSizeOfArray(){
        System.out.print("Enter number of array: ");
        int n = checkInput();
        return n;
    }

    private static int[] inputValueofArray(int n){
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            System.out.print("Enter a[" + i +"]: ");
            a[i] = checkInput();
        }
        return a;
    }

    //doi 2 so
    private static void swap(int a, int b){
        int temp = a;
        a = b;
        b = temp;
        System.out.println("Hello");
    }

    private static void sortArrayByBubbleSort(int[] a){
        System.out.print("Unsorted Array: ");
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < a.length - i - 1; j++){
                if (a[j] > a[j + 1]){
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
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
        int[] a = inputValueofArray(n);
        sortArrayByBubbleSort(a);
        print(a);
    }
}