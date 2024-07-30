import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String a = br.readLine();
		String b = br.readLine();
		String c = br.readLine();
		
		String k = a+b;
		
		int first = Integer.parseInt(a);
		int second = Integer.parseInt(b);
		int third = Integer.parseInt(c);
		int plus = Integer.parseInt(k);
		
		sb.append(first + second - third).append("\n");
		sb.append(plus - third).append("\n");
		
		System.out.println(sb);
	}

}