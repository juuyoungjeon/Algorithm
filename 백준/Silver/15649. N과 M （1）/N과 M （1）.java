import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static int[] result;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		result = new int[M];
		isSelected = new boolean[N];
		
		perm(0);
	}

	private static void perm(int cnt) {
		if(cnt == M) {
			for(int i = 0; i < M; i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!isSelected[i]) {
				isSelected[i] = true;
				result[cnt] = i + 1;
				
				perm(cnt + 1);
				isSelected[i] = false;
			}
		}
	}

}