import java.util.Scanner;

public class Main {
    static int[][] arr;
    static int[] gomduri;
    static int ans = 255 + 255 + 255;
    static int N;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        arr = new int[N][3];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        gomduri = new int[]{scanner.nextInt(), scanner.nextInt(), scanner.nextInt()};
        Munduri(0, 0, 0, 0, 0);
        System.out.println(ans);
    }

    static void Munduri(int idx, int K, int R, int G, int B) {
        if (K > 1) {
            int r = gomduri[0];
            int g = gomduri[1];
            int b = gomduri[2];
            int rr = R / K;
            int gg = G / K;
            int bb = B / K;
            ans = Math.min(Math.abs(r - rr) + Math.abs(g - gg) + Math.abs(b - bb), ans);
        }

        if (K == 7) {
            return;
        }

        for (int i = idx; i < N; i++) {
            int r = arr[i][0];
            int g = arr[i][1];
            int b = arr[i][2];
            Munduri(i + 1, K + 1, R + r, G + g, B + b);
        }
    }
}