import java.io.*;
import java.util.*;

public class Main {
    static long[][][][] dp = new long[1001][3][3][2];
    static long mod = 1000000007;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    Arrays.fill(dp[i][j][k], -1);
                }
            }
        }

        System.out.println(solve(0, 0, false, 0));
    }

    static long solve(int now, int state, boolean flag, int laststate) {
        long ref = dp[now][state][laststate][flag ? 1 : 0];

        if (now == N - 1) {
            if (flag)
                return dp[now][state][laststate][flag ? 1 : 0] = 1;
            else
                return dp[now][state][laststate][flag ? 1 : 0] = 0;
        }
        
        if (ref != -1)
            return ref;

        ref = 0;

        if (state == 0) {
            ref += solve(now + 1, 0, flag, state) % mod;
            ref += solve(now + 1, 1, flag, state) % mod;
            ref += solve(now + 1, 2, true, state) % mod;
        } else if (state == 1) {
            if (laststate == 0) {
                ref += solve(now + 1, 0, flag, state) % mod;
                ref += solve(now + 1, 1, flag, state) % mod;
                ref += solve(now + 1, 2, true, state) % mod;
            } else {
                ref += solve(now + 1, 0, flag, state) % mod;
            }
        } else if (state == 2) {
            if (laststate == 0) {
                ref += solve(now + 1, 0, flag, state) % mod;
                ref += solve(now + 1, 1, flag, state) % mod;
            } else {
                ref += solve(now + 1, 0, flag, state) % mod;
            }
        }
        
        return dp[now][state][laststate][flag ? 1 : 0] = ref % mod;
    }
}