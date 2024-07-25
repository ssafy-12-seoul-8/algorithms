import java.io.*;
import java.util.*;

class Solution {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] flies = new int[n][n];
            int max = 0;
            int[] tenXs = {-1, 1, 0, 0};
            int[] tenYs = {0, 0, -1, 1};
            int[] xXs = {-1, 1, -1, 1};
            int[] xYs = {-1, -1, 1, 1};
            
            
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                
                for (int k = 0; k < n; k++) {
                    flies[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int tenShapeSum = flies[j][k];
                    int xShapeSum = flies[j][k];
                    
                    for (int l = 1; l < m; l++) {
                        for (int o = 0; o < 4; o++) {
                            int tenX = j + l * tenXs[o];
                            int tenY = k + l * tenYs[o];
                            int xX = j + l * xXs[o];
                            int xY = k + l * xYs[o];
                            
                            if (tenX >= 0 && tenX < n && tenY >= 0 && tenY < n) {
                                tenShapeSum += flies[tenX][tenY];
                            }
                            
                            if (xX >= 0 && xX < n && xY >= 0 && xY < n) {
                                xShapeSum += flies[xX][xY];
                            }
                        }
                    }
                    
                    max = Math.max(max, tenShapeSum);
                    max = Math.max(max, xShapeSum);
                }
            }
            
            StringBuilder sb = new StringBuilder("#").append(i)
                .append(" ");
            
            System.out.println(sb.append(max));
        }
    }
}