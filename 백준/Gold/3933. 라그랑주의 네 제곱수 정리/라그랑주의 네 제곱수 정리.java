import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Set up: I/O
        Scanner sc = new Scanner(System.in);

        // Process
        int S = (1 << 15); // max(N) = 2^15 - 1
        int[][] dp = new int[S][5]; // dp[i][j] = j 개의 제곱수의 합으로 i 를 표현할 수 있는 경우의 수

        // dp 배열 초기화
        for (int i = 0; i < S; i++) {
            for (int j = 0; j < 5; j++) {
                dp[i][j] = 0;
            }
        }

        // 제곱수를 계산하여 dp 배열을 채움
        for (int i = 1; i * i < S; i++) {
            dp[i * i][1] = 1; // 그 자체로 이미 제곱수인 경우

            // 방법 1: 현재 i^2를 사용해서 j 를 만들 수 있는 경우의 수 계산
            for (int j = i * i; j < S; j++) {
                dp[j][2] += dp[j - i * i][1];
                dp[j][3] += dp[j - i * i][2];
                dp[j][4] += dp[j - i * i][3];
            }

            /* 방법 2: 이 부분은 주석 처리된 부분과 같아서 생략했음
             * for (int j = 1; j + i * i < S; j++) {
             *     dp[j + i * i][2] += dp[j][1];
             *     dp[j + i * i][3] += dp[j][2];
             *     dp[j + i * i][4] += dp[j][3];
             * }
             */
        }

        // Set up: Input
        while (true) {
            int N = sc.nextInt();
            if (N == 0) break;

            // Process
            int ans = 0; // 4개 이하의 제곱수의 합으로 N을 표현할 수 있는 경우의 수
            for (int i = 1; i <= 4; i++) {
                ans += dp[N][i];
            }

            // Control: Output
            System.out.println(ans);
        }

        sc.close();
    }
}