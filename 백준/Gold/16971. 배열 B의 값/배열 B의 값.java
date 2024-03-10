import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    static int[][] A;
    static int N;
    static int M;
    static int max;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        A = new int[N][M];
        max = 0;

        for(int i=0; i<N; i++) {
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++)
                A[i][j] = Integer.parseInt(input[j]);
        }

        for(int i=0; i<N-1; i++) {
            for (int j=0; j<M-1; j++) {
                max += (A[i][j] + A[i+1][j] + A[i+1][j+1] + A[i][j+1]);
            }
        }

        if(N>2) {
            int min_row = -1;
            int sum_row = Integer.MAX_VALUE;

            for(int i=1; i<N-1; i++) {
                int sum = 0;
                for (int j=0; j<M; j++) {
                    sum += A[i][j];
                }
                sum = 4*sum - 2*(A[i][0] + A[i][M-1]);

                if(sum<sum_row) {
                    sum_row = sum;
                    min_row = i;
                }
            }

            rotate(min_row, 0, true);
            rotate(min_row, N-1, true);

        }

        if(M>2) {
            int min_col = -1;
            int sum_col = Integer.MAX_VALUE;

            for(int j=1; j<M-1; j++) {
                int sum = 0;
                for (int i=0; i<N; i++) {
                    sum += A[i][j];
                }
                sum = 4*sum - 2*(A[0][j] + A[N-1][j]);

                if(sum<sum_col) {
                    sum_col = sum;
                    min_col = j;
                }
            }

            rotate(min_col, 0, false);
            rotate(min_col, M-1, false);
        }

        System.out.println(max);
    }

    public static void rotate(int x, int y, boolean flag) {
        int[][] a = new int[N][M];

        if(flag) {
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(i==x)
                        a[y][j] = A[i][j];

                    else if(i==y)
                        a[x][j] = A[i][j];

                    else
                        a[i][j] = A[i][j];
                }
            }
        }

        else {
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(j==x)
                        a[i][y] = A[i][j];

                    else if(j==y)
                        a[i][x] = A[i][j];

                    else
                        a[i][j] = A[i][j];
                }
            }
        }

        int sum = 0;

        for(int i=0; i<N-1; i++) {
            for (int j=0; j<M-1; j++) {
                sum += (a[i][j] + a[i+1][j] + a[i+1][j+1] + a[i][j+1]);
            }
        }
        max = Math.max(sum, max);
    }
}