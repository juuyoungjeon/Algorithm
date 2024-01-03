import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long k = Long.parseLong(br.readLine());
		
		int c = 2;
		int cnt = 0;
		List<String> list = new ArrayList<>();
		while(k != 1) {
			if (c>=1000000) {
				list.add(k+"");
				cnt++;
				break;
			}
			if (k % c == 0) {
				k/=c;
				cnt++;
				list.add(c+"");
			}
			else {
				c++;
			}
		}
		
		
		System.out.println(cnt);
		System.out.println(String.join(" ", list));
		
	}

}