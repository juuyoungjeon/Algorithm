import java.util.*;
import java.io.*;

public class Main {
	static int L, C;
	static int[] check;
	static char[] arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new char[C];
		check = new int[C];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(arr);
		dfs(0, 0);

	}

	public static void dfs(int level, int length) {
		if (length == L) {
			StringBuilder sb = new StringBuilder();
			int vowel = 0;
			int consonant = 0;

			for (int i = 0; i < C; i++) {
				if (check[i] == 1) {
					if (V(arr[i])) {
						vowel++;
					}else {
						consonant++;
					}
					sb.append(arr[i]);

				}
			}
			if (vowel >= 1 && consonant>=2) {
				System.out.println(sb);
			}
		}else {
			for (int i = level; i < C; i++) {
				check[i] = 1;
				dfs(i + 1, length + 1);
				check[i] = 0;
			}
		}
	}

	public static boolean V(char c) {
		if (c == 'a' || c == 'e' || c =='i' || c == 'o' || c== 'u'){
			return true;

		}else {
			return false;
		}

	}


}