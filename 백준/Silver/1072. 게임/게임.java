import java.util.*;
import java.io.*;

public class Main {
	static int X, Y;
	static int cnt;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
		int Z = getPercent(X,Y);
		
		int s = 0;
		int e = (int)1e9;
		int ans = -1;
		
		while(s<=e) {
			int mid = (s+e)/2;
			if(getPercent(X + mid, Y + mid) != Z) {
				ans = mid;
				e = mid - 1;
			}else {
				s = mid + 1;
			}
		}
		
		System.out.println(ans);
	}
	static int getPercent(int x, int y) {
		return (int)((long) y * 100 / x);
	}

}