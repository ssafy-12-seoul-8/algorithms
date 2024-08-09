import java.io.*;
import java.util.*;
 
public class Solution {
     
    static int n;
    static int[] nums;
    static int max = -1;
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());
         
        for (int t = 1; t <= cases; t++) {
            n = Integer.parseInt(br.readLine());
            nums = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
             
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
             
            Arrays.sort(nums);
            combination(new int[2], 0, 0);
             
            System.out.println("#" + t + " " + max);
            max = -1;
        }
    }
     
    static void combination(int[] targets, int index, int current) {
        if (current == 2) {
            max = Math.max(max, getDanzo(targets));
             
            return;
        }
         
        for (int i = index; i < n; i++) {
            targets[current] = nums[i];
             
            combination(targets, i + 1, current + 1);
        }
    }
     
    static int getDanzo(int[] nums) {
        int mul = nums[0] * nums[1];
        int temp = 10;
         
        while (mul > 0) {
            int next = mul % 10;
             
            if (temp < next) {
                return -1;
            }
             
            temp = next;
            mul /= 10;
        }
         
        return nums[0] * nums[1];
    }
     
}