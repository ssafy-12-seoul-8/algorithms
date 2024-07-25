import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(br.readLine());
        
        Deque<Integer> stack = new ArrayDeque<>();
        int num = 1;
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            int su = a[i];
            
            if (su >= num) {
                while (su >= num) {
                    stack.push(num++);
                    sb.append("+\n");
                }
                
                stack.pop();
                sb.append("-\n");
            } else {
                int last = stack.pop();
                
                if (last > su) {
                    sb.setLength(0);
                    sb.append("NO");
                    break;
                } else {
                    sb.append("-\n");
                }
            } 
        }
        
        System.out.println(sb);
    }
}