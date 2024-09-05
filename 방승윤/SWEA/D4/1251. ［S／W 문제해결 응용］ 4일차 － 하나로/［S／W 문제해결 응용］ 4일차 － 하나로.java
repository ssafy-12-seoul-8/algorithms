import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
    
    static int N, cnt;
    static double[] xLocation, yLocation;
    static double[][] diff;
    static int[] p;
    
 
    public static void main(String[] args) throws Exception {
        
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        
        for (int tc = 1; tc <= T; tc++) {
            
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            
            xLocation = new double[N];
            yLocation = new double[N];
            diff = new double[N * (N - 1) / 2][3];
            
            st = new StringTokenizer(br.readLine());
            
            for (int i = 0; i < N; i++) {
                xLocation[i] = Double.parseDouble(st.nextToken());
            }
            
            st = new StringTokenizer(br.readLine());
            
            for (int i = 0; i < N; i++) {
                yLocation[i] = Double.parseDouble(st.nextToken());
            }
            
            makeDiff(0, -1, -1);
            
            Arrays.sort(diff, new Comparator<double[]>() {

                @Override
                public int compare(double[] o1, double[] o2) {
                    return Double.compare(o1[2], o2[2]);
                }
            });
            
            p = new int[N];
            
            for (int i = 0; i < N; i++) {
                p[i] = i;
            }
            
            double minCost = 0;
            int pick = 0;
            
            for (int i = 0; i < N * (N - 1) / 2; i++) {
                int px = findSet((int) diff[i][0]);
                int py = findSet((int) diff[i][1]);
                
                if (px != py) {
                    union(px, py);
                    minCost += diff[i][2];
                    pick++;
                }
                
                if (pick == (N - 1));
            }
            
            st = new StringTokenizer(br.readLine());
            double E = Double.parseDouble(st.nextToken());
            
            sb.append("#").append(tc).append(" ").append(Math.round(minCost * E)).append("\n");
            
            cnt = 0;
            
        }
        
        System.out.println(sb);
        
    }


    static void makeDiff(int idx, int A, int B) {
        
        if (idx == 2) {
            diff[cnt][0] = A;
            diff[cnt][1] = B;
            diff[cnt++][2] = Math.pow(xLocation[A] - xLocation[B], 2) + Math.pow(yLocation[A] - yLocation[B], 2);
            return;
        }
        
        for (int i = A + 1; i < N - 1 + idx; i++) {
            if (idx == 0) {
                A = i;
            } else {
                B = i;
            }
            makeDiff(idx + 1, A, B);
        }
        
    }
    
    static int findSet(int x) {
        if (x != p[x]) {
            p[x] = findSet(p[x]);
        }
        return p[x];
    }
    
    static void union(int x, int y) {
        p[y] = x;
    }
    
}