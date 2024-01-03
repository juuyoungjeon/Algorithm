import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();
		
		char[] n = s.toCharArray();

		boolean isPrime = true;
		boolean isPrime2 = true;
		
		for(int i = 0; i < s.length(); i++) {
			if(n[i] == '3' || n[i] == '4' || n[i] == '7') {
				isPrime = false;
				break;
			}else if(n[i] == '6') {
				n[i] = '9';
			}else if(n[i] == '9') {
				n[i] = '6';
			}
		}
		char[] n2 = new char[n.length];
		
		for (int i = 0; i < n.length; i++) {
	        n2[i] = n[n.length - 1 - i];
	    }
		
		long a = Long.parseLong(String.valueOf(n2));
		
		if(a == 1) isPrime = false;
		
		for(long i = 2; i <= (long)Math.sqrt(a); i++) {
			if(a % i == 0) {
				
				isPrime = false;
				
				break;
			}
		}
		
		long a2 = Long.parseLong(String.valueOf(s));
		for(long i = 2; i <= (long)Math.sqrt(a2); i++) {
			if(a2 % i == 0) {
				
				isPrime2 = false;
				
				break;
			}
		}
		//System.out.println(a);
		if(isPrime && isPrime2) {
			System.out.println("yes");
		}else {
			System.out.println("no");
		}
		
	}

}