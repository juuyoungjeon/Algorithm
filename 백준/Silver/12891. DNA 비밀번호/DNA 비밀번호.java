import java.util.*;
import java.io.*;

public class Main {

	static int S, P;
//	static char[] str;
	static String str;
	static int[] num;
	static int[] cnt;
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		str = br.readLine();
//		str = br.readLine().toCharArray();
		num = new int[4];
		cnt = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		String pw = str.substring(0, P);
		for(int i = 0; i < P; i++) {
			switch (pw.charAt(i)) {
			case 'A':
				cnt[0]++;
				break;
			case 'C':
				cnt[1]++;
				break;
			case 'G':
				cnt[2]++;
				break;
			case 'T':
				cnt[3]++;
				break;
			}
		}
		
		int ans = 0;
		
		if(cnt[0]>=num[0]&&cnt[1]>=num[1]&&cnt[2]>=num[2]&&cnt[3]>=num[3]) {
			ans++;
		}
		
		int startIdx = 0;
        int nextIdx = P;

        while(nextIdx<S){
            if(str.charAt(startIdx)=='A'){
                startIdx++;
                cnt[0]--;
            }else if(str.charAt(startIdx)=='C'){
                startIdx++;
                cnt[1]--;
            }else if(str.charAt(startIdx)=='G'){
                startIdx++;
                cnt[2]--;
            }else if(str.charAt(startIdx)=='T'){
                startIdx++;
                cnt[3]--;
            }else {
                startIdx++;
            }

            if(str.charAt(nextIdx)=='A'){
                nextIdx++;
                cnt[0]++;
            }else if(str.charAt(nextIdx)=='C'){
                nextIdx++;
                cnt[1]++;
            }else if(str.charAt(nextIdx)=='G'){
                nextIdx++;
                cnt[2]++;
            }else if(str.charAt(nextIdx)=='T'){
                nextIdx++;
                cnt[3]++;
            }else {
                nextIdx++;
            }
            
            if(cnt[0]>=num[0]&&cnt[1]>=num[1]&&cnt[2]>=num[2]&&cnt[3]>=num[3]) {
    			ans++;
    		}

		
        }
        System.out.println(ans);
	}

}