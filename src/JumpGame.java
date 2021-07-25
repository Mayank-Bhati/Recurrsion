public class JumpGame {
    public static void main(String[] args) {
        int[] a = {4,2,0,0,1,1,4,4,4,0,4,0};
        System.out.println(canJump(a));
    }

    public static boolean canJump(int[] nums) {
        int i = 0;
        while (i < nums.length - 1) {
            int j = nextInd(nums, i, nums[i]);
            if (j == i)
                return false;
            else
                i = j;
        }
        return true;
    }

    public static int nextInd(int[] nums, int start, int jump) {
        int maxInd = start, max = 0;
        if((start+jump+1) >= nums.length)
            return nums.length-1;
        for (int i = start + 1; i <= start+jump; i++) {
            if (nums[i] >= max) {
                max = nums[i];
                maxInd = i;
            }
        }
        return maxInd;
    }
}
