import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = -1000; i <= 1000; i++) {
			if(i*i + 2*a*i + b == 0) {
				list.add(i);
			}
		}
		
		Collections.sort(list);
		for(int i = 0; i < list.size(); i++) {
			sb.append(list.get(i) + " ");
		}
		
		System.out.println(sb);
	}

}