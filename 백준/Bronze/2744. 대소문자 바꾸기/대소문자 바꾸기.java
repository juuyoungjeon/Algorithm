import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();
		char[] arr = s.toCharArray();
		
		for(int i = 0; i < s.length(); i++) {
			if(Character.isUpperCase(arr[i])) {
				sb.append(Character.toLowerCase(arr[i]));
			}else {
				sb.append(Character.toUpperCase(arr[i]));
			}
		}
		
		System.out.println(sb);
	}

}