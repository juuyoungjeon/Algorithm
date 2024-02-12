import java.util.*;
import java.io.*;

public class Main {
	static int[][] map;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map = new int[9][9];
		visited = new boolean[10];
		for (int i = 0; i < 9; i++) {
			 st = new StringTokenizer(br.readLine());
			 for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		sudoku(0,0);
	}
	
	public static void sudoku(int row, int col) {
		if (col == 9) {
			sudoku(row + 1, 0);
			return;
		}
		
		if (row == 9) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(map[i][j] + " ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}
		if (map[row][col] == 0) {
			for (int i = 1; i <= 9; i++) {
				if (check(row, col, i)) {
					map[row][col] = i;
					sudoku(row, col + 1);
				}
			}
			map[row][col] = 0;
			return;
		}
		sudoku(row, col + 1);
	}
	
	public static boolean check(int row, int col, int value) {
		for (int i = 0; i < 9; i++) {
			if (map[row][i] == value) {
				return false;
			}
		}
		
		for (int i = 0; i < 9; i++) {
			if (map[i][col] == value) {
				return false;
			}
		}
		
		int a = (row/3) * 3;
		int b = (col/3) * 3;
		
		for (int i = a; i < a + 3; i++) {
			for (int j = b; j < b + 3; j++) {
				if (map[i][j] == value) {
					return false;
				}
			}
		}
		return true;
	}

}