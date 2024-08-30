import java.util.*;
import java.io.*;

public class Main {
	static int G;
	//G = (현재몸무게)^2 - (기억몸무게)^2
	static int cnt;
	static ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		G = Integer.parseInt(br.readLine());
		
		int s = 1;//기억
		int e = 2;//현재
		int sum = 0;
		boolean check = false;
		while(s < e && e < G) {
			sum = (e + s)*(e - s);//e*e-s*s
			if(sum == G) {
				list.add(e);
				check = true;
				s++;
				e++;
			}else if(sum > G) {
				s++;
			}else if(sum < G) {
				e++;
			}
		}
		//처음과 끝
		
		Collections.sort(list);
		for(int i : list) {
			sb.append(i).append("\n");
		}
		if(check) {
			System.out.println(sb);
		}else {
			System.out.println(-1);
		}
		
	}

}