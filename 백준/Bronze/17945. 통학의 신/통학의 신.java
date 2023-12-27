import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int C = (int)(-A + Math.sqrt(A*A - B));
		int D = (int)(-A - Math.sqrt(A*A - B));
		
		if(C > D) {
			
			System.out.println(D + " " + C);
		}else if(C == D){
			System.out.println(C);
		}
		else {
			System.out.print(C + " " + D);
		}
	}

}