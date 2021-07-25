public class sortedArray {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6,89,96};
        System.out.println(checkSortedArray(arr,0));
    }
    static boolean checkSortedArray(int[] arr, int index){
        if(index >= arr.length-1 || arr.length == 1)
            return true;
        else if(arr[index] < arr[index+1]){
            return checkSortedArray(arr,index+1);
        }
        else
            return false;
    }
}
