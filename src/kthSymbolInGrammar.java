public class kthSymbolInGrammar {
    public static void main(String[] args) {
        System.out.println(kthGrammar(2, 2));
    }

    /*On the first row, we write a 0. Now in every subsequent row, we look at the
     previous row and replace each occurrence of 0 with 01, and each occurrence of
      1 with 10.
     Given row N and index K, return the K-th indexed symbol in row N.
     (The values of K are 1-indexed.) (1 indexed).*/
    public static int kthGrammar(int N, int K) {
        if (N == 1)
            return 0;
        int l = (int) Math.pow(2, N - 1);
        return (K <= l / 2) ? kthGrammar(N - 1, K) : (kthGrammar(N - 1, K - l / 2) == 0) ? 1 : 0;
    }
}
