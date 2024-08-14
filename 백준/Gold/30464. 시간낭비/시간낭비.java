import java.util.Scanner;
import java.util.Arrays;

public class Main {
    static final int N = 200001;
    static int n;
    static int[] a = new int[N];
    static int[][][] dp = new int[N][2][3];

    static int f(int u, int p, int q) {
        if (u < 1 || u > n) return Integer.MIN_VALUE;
        if (u == n) return 0;

        if (dp[u][p][q] != -1) return dp[u][p][q];

        dp[u][p][q] = Integer.MIN_VALUE;
        int dis = a[u] * (p == 1 ? -1 : 1);

        dp[u][p][q] = f(u + dis, p, q) + 1;
        if (q < 2) {
            dp[u][p][q] = Math.max(dp[u][p][q], f(u - dis, p ^ 1, q + 1) + 1);
        }

        return dp[u][p][q];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }

        for (int[][] arr2D : dp) {
            for (int[] arr1D : arr2D) {
                Arrays.fill(arr1D, -1);
            }
        }

        int ans = f(1, 0, 0);
        System.out.println(ans > 0 ? ans : -1);

        sc.close();
    }
}