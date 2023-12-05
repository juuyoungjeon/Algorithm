import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		char[] arr = new char[s.length()];
		for(int i = 0; i < s.length(); i++) {
			arr[i] = s.charAt(i);
		}
		
		int k = Integer.parseInt(br.readLine());
		
		System.out.println(arr[k-1]);
	}
}