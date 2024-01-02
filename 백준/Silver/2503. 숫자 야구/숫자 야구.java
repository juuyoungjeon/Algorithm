import java.util.*;
import java.io.*;

public class Main {
	static class info{
		int strike, ball;
		String num;
		public info(String num, int strike, int ball) {
			this.num = num;
			this.strike = strike;
			this.ball = ball;
		}
	}
	static int N;
	static ArrayList<info> game = new ArrayList<>();
	static ArrayList<String> answer = new ArrayList<>();
	static boolean[] numUsing;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		numUsing = new boolean[10];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String num = st.nextToken();
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			game.add(new info(num, s, b));
		}
		
		search("", 0);
		sb.append(answer.size());
		System.out.println(sb);
	}
	private static void search(String num, int size) {
		if(size == 3) {
			numCheck(num);
			return;
		}
		for(int i = 1; i <= 9; i++) {
			if(!numUsing[i]) {
				numUsing[i] = true;
				search(num + i, size + 1);
				numUsing[i] = false;
			}
		}
	}
	private static void numCheck(String num) {
		for(info cur : game) {
			int s = 0;
			int b = 0;
			
			for(int i = 0; i < 3; i++) {
				if(cur.num.charAt(i) == num.charAt(i)) {
					s++;
				}
			}
			if(cur.strike != s) {
				return;
			}
			for(int i = 0; i < 3; i++) {
				int tmp = (i + 1) % 3;
				if(num.charAt(i) == cur.num.charAt(tmp)) {
					b++;
				}
				tmp = (i + 2) % 3;
				if(num.charAt(i) == cur.num.charAt(tmp)) {
					b++;
				}
			}
			
			if(cur.ball != b) {
				return;
			}
			if(cur.ball != b) return;
		}
		answer.add(num);
	}

}