import java.util.*;
import java.io.*;

public class Main {
	static long N;
	static long q;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Long.parseLong(br.readLine());
		
		q = (long)Math.sqrt(N);
		
		if(Math.pow(q, 2) < N) q++;
		
		System.out.println(q);
		
	}

}