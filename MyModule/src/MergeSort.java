import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] x = { 8, 0, 4, 7, 3, 7, 10, 12, -3 };
        System.out.println("Было");
        System.out.println(Arrays.toString(x));

        int low = 0;
        int high = x.length - 1;

        mergeSort(x, low, high);
        System.out.println("Стало");
        System.out.println(Arrays.toString(x));
    }

    private static void mergeSort(int[] arr, int left, int right) {

        if (left<right){

            int middle=(left+right)/2;
            mergeSort(arr,left,middle);
            mergeSort(arr,middle+1,right);

            merge(arr,left,right,middle);

        }


    }

    private static void merge(int[] arr, int left, int right, int middle) {

        int[] tempArray=new int[right-left+1];

        int iterLeft=left;
        int iterRight=middle+1;

        int iterSum=right-left+1;

        for (int i = 0; i <iterSum; i++) {
            //merging
            if (iterLeft<=middle &&(iterRight>right||arr[iterLeft]<=arr[iterRight]) ){
                tempArray[i]=arr[iterLeft];
                iterLeft++;
            }
            else{
                tempArray[i]=arr[iterRight];
                iterRight++;
            }

        }
        System.arraycopy(tempArray,0,arr,left,tempArray.length);

    }

}
