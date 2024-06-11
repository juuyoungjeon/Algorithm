import java.util.*;
import java.io.*;

public class Main {
	static int G;
	static ArrayList<Integer> list;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		G = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
		
		int s = 2, e = 1;
		boolean check = false;
		while(e < s && s < G) {
			if((s+e)*(s-e) == G) {
				sb.append(s).append("\n");
				check = true;
			}
			
			if((s+e)*(s-e) > G) {
				e++;
			}else {
				s++;
			}
		}
		
		if(check) {
			System.out.println(sb);
		}else {
			System.out.println(-1);
		}

	}

}