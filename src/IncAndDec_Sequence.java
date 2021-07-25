public class IncAndDec_Sequence {
    public static void main(String[] args) {
        inc(4);
        System.out.println();
        dec(4);
    }
    static void inc(int n){
        if(n == 0)
            return ;
            inc(n-1);
        System.out.print(n+" ");
    }
    static void dec(int n){
        if(n == 0)
            return ;
        System.out.print(n+" ");
        dec(n-1);
    }
}
