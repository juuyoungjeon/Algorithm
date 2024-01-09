import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Main {
    static final int MAX = 1000000;
    static boolean[] isPrime = new boolean[MAX + 1];
    static int[] visited = new int[MAX + 1];

    public static void SieveOfEratosthenes() {
        for (int i = 2; i <= MAX; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i <= MAX; i++) {
            if (!isPrime[i]) continue;
            for (int j = i * i; j <= MAX; j += i) {
                isPrime[j] = false;
            }
        }
    }

    public static int power(int x, int y) {
        int res = 1;
        while (y > 0) {
            if (y % 2 == 1) {
                res = res * x;
            }
            y /= 2;
            x = x * x;
        }
        return res;
    }

    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);

        SieveOfEratosthenes();
        int n = scanner.nextInt();
        ArrayList<Integer> plist = new ArrayList<>();
        for (int i = 1; i <= MAX; i++) if (isPrime[i]) plist.add(i);

        ArrayList<ArrayList<Integer>> v = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>(Collections.nCopies(plist.size(), 0));
            int score = scanner.nextInt();
            for (int j = 0; j < plist.size(); j++) {
                if (score == 1) break;
                while (score % plist.get(j) == 0) {
                    score /= plist.get(j);
                    visited[plist.get(j)]++;
                    row.set(j, row.get(j) + 1);
                }
            }
            v.add(i, row);
        }

        int gcd = 1;
        int cnt = 0;
        for (int i = 0; i < plist.size(); i++) {
            int d = visited[plist.get(i)] / n;
            for (int j = 0; j < n; j++) {
                if (v.get(j).get(i) < d) {
                    cnt += d - v.get(j).get(i);
                }
            }
            gcd *= power(plist.get(i), d);
        }

        System.out.println(gcd + " " + cnt);

        scanner.close();
    }
}