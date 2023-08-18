public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean ERATOSTHENES[] = new boolean[1299710];
        for(int i=2; i<1299710; i++)
            for(int j=i; i*j>2 && i*j<1299710; j++)
                ERATOSTHENES[i*j] = true;
        
        int t = sc.nextInt();
        while(t-->0) {
            int k = sc.nextInt();
            if(ERATOSTHENES[k]) {
                int s = k;
                int e = k;
                while(true) {
                    if(!ERATOSTHENES[--s]) break;
                }
                while(true) {
                    if(!ERATOSTHENES[++e]) break;
                }
                System.out.println(e-s);
            } else System.out.println(0);
        }
    }
}