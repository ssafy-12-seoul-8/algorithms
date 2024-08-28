import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
    
    static int N, K, minDiff;
    static int[][] ingredient;
    static Stack<Integer> A;
    static Stack<Integer> B;

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        
        for (int test_case = 1; test_case <= T; test_case++) {
            
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            A = new Stack<>();
            B = new Stack<>();
            
            ingredient = new int [N][N];
            
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    ingredient[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            minDiff = Integer.MAX_VALUE;
            
            recur(0, 0, 0);
            
            sb.append("#").append(test_case).append(" ").append(minDiff).append("\n");
            
        }
        System.out.println(sb);
    }
    
    static void recur(int idx, int tasteA, int tasteB) {
        if (idx == N) {
            minDiff = Math.min(minDiff, Math.abs(tasteA - tasteB));
            return;
        }
        
        if (A.size() < N / 2) {
            A.push(idx);
            
            int temp = 0;
            
            for (int i = 0; i < A.size(); i++) {
                temp += ingredient[A.get(i)][idx];
                temp += ingredient[idx][A.get(i)];
            }
            
            recur(idx + 1, tasteA + temp, tasteB);
            
            A.pop();
        }
        
        if (B.size() < N / 2) {
            B.push(idx);
            
            int temp = 0;
            
            for (int i = 0; i < B.size(); i++) {
                temp += ingredient[B.get(i)][idx];
                temp += ingredient[idx][B.get(i)];
            }
            
            recur(idx + 1, tasteA, tasteB + temp);
            
            B.pop();
        }
    }
    
}