public class fibonacciAndFactorial {
    public static void main(String[] args) {
        System.out.println(fibb(5));
        System.out.println(fact(5));
    }
    static int fibb(int n){
        if(n == 1 || n == 2)
            return 1;
        else
            return fibb(n-1) + fibb(n-2);
    }
    static int fact(int n){
        if(n == 0 || n == 1)
            return 1;
        else
            return n*fact(n-1);
    }
}
