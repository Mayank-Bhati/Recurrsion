public class longestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(lcs(27,12,"GEBEOCFUFTSXDIXTIGSIEEHKCHZ","DFLILRJQFNXZ"));
    }
    static int lcs(int x, int y, String s1, String s2){
        int[][] dp = new int[s1.length()][s2.length()];
        for(int i = 0; i < s1.length(); i++){
            for(int j = 0; j < s2.length(); j++){
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(j);
                if(i == 0 && j == 0){
                    if(c1 == c2)
                        dp[i][j] = 1;
                }
                else if(i == 0){
                    if(c1 == c2)
                        dp[i][j] = 1;
                    else
                        dp[i][j] = dp[i][j-1];
                }
                else if(j == 0){
                    if(c1 == c2)
                        dp[i][j] = 1;
                    else
                        dp[i][j] = dp[i-1][j];
                }
                else{
                    if(c1 == c2)
                        dp[i][j] = 1+dp[i-1][j-1];
                    else
                        dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[s1.length()-1][s2.length()-1];
    }
   static int util(String s1, String s2, int i, int j, int ans){
        if(i == s1.length()-1 || j == s2.length()-1)
            return ans;
        if(s1.charAt(i) == s2.charAt(j)){
            return util(s1,s2,i+1,j+1,ans+1);
        }
        else{
            return Math.max(util(s1,s2,i+1,j,ans),util(s1,s2,i,j+1,ans));
        }
    }
}
