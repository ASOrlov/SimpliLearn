public class SortTest {


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

    private static void quickSort(int[] arr, int left,  int right) {

        if (left < right){


           int refer = arr[right];
            int moreThenReferIterator = left-1;

            for (int i = left; i < right; i++) {
                if (arr[i] < refer) {
                    moreThenReferIterator++;
                    if (i != moreThenReferIterator) {
                        int temp = arr[i];
                        arr[i] = arr[moreThenReferIterator];
                        arr[moreThenReferIterator] = temp;
                    }
                }

            }

            int temp = arr[right];
            arr[right] = arr[moreThenReferIterator + 1];
            arr[moreThenReferIterator + 1] = temp;

            quickSort(arr, left, moreThenReferIterator);
            quickSort(arr, moreThenReferIterator + 2, right);

        }
    }

    private static void quickSort1(int[] arr, int left,  int right) {

        //Iterators
        int i=left;
        int j=right;

        //refer
        int refer=arr[(right+left)/2];


        do{
            while ((arr[i]<refer)&&(i<right)) i++;
            while ((arr[j]>refer)&&(j>left)) j--;

            if (i<=j){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;j--;
            }

        }
        while (i<=j);

        if (j>left) quickSort1(arr,left,j);
        if (i<right) quickSort1(arr,i,right);


    }


}
