import java.util.*;
import java.io.*;

//public class Main {
//	static int N;
//	static int[] H,P,S;
//	static int left, right;
//	public static void main(String[] args) throws IOException {
//		// TODO Auto-generated method stub
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		N = Integer.parseInt(br.readLine());
//		
//		H = new int[N + 1];
//		P = new int[N + 1];
//		S = new int[N + 1];
//		
//		for(int i = 1; i <= N; i++) {
//			String a = br.readLine();
//			if(a.equals('H')) {
//				H[i] = 1;
//			}else if(a.equals('P')) {
//				P[i] = 1;
//			}else {
//				S[i] = 1;
//			}
//		}
//		
//		for(int i = 1; i <= N; i++) {
//			H[i] += H[i-1];
//			P[i] += P[i-1];
//			S[i] += S[i-1];
//			
//		}
//		
//		int ret = Math.max(H[N], Math.max(P[N], S[N]));
//		for(int i = 1; i < N; i++) {
//			left = Math.max(H[i], Math.max(P[i], S[i]));
//			right = Math.max(H[N] - H[i], Math.max(P[N] - P[i], S[N] - S[i]));
//			
//			ret = Math.max(ret, left + right);
//		}
//		
//		System.out.println(ret);
//	}
//
//}

public class Main {
    private static class Point{
        int pCnt;
        int hCnt;
        int sCnt;
 
        public Point(int p, int h, int s) {
            pCnt = p;
            hCnt = h;
            sCnt = s;
        }
    }
 
    private static final int MAX = 100001;
    private static Point[] dp = new Point[MAX];
    private static int N;
 
    private static void func() {
        int ret = Math.max(dp[N].pCnt, Math.max(dp[N].hCnt, dp[N].sCnt));
        for(int i = 1; i < N; i++) {
            int l = Math.max(dp[i].pCnt, Math.max(dp[i].hCnt, dp[i].sCnt));
            int r = Math.max(dp[N].pCnt - dp[i].pCnt, Math.max(dp[N].hCnt - dp[i].hCnt, dp[N].sCnt - dp[i].sCnt));
 
            ret = Math.max(ret, l + r);
        }
 
        System.out.println(ret);
    }
 
    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        char x;
        N = Integer.parseInt(st.nextToken());
        dp[0] = new Point(0, 0, 0);
        for (int i = 1; i <= N; i++) {
            dp[i] = new Point(0, 0, 0);
            st = new StringTokenizer(br.readLine());
            x = st.nextToken().charAt(0);
 
            if (x == 'P') {
                dp[i].pCnt++;
            } else if (x == 'H') {
                dp[i].hCnt++;
            } else {
                dp[i].sCnt++;
            }
 
            dp[i].pCnt += dp[i - 1].pCnt;
            dp[i].hCnt += dp[i - 1].hCnt;
            dp[i].sCnt += dp[i - 1].sCnt;
        }
    }
 
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}