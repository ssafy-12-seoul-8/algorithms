import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
         
        int tc = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < tc; t++) {
			int k = Integer.parseInt(br.readLine());
			Deque<Integer> stack = new ArrayDeque<>();
			
			for (int i = 0; i < k; i++) {
				int num = Integer.parseInt(br.readLine());
				if (num == 0) {
					stack.pop();
				} else {
					stack.push(num);
				}
			}
			
			int sum = 0;
			while (!stack.isEmpty()) {
				sum += stack.pop();
			}

			sb.append("#").append(t + 1).append(" ").append(sum).append("\n");
		}
        
        System.out.println(sb);
 
    }
}
