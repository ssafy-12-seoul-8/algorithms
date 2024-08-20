import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            int command = Integer.parseInt(br.readLine());
            
            if (command != 0) {
                pq.add(command);
                
                continue;
            }
            
            sb.append(pq.isEmpty() ? 0 : pq.poll())
                .append("\n");
        }
        
        System.out.println(sb);
    }
    
}