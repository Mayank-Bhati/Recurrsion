public class longestSubarrayBySum {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 0, 0, 0, 6, 7, 8, 9, 10};
        int[] out = new int[2];
        out = findLongestSubarrayBySum(15,a);
        for(int x : out)
            System.out.println(x);
    }
    static int[] findLongestSubarrayBySum(int s, int[] arr) {
        int[] out = new int[2];
        int p = 0, sum = 0, l = 0;
        for(int i = 0; i < arr.length; i++){
            while(sum + arr[i] > s){
                sum -= arr[p];
                p++;
            }
            if(sum + arr[i] == s){
                if(i-p+1 > l){
                    l = i-p+1;
                    out[0] = p+1;
                    out[1] = i+1;
                }
            }
                sum += arr[i];
        }
        return out;
    }
}
