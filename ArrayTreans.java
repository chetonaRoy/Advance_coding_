import java.util.*;

public class ArrayTreans {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int K = sc.nextInt();

        int mod = A[0] % K;
        for (int i = 1; i < N; i++) {
            if (A[i] % K != mod) {
                System.out.println(-1);
                return;
            }
        }

        int[] B = new int[N];
        for (int i = 0; i < N; i++) {
            B[i] = A[i] / K;
        }

    
        Arrays.sort(B);
        int median = B[N / 2];

       
        long operations = 0;
        for (int i = 0; i < N; i++) {
            operations += Math.abs(B[i] - median);
        }

        System.out.println(operations);

        sc.close();
    }
}
