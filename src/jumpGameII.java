public class jumpGameII {
    public static void main(String[] args) {
        int[] nums = {2,3,0,1,4};
        System.out.println(jump(nums));
    }
    public static int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[n-1] = 0;
        for(int i = n-2;i >= 0; i--){
            int min = Integer.MAX_VALUE-10;
            for(int j = 1; j <= nums[i] && i+j < n;j++){
                if(dp[i+j] < min)
                    min = dp[i+j];
            }
            dp[i] = 1+min;
        }
        return dp[0];
    }
}
