//import java.util.Scanner;
//
//public class codeChef {
//    public static void main (String[] args) throws java.lang.Exception
//    {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        for(int i = 0; i < t; i++){
//            int D = sc.nextInt();
//            int d = sc.nextInt();
//            int P = sc.nextInt();
//            int Q = sc.nextInt();
//            int totalCount = 0, money  = 0, inc = P;
//            while(totalCount < D){
//                int count = 0;
//                while(count < d && totalCount < D){
//                    money += inc;
//                    count++;
//                    totalCount++;
//                }
//                inc += Q;
//            }
//            System.out.println(money);
//        }
//    }
//}
/* package codechef; // don't place package name! */
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
/* package codechef; // don't place package name! */
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class codeChef
{
    public static void main (String[] args) throws java.lang.Exception
    {
        try{
            Scanner s = new Scanner(System.in);
            long t = s.nextLong();
            for(int i = 0; i < t; i++){
                Scanner sc = new Scanner(System.in);
                long D = sc.nextLong();
                long d = sc.nextLong();
                long p = sc.nextLong();
                long q = sc.nextLong();
                long x = D/d;
                long money = 0;
                money += d*((x/2)* (2*p+(x-1)*q));
                money += (D%d)*(p + x*q);
                System.out.println(money);
            }
        }catch(Exception e){
            return ;
        }
    }
}




