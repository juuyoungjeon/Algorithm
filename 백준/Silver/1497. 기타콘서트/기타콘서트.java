import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		indexArr = new int[N];
		needGuiter = N;
		int numY = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			String[] str = st.nextToken().split("");
			for(int j=0; j<M; j++) {
				arr[i][j] = str[j].equals("Y")?1:0;
				if(arr[i][j]==1) numY++;
			}
		}
		
		for(int i=1; i<=N; i++) {
			recur(0,0,i);//만약 리턴값이 참이면 그만하고 i를 출력
		}
		if(numY==0) System.out.println(-1);
		else System.out.println(needGuiter);
		
	}
	
	//2개 고르고 고른 2개 비트마스킹 해서 모두 1이면 2출력
	//모두 1이 아니면 3개 고름(조합)
	static int indexArr[];
	public static void recur(int idx,int start, int max) {
		
		if(idx == max) {
			//비트마스킹
			if(bitmask(arr,indexArr,max)) {
				System.out.println(max);
				System.exit(0);
			}
			return;
			
		}
		
		for(int i=start; i<N; i++) {
			indexArr[idx] = i;
			recur(idx+1, i+1, max);
		}
	}
	
	static int maxSong,needGuiter;
	public static boolean bitmask(int guiter[][], int index[],int max) {
		//max 만큼의 인덱스 배열의 행값으로 모든 기타를 비트마스킹
		boolean res = true;
		int can = 0;
		for(int i=0; i<M; i++) {
			//index의 0~ max 번째 까지  기타의 각 열을 비트마스킹
			int result = guiter[index[0]][i];
			if(result ==0) {
				for(int j=1; j<max; j++) {
					result = guiter[index[j]][i] | result;
				}				
			}
			if(result == 0) res = false;
			if(result == 1) can++;
		}
		if(maxSong<can) {
			maxSong = can;
			needGuiter = max;
		}
		return res;
	}

}