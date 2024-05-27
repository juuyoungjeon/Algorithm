import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line = br.readLine();
		String bomb = br.readLine();
		int N = line.length();
		int M = bomb.length();

		Stack<Character> s = new Stack<>();

		for(int i = 0; i < N; i++) {
			s.push(line.charAt(i));

			if(s.size() >= M) {
				boolean flag = true;

				for(int j = 0; j < M; j++) {
					if(s.get(s.size() - M + j) != bomb.charAt(j)) {
						flag = false;
						break;
					}
				}
				if(flag) {
					for(int j = 0; j < M; j++) {
						s.pop();
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(Character c : s) {
			sb.append(c);
		}
		System.out.println(sb.length()==0 ? "FRULA" : sb);
	}

}