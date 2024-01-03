import java.util.*;
import java.io.*;

public class Main {

	static int ans;
	static ArrayList<Integer> nums;
	static ArrayList<Character> ops;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String string = br.readLine();
		nums = new ArrayList<>();
		ops = new ArrayList<>();

		for(int i = 0; i < N; i++) {
			char c = string.charAt(i);
			if(c == '+' || c == '-' || c == '*') {
				ops.add(c);
				continue;
			}
			nums.add(Character.getNumericValue(c));
		}

		ans = Integer.MIN_VALUE;
		dfs(nums.get(0), 0);
		System.out.println(ans);
	}
	private static void dfs(int result, int opIdx) {
		if(opIdx >= ops.size()) {
			ans = Math.max(ans, result);
			return;
		}

		int res1 = calc(ops.get(opIdx), result, nums.get(opIdx+1));
		dfs(res1, opIdx+1);

		if(opIdx + 1 < ops.size()) {
			int res2 = calc(ops.get(opIdx + 1), nums.get(opIdx + 1), nums.get(opIdx + 2));
			dfs(calc(ops.get(opIdx), result, res2), opIdx + 2);
		}
	}
	private static int calc(char op, int n1, int n2) {
		switch(op) {
		case '*':
			return n1 * n2;
		case '+':
			return n1 + n2;
		case '-':
			return n1 - n2;
		}
		return -1;
	}

}