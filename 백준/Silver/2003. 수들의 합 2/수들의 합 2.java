import java.io.BufferedReader;
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] array = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<N+1; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		int R=1;
		int sum=array[1];
		int ans=0;
		
		if(sum == M) {
			ans++;
		}
		
		for(int L=1;L<N+1; L++) {
			while(R<N) {
				if(sum+array[R+1]> M) {
					break;
				}
				if(sum+array[R+1]==M) {
					ans++;
					break;
				}
				if(sum+array[R+1]<M){
					R++;
					sum=sum+array[R];
				}
			}
			sum=sum-array[L];
			if(sum==M) {
				ans++;
			}
		}
		System.out.println(ans);
		

	}

}