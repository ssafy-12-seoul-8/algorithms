import java.io.*;
import java.util.*;
 
public class Solution {
     
    static int n, m;
    static int min = Integer.MAX_VALUE;
    static char[][] map;
    static int[][] colors;
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());
         
        for (int t = 1; t <= cases; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            map = new char[n][m];
            colors = new int[n][3];
             
            for (int i = 0; i < n; i++) {
                map[i] = br.readLine()
                        .toCharArray();
                 
                for (int j = 0; j < m; j++) {
                    switch (map[i][j]) {
                        case 'W':
                            colors[i][0]++;
                            break;
                        case 'B':
                            colors[i][1]++;
                            break;
                        case 'R':
                            colors[i][2]++;
                    }
                }
            }
 
            for (int i = 1; i < n - 1; i++) {
                findMin(i, 1);
            }
             
            System.out.println("#" + t + " " + min);
             
            min = Integer.MAX_VALUE;
        }
    }
     
    static void findMin(int white, int blue) {
        if (white + blue == n) {
            return;
        }
         
        min = Math.min(reColor(white, blue, n - white - blue), min);
        findMin(white, blue + 1);
    }
     
    static int reColor(int white, int blue, int red) {
        int sum = 0;
         
        for (int i = 0; i < white; i++) {
            sum += colors[i][1] + colors[i][2];
        }
         
        for (int i = white; i < white + blue; i++) {
            sum += colors[i][0] + colors[i][2];
        }
         
        for (int i = white + blue; i < n; i++) {
            sum += colors[i][0] + colors[i][1];
        }
         
        return sum;
    }
 
}