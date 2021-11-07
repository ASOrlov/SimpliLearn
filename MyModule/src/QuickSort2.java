public class QuickSort2 {

    private static void quickSort(int[] arr, int start, int end) {



        int i=start;
        int j=end;

        int referNumber=arr[(start+end)/2];

        do {

            while ((arr[i] < referNumber) && (i < end)) i++;
            while ((arr[j] > referNumber) && (j > start)) j--;

            if (i<=j) {

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;j--;

            }


        }

        while (i<=j);

        if (j>start) quickSort(arr,start,j);
        if (i<end) quickSort(arr,i,end);

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
