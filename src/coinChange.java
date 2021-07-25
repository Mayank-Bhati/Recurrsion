import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class coinChange {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChanger(coins, amount));
    }

    public static int coinChanger(int[] coins, int amount) {
        int ans = 0;
        Arrays.sort(coins);
        return helper(coins, amount, 0, 0);
    }

    static int helper(int[] coins, int amount, int i, int ans) {
        if (i == coins.length || amount <= 0 || coins[i] > amount)
            return ans;
        int temp = ans;
        int ans1 = helper(coins, amount - coins[i], i, temp + 1);
        int ans2 = helper(coins, amount - coins[i], i + 1, temp + 1);
        int ans3 = helper(coins, amount, i + 1, temp);
        int min = Math.min(ans1, ans2);
        ans = Math.min(ans3, min);
        return -1;
    }
}
