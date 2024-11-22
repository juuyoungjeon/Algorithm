import java.util.*;
import java.io.*;

public class Main {

	public static int n,m;
	public static HashSet<String> hs = new HashSet<String>();
	public static ArrayList<String> ans = new ArrayList<String>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		for(int i = 0; i< n;i++) {
			hs.add(br.readLine());
		}
		for(int i = 0; i < m; i++) {
			String s = br.readLine();
			if(hs.contains(s)) {
				ans.add(s);
			}
		}
		Collections.sort(ans);
		System.out.println(ans.size());
		for(int i = 0; i < ans.size(); i++) {
			System.out.println(ans.get(i));
		}
	}

}
