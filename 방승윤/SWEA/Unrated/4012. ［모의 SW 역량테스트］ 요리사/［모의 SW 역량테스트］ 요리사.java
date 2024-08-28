import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
     
    static int N, minDiff, cntA, cntB;
    static int[][] ingredient;
    static int[] ingredientNums;
 
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
         
        for (int test_case = 1; test_case <= T; test_case++) {
             
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
             
            ingredient = new int [N][N];
            ingredientNums = new int[N];
             
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    ingredient[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
            minDiff = Integer.MAX_VALUE;
            cntA = 0;
            cntB = 0;
             
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
         
        if (cntA < N / 2) {
            int temp = 0;
            ingredientNums[cntA++] = idx;
             
            for (int i = 0; i < cntA; i++) {
                temp += ingredient[ingredientNums[i]][idx];
                temp += ingredient[idx][ingredientNums[i]];
            }
             
            recur(idx + 1, tasteA + temp, tasteB);
             
            cntA--;
        }
         
        if (cntB < N / 2) {         
            int temp = 0;
            ingredientNums[N / 2 + cntB++] = idx;
             
            for (int i = N / 2; i < N / 2 + cntB; i++) {
                temp += ingredient[ingredientNums[i]][idx];
                temp += ingredient[idx][ingredientNums[i]];
            }
             
            recur(idx + 1, tasteA, tasteB + temp);
             
            cntB--;
        }
    }
     
}