import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,2,3};
        System.out.println(lengthOfLIS(nums));
    }
    public static int lengthOfLIS(int[] nums) {
        int ans = 1, max = 0;
        int[][] arr = new int[nums.length][1];
        for(int i = 0; i < nums.length; i++){
            int curr = (arr[i][0] == 0)?1:arr[i][0];
            max = 1;
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i] ){
                    if(arr[j][0]+curr > max)
                        max = arr[j][0]+curr ;
                }
            }
            if(max > ans)
                ans = max;
            arr[i][0] = max;
        }
        return ans;
    }
}
