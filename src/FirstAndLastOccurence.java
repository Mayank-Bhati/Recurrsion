public class FirstAndLastOccurence {
    public static void main(String[] args) {
        int[] ar = {4,2,1,5,2,7,8};
        System.out.println(firstOcc(ar,2,0));
        System.out.println(lastOcc(ar,2,0));
    }
    static int firstOcc(int[] arr, int key, int index){
        if(index == arr.length)
            return -1;
        if(arr.length == 1 && arr[0] == key)
            return 0;
        else if(arr[index] == key)
            return index;
        else
            return firstOcc(arr,key,index+1);
    }
    static int lastOcc(int[] arr, int key, int index){
        if(index >= arr.length)
            return -1;
        int restArr = lastOcc(arr,key,index+1);
        if(restArr == -1)
            return arr[index] == key?index:-1;
        else
            return restArr;
    }
}
