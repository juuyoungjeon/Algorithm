import java.util.*;
import java.io.*;

public class Main {
	static char[] arr;
	static int cnt;
	static Stack<Character> stack = new Stack<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		arr = s.toCharArray();

		int N = s.length();

		stack.push(arr[0]);
		for(int i = 1; i < N; i++) {
			if(arr[i] == '(') {
				stack.push(arr[i]);
			}else {
				if(stack.size() > 0 && stack.peek() == '(') {
					stack.pop();
				}else {
					stack.push(arr[i]);
				}
			}
		}
		
		System.out.println(stack.size());

	}


}