import java.io.*;
import java.util.*;

public class Solution {
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());
    
        for (int t = 1; t <= cases; t++) {
            String grass = br.readLine();
            int count = 0;
            
            for (int i = 1; i < grass.length(); i++) {
                char thisBlock = grass.charAt(i);
                char prevBlock = grass.charAt(i - 1);
                
                if (thisBlock == ')' || prevBlock == '(') {
                    count++;
                }
            }
            
            System.out.println("#" + t + " " + count);
        }
    }
  
}