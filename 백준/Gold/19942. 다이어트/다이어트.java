import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[][] arr;
	static int result = Integer.MAX_VALUE;
	static int[] min_nutrition;
	static int[] isSelected;
	static ArrayList<String> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N+1][5];
		min_nutrition = new int[4];
		list = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			min_nutrition[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1; i <= N; i++) {
			isSelected = new int[N];
			dfs(0, i, 1);
		}
		if(result == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			Collections.sort(list);
			System.out.println(result);
			System.out.println(list.get(0));
		}
	}

	private static void dfs(int cnt, int choiceNum, int start) {
		// TODO Auto-generated method stub
		if(cnt == choiceNum) {
			isCheck(choiceNum);
			return;
		}
		for(int i = start; i <= N; i++) {
			isSelected[cnt] = i;
			dfs(cnt +1, choiceNum, i +1);
		}
		
	}

	private static void isCheck(int choiceNum) {
		int[] sum_nutrition = new int[4];
		int price = 0;
		
		for(int i = 0; i < choiceNum; i++) {
			for(int j = 0; j < 4; j++) {
				sum_nutrition[j] += arr[isSelected[i]][j];
			}
			price += arr[isSelected[i]][4];
		}
		for(int i=0;i<4;i++)
            if(min_nutrition[i] > sum_nutrition[i]) return ; //최소비용 만족 못할 시 return
            
            if(result >= price){
                //이전에 선택한 가격 보다 지금 선택한 것이 더 싸다면
                //갱신해주기
                if(result > price) list.clear();
                StringBuilder sb = new StringBuilder();
                for(int i=0;i<choiceNum;i++){
                    sb.append(isSelected[i]+" ");
                }

                list.add(sb.toString());
                result = price;
            }


    }

}