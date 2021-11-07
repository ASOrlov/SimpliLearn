public class QuickSort1 {

    private static void quickSort(int[] arr, int start, int end) {

        int countLess=start-1;
        int referNumber=arr[end];

        if (start<end) {

            for (int i = start; i <end ; i++) {
                if (arr[i]<referNumber) {
                    countLess++;
                    int temp = arr[i];
                    arr[i] = arr[countLess];
                    arr[countLess] = temp;
                }
            }

            int temp = arr[end];
            arr[end] = arr[countLess+1];
            arr[countLess+1] = temp;

            quickSort(arr, start, countLess );
            quickSort(arr, countLess + 2, end);

        }
    }


    public static void main(String[] args) {
        int[] arr={34, 5, 67, 68, -45, -879, 345,-56, 19848,5, 9,857,77878,-2};

        for (int i : arr) {
            System.out.print(i+" ");
        }

        System.out.println();

        quickSort(arr,0,arr.length-1);

        for (int i : arr) {
            System.out.print(i+" ");
        }


    }




}
