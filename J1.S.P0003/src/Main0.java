import java.util.Scanner;

public class Main0 {
    public static final Scanner sc = new Scanner(System.in);
    private static int checkInputInt(){
        while(true){
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                return result;
            }catch (NumberFormatException e){
                System.out.println("Please enter an integer");
                System.out.print("Enter again: ");
            }
        }
    }

    private static int inputSizeOfArray(){
        System.out.print("Enter number of array: ");
        int n = checkInputInt();
        return n;
    }

    private static int[] inputValuesOfArray(int n){
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            System.out.print("Enter a["+ i + "]: ");
            a[i] = checkInputInt();
        }
        return a;
    }

    //sort by buddle sort
    private static void sortArrayByInsectionSort(int[] a){
        int len = a.length;
        System.out.print("Unsorted Array: ");
        for(int i = 0; i < len; i++){
            System.out.print(a[i] + " ");
        }
        for(int i = 1; i < len; i++){
            for(int j = i; j < len; j++){
                if(a[j] < a[j - 1]){
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }
        System.out.println();
    }

    private static void print(int[] a){
        System.out.print("Sorted Array: ");
        for(int i = 0; i < a.length; i++){
            System.out.println(a[i] + " ");
        }
    }

    public static void main(String[] args) {
        int n = inputSizeOfArray();
        int[] a = inputValuesOfArray(n);
        sortArrayByInsectionSort(a);
        print(a);
    }
}
