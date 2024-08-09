import java.io.*;
 
public class Solution {
     
    static char[] bits;
    static int start = -1;
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());
         
        for (int t = 1; t <= cases; t++) {
            bits = br.readLine()
                    .toCharArray();
            start = -1;
             
            for (int i = 0; i < bits.length; i++) {
                if (bits[i] == '1' && start == -1) {
                    start = i;
                }
            }
             
            int min = backtrack(0, '0', 0);
             
            System.out.println("#" + t + " " + min);
        }
    }
     
    static int backtrack(int index, char last, int count) {
        if (index == bits.length) {
            return count;
        }
         
        if (bits[index] == last) {
            return backtrack(index + 1, last, count);
        }
         
        return backtrack(index + 1, bits[index], count + 1);
    }
     
}