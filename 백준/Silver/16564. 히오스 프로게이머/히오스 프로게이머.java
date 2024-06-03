import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Integer.MAX_VALUE;
        long max = Integer.MAX_VALUE;
        long result = 0;

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int arr[] = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
           	//배열에서 가장 작은값 저장
            min = Math.min(min, arr[i]);
        }

        while (min <= max) {
            long mid = (min + max) / 2;
            long sum = 0;

            for (int i = 0; i < N; i++) {
                if (mid >= arr[i]) {
                    sum += mid - arr[i];
                }
            }

            if (sum <= K) {
                result = Math.max(result, mid);
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        System.out.println(result);
    }
}