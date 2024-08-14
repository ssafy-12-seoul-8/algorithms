import java.io.*;
import java.util.*;

class Solution {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int number = 1;
        
        for (int i = 0; i < n; i++) {
            String next = String.valueOf(number++);
            String temp = "";
            
            for (int j = 0; j < next.length(); j++) {
                char nextChar = next.charAt(j);
                
                if (nextChar == '3' || nextChar == '6' || nextChar == '9') {
                    temp += "-";
                }
            }
            
            if (temp.contains("-")) {
                next = temp;
            }
            
            sb.append(next).append(" ");
        }
        
        System.out.println(sb);
    }
    
}