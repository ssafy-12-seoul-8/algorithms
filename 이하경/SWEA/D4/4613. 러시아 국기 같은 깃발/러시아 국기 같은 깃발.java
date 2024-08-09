import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
 
public class Solution {
    public static int n, m, min;
    public static int[][] flag;
    public static Map<Character, Integer> map = new HashMap<>();
    
    static {
        map.put('W', 0);
        map.put('B', 1);
        map.put('R', 2);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
         
        int T = Integer.parseInt(br.readLine());
         
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
             
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
             
            flag = new int[n][m];
             
            // W는 0, B는 1, R은 2
            for (int i = 0; i < n; i++) {
                String input = br.readLine();
                for (int j = 0; j < m; j++) {
                    flag[i][map.get(input.charAt(j))]++;
                }
            }
     
            min = n * m; // 전체 채색하는경우가 최대
            
            int sumW = 0;
            for (int i = 0; i <= n - 3; i++) {
            	sumW += colorIn(i, 0);
            	int sumB = 0;
				for (int j = i + 1; j <= n - 2; j++) {
					sumB += colorIn(j, 1);
					int sumR = 0;
					for (int k = j + 1; k < n; k++) {
						sumR += colorIn(k, 2);
					}
					min = Math.min(min, sumW + sumB + sumR);
				}

			}

       
            
            sb.append("#").append(t).append(" ").append(min).append("\n");
        }       
        System.out.println(sb);
 
    }
 
    // row번째 줄을 color색으로 칠할 때 몇개를 바꿔야하는지
    public static int colorIn(int row, int color) {
        return m - flag[row][color];
    }
}
