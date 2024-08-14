import java.io.*;
import java.util.*;

class Solution {
	static Stack<Double> stack;
	
	public static void main(String args[]) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = 10;
		
		for(int i = 0; i < test_case; i++) {
			StringBuilder sb = new StringBuilder();
			int N = Integer.parseInt(br.readLine());
			String[][] tree = new String[N + 1][3];
			
			for(int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int index = Integer.parseInt(st.nextToken());
				String value = st.nextToken();
				boolean left = true;
				stack = new Stack<>();
				
				tree[index][0] = value;		
				
				while(st.hasMoreTokens()) {
					if(left) {
						tree[index][1] = st.nextToken();
						left = false;
					} else {
						tree[index][2] = st.nextToken();
					}
				}		
			}
			
			inorder(1, tree, sb);

			sb.append("#").append(i + 1).append(" ").append((int)Math.round(stack.pop()));
			
			System.out.println(sb);
		}
	}
	
	public static void inorder(int root, String[][] tree, StringBuilder sb) {
		if(root >= tree.length) {
			return;
		}

		String currentValue = tree[root][0];

		if(tree[root][1] != null) {
			inorder(Integer.parseInt(tree[root][1]), tree, sb);
		}
			
		if(tree[root][2] != null) {
			inorder(Integer.parseInt(tree[root][2]), tree, sb);
		}
		
		
		if(currentValue.equals("+")){
			double valueOne = stack.pop();
			double valueTwo = stack.pop();
			stack.push(valueTwo + valueOne);
		} else if(currentValue.equals("-")){
			double valueOne = stack.pop();
			double valueTwo = stack.pop();
			stack.push(valueTwo - valueOne);
		} else if(currentValue.equals("*")){
			double valueOne = stack.pop();
			double valueTwo = stack.pop();
			stack.push(valueTwo * valueOne);
		} else if(currentValue.equals("/")){
			double valueOne = stack.pop();
			double valueTwo = stack.pop();
			stack.push(valueTwo / valueOne);
		} else {
			stack.push(Double.parseDouble(currentValue));
		}
		
	}	
}