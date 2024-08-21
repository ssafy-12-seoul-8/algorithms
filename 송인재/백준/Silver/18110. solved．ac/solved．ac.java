import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n];
        
        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(score);
        
        int exclude = (int) Math.round(n * 0.15);
        int total = n - 2 * exclude;
        int sum = 0;
        
        for (int i = exclude; i < total + exclude; i++) {
            sum += score[i];
        }
        
        System.out.println(Math.round((double) sum / total));
    }
    
}