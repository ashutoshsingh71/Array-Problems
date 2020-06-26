import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter array size:");
        int size = scn.nextInt();
        int [] arr = new int[size];
        for(int i = 0 ; i< size; i++){
            System.out.println("Enter element: ");
            arr[i] = scn.nextInt();
        }
        System.out.println("Enter number of rotations: ");
        int times = scn.nextInt();
        System.out.println("Your array is:");
        printArray(arr);
        int [] arrcopy1 = copyofArray(arr);
        System.out.println();
        System.out.println("After " +times + " times left rotation, Array is:");
        rotateArrayByOneLeft(arrcopy1,times);
        printArray(arrcopy1);
        System.out.println();
        int [] arrcopy2 = copyofArray(arr);
        System.out.println("After " +times +  " times right rotation, Array is:");
        rotateArrayByOneRight(arrcopy2,times);
        printArray(arrcopy2);
    }

    private static int[] copyofArray(int[] arr) {
        int size = arr.length;
        int[] arrcopy = new int[size];
        for(int i = 0; i< size; i++){
            arrcopy[i] = arr[i];
        }
        return arrcopy;
    }

    private static void rotateArrayByOneLeft(int[] arr, int times) {
        for(int i=0;i<times;i++){
            int temp = arr[0];
            for(int j = 0;j<(arr.length -1) ;j++){
                arr[j] = arr[j+1];
            }
            arr[arr.length-1] = temp;
        }
    }

    private static void rotateArrayByOneRight(int[] arr, int times) {
        for(int i=0;i<times;i++){
            int temp = arr[arr.length-1];
            for(int j = arr.length-2;j>=0;j--){
                arr[j+1] = arr[j];
            }
            arr[0] = temp;
        }
    }
    private static void printArray(int[] arr) {
        for(int i:arr){
            System.out.print(i + " ");
        }
    }

    //Method1 using temp array
    //time complexity = O(n)
    //space complexity = O(n)
    public static void rotateArray(int []arr, int times){
        //store times number of elements in a temp array
        if(arr.length == 1){
            return;
        }
        int [] temp = new int[times];
        for(int i=0; i<times;i++){
            temp[i] = arr[i];
        }
        //shifting rest of the arr elements by 1
        int start = times;
        int end = arr.length;
        int index = 0;
        for(int j=start;j<end;j++){
            arr[index] = arr[j];
            index += 1;
        }
        //copy temp array into original array
        start = end-times;
        int k = 0;
        for(;start<end;start++){
            arr[start] = temp[k];
            k++;
        }
    }
}
