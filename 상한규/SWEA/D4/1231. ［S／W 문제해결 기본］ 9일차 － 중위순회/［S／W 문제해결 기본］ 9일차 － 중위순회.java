import java.io.*;
import java.util.*;

class Solution {
	
	public static void main(String args[]) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = 10;
		
		for(int i = 0; i < test_case; i++) {
			StringBuilder sb = new StringBuilder();
			int N = Integer.parseInt(br.readLine());
			char[] tree = new char[N + 1];
			
			
			for(int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int index = Integer.parseInt(st.nextToken());
				char value = st.nextToken().charAt(0);
				
				tree[index] = value;				
			}

			sb.append("#").append(i + 1).append(" ");
			
			inorder(1, tree, sb);
			
			System.out.println(sb);
		}
	}
	public static void inorder(int root, char[] tree, StringBuilder sb) {
		if(root >= tree.length) {
		return;
		}
		
		inorder(root * 2, tree, sb);
		sb.append(tree[root]);
		inorder(root * 2 + 1, tree, sb);
		
	}	
}