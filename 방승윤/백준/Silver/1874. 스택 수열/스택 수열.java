import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        
        int idx = 0;

        out : for (int i = 1; i <= N; i++) {
        	if (arr[idx] >= i) {
        		sb.append("+\n");
        		stack.push(i);
        	}
        	while (idx < N && arr[idx] <= i) {
        		if (stack.pop() == arr[idx]) {
        			sb.append("-\n");
        			idx++;
        		} else {
        			sb = new StringBuilder();
        			sb.append("NO");
        			break out;
        		}
        	}
        }
        
        System.out.println(sb);
        
    }
    
}