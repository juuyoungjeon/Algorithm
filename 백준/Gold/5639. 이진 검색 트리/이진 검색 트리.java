import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static class Node{
		int num;
		Node left, right;
		
		Node(int num){
			this.num = num;
		}
		Node(int num, Node left, Node right){
			this.num = num;
			this.left = left;
			this.right = right;
		}
		
		void insert(int n) {
			if(n < this.num) {
				if(this.left == null) {
					this.left = new Node(n);
				}
				else {
					this.left.insert(n);
				}
			}else {
				if(this.right == null) {
					this.right = new Node(n);
				}else {
					this.right.insert(n);
				}
			}
		}
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Node root = new Node(Integer.parseInt(br.readLine()));
		String input;
		while(true) {
			input = br.readLine();
			if(input == null || input.equals("")) {
				break;
			}
			root.insert(Integer.parseInt(input));
		}
		postOrder(root);
		System.out.println(sb);
	}
	public static void postOrder(Node node) {
		if(node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		sb.append(node.num).append("\n");
//		System.out.println(node.num);
	}

}