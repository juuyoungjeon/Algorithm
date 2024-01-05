import java.io.*;
import java.util.*;
 
public class Main {
    static int N, T;
    static ArrayList<Integer>[] rock;
	
    public static class Pos {
        int x, y;
		
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
        N = Integer.parseInt(st.nextToken()); // 암벽에 박힌 홈 개수
        T = Integer.parseInt(st.nextToken()); // 정상 위치 (y)
		
        rock = new ArrayList[200001]; // T의 최대값: 2,000,000
        for (int i=0; i<200001; i++) {
            rock[i] = new ArrayList<>();
        }
		
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
			
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
			
            rock[y].add(x);
        }
        
        // ★ 높이에 따른 x값 오름차순 정렬
        for (int i=0; i<200001; i++) {
            Collections.sort(rock[i]);
        }
		
        System.out.println(bfs());
    }
	
    public static int bfs() {
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(0, 0));
		
        int ans = 0;
        while (!q.isEmpty()) {
            int size = q.size();
			
            for (int i=0; i<size; i++) {
                Pos now = q.poll();
				
                if (now.y == T) {
                    return ans; 
                }
				
                for (int y=now.y-2; y<=now.y+2; y++) {
                    if (y < 0 || y >= 200001) continue;
					
                    for (int x=0; x<rock[y].size(); x++) {
                        if (now.x + 2 < rock[y].get(x)) break; // 큰 값이 나오면 볼 필요 없음
                        else if (now.x - 2 > rock[y].get(x)) continue; 
							
                        q.add(new Pos(rock[y].get(x), y));
                        rock[y].remove(x); // 암벽 제거
                        x--;               // remove를 하면 인덱스값이 작아지기때문에 -1
                    }
                }
            }
            ans++;
        }
		
        return -1;
    }
}