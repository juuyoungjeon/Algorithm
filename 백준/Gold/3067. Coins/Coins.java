import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static int[][] memo;
    private static int[] coins;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            input();

            bw.write(solve());
        }

        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        sb.append(topDown(N, M)).append('\n');
        return sb.toString();
    } // End of solve()

    private static int topDown(int n, int m) {
        if (m == 0) return 1;
        if (n <= 0 || m < 0) return 0; // 사용할 수 있는 동전이 없거나, 금액을 만들 수 없는 경우

        if (memo[n][m] != -1) return memo[n][m];

        // 현재 선택된 동전을 사용하는 경우 + 사용하지 않는 경우
        memo[n][m] = topDown(n, m - coins[n - 1]) + topDown(n - 1, m);

        return memo[n][m];
    } // End of topDown()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        coins = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        memo = new int[N + 1][M + 1];

        for (int i = 0; i <= N; i++) {
            Arrays.fill(memo[i], -1);
        }
    } // End of input()
} // End of Main