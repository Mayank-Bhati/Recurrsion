import java.math.BigInteger;

public class productExceptSelf {
   /* You have an array nums. We determine two functions to perform on nums. In both cases, n is the length of nums:

    fi(nums) = nums[0] · nums[1] · ... · nums[i - 1] · nums[i + 1] · ... · nums[n - 1]. (In other words, fi(nums) is the product of all array elements except the ithf.)
    g(nums) = f0(nums) + f1(nums) + ... + fn-1(nums).
    Using these two functions, calculate all values of f modulo the given m. Take these new values and add them together to get g. You should return the value of g modulo the given m.

    Example

    For nums = [1, 2, 3, 4] and m = 12, the output should be
    productExceptSelf(nums, m) = 2.

    The array of the values of f is: [24, 12, 8, 6]. If we take all the elements modulo m, we get:
            [0, 0, 8, 6]. The sum of those values is 8 + 6 = 14, making the answer 14 % 12 = 2.*/
    public static void main(String[] args) {
        int[] arr = {27, 37, 47, 30, 17, 6, 20, 17, 21, 43, 5, 49, 49, 50, 20, 42, 45, 1, 22, 44};
        System.out.println(productExceptSelf(arr,40));
    }


static BigInteger productOfAll(int[] nums) {
    BigInteger result = BigInteger.valueOf(1);
    for (int i = 0; i < nums.length; i++) {
        result = result.multiply(BigInteger.valueOf(nums[i]));
    }
    return result;
}

static int productExceptSelf(int[] nums, int m) {
    BigInteger productOfAll = productOfAll(nums);
    BigInteger sum = BigInteger.valueOf(0);
    BigInteger modulo = BigInteger.valueOf(m);
    for (int i = 0; i < nums.length; i++) {
        BigInteger productExceptSelf = productOfAll.divide(BigInteger.valueOf(nums[i]));
        sum = sum.add(productExceptSelf.mod(modulo));
    }
    return sum.mod(modulo).intValue();
}
   /* int productExceptSelf(int[] nums, int m) {
        int n = nums.length;
        int[] prodLeft = new int[n];
        int[] prodRight = new int[n];
        prodLeft[0] = 1;
        prodRight[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            prodLeft[i] = (prodLeft[i - 1] * nums[i - 1]) % m;
            prodRight[n - i - 1] = (prodRight[n - i] * nums[n - i]) % m;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (sum + prodLeft[i] * prodRight[i]) % m;
        }
        return sum;
    }*/
  /*static int productExceptSelf(int[] nums, int m) {
        long prod = 1;
        for(int i = 0; i < nums.length; i++){
            prod *= nums[i];
        }
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += ((int)prod/nums[i])%m;
        }
        return sum%m;
    }*/
}
