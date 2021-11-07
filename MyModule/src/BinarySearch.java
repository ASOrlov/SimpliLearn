public class BinarySearch {

    private static boolean binarySearch(int[] arr, int start, int end, int number) {



        if (end>=start) {
            int mid = (end+start)/2;
            if (arr[mid] == number)
                return true;
            else {
                if (number > arr[mid]) return binarySearch(arr, mid + 1, end, number);
                else return binarySearch(arr, start, mid - 1, number);
            }
        }
        else
            return false;


    }


    public static void main(String[] args) {
        int[] arr={1,3,8,12,57,98,300, 457,987,12345,56678};
        System.out.println(binarySearch(arr,0,arr.length-1,12345));
    }



}
