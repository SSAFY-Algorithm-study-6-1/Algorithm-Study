import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	
    	Scanner sc = new Scanner(System.in);
    	
        int n = sc.nextInt();
        int k = sc.nextInt();
        long top = factorial(n);
        long bottom = factorial(k) * factorial(n-k);
        System.out.print(top / bottom);
    }

    static long factorial(int n) {
        long ret = 1;
        while (n > 1) {
            ret *= n;
            n--;
        }
        return ret;
    }
}