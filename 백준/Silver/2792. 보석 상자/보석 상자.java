import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] arr;
	static int cnt;
	static int s,e;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		
		for(int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			e = Math.max(arr[i], e);
		}
		
		s = 1;
		paramatricSearch();
		
		System.out.println(s);
	}
	/*
	 * 파라메트릭 서치에서 매개변수는 "나눠줄 보석의 수"
	 * 매개변수로 나눠줬을때 총 몇명의 사람에게 나눠줄 수 있는지 계산하고
	 * 계산했을때 사람의 수가 N보다 크면, 나눠주는 보석의 수를 증가시켜 사람 수 줄여준다
	 * 질투심이 최소가 되게 보석을 나눠주기 위해서는 보석의 수를 최대한 감소시켜야 함
	 * 
	 * 한명한테 보석을 모두 나눠주면 질투심이 높아지기 때문에
	 * 최대한 많은 사람아게 동일하게 보석을 나눠줘야함
	 * 
	 * */
	public static void paramatricSearch() {
		while(s<=e) {
			int mid = (s + e) / 2;
			int people = 0;
			
			for(int i = 0; i < M; i++) {
				if(arr[i] % mid == 0) {
					people += arr[i]/mid;
				}else {
					people += arr[i]/mid + 1;
				}
			}
			
			if(people > N) {
				s = mid + 1;
			}else {
				e = mid - 1;
			}
		}
		
	}
}