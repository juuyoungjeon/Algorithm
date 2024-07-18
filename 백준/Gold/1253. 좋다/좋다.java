import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] arr;
	static boolean[] visited;
	static int cnt;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		arr = new int[N];
		visited = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

//		for(int i = 0; i < N; i++) {
//			int s = 0;
//			int e = N - 1;
//			int target = arr[i];
//			visited[i] = true;
//			while(s<=e) {
//				if(!visited[i]) {
//					int mid = (s+e)/2;
//					if(arr[s] + arr[e] > target) {
//						e = mid - 1;
//					}else if(arr[s] + arr[e] < target) {
//						s = mid + 1;
//					}else if(arr[s] + arr[e] == target) {
//						cnt++;
//						break;
//					}
//				}
//			}
//			visited[i] = false;
//		}
		Arrays.sort(arr);
		 for (int i = N - 1; i >= 0; i--) {
             int val = arr[i];
             boolean flag= false;
                 for (int j = N-1; j >= 0; j--) {

                     int l = 0;
                     int r = j - 1;
                     if(j == i)
                         continue;
                     while (l <= r) {
                         int mid = (l + r) / 2;
                         int val2 = val - arr[j];
                         if (arr[mid] > val2) {
                             r = mid - 1;
                         } else if (arr[mid] == val2 && mid != i && mid != j) {
                             flag = true;
                             break;
                         } else {
                             l = mid + 1;
                         }
                     }

                 }
                 if (flag)
                     cnt++;
         }
		System.out.println(cnt);
	}

}