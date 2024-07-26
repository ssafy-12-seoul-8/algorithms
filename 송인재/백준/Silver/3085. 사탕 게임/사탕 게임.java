import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    static int[] dr = {1, 0};
    static int[] dc = {0, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] candies = new char[n][n];
        int max = 1;
        
        for (int i = 0; i < n; i++) {
            candies[i] = br.readLine()
                    .toCharArray();
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 2; k++) {
                    int newRow = i + dr[k];
                    int newCol = j + dc[k];
                    
                    if (newRow < 0 || newCol < 0 || newRow >= n || newCol >= n) {
                        continue;
                    }
                    
                    if (candies[i][j] != candies[newRow][newCol]) {
                        char temp = candies[i][j];
                        candies[i][j] = candies[newRow][newCol];
                        candies[newRow][newCol] = temp;
                        max = Math.max(max, getMax(candies));
                        temp = candies[i][j];
                        candies[i][j] = candies[newRow][newCol];
                        candies[newRow][newCol] = temp;
                    }
                }
            }
        }
        
        System.out.println(max);
    }
    
    static int getMax(char[][] candies) {
        int max = 1;
        
        for (int i = 0; i < candies.length; i++) {
            int rowMax = 1;
            int colMax = 1;
            
            for (int j = 0; j < candies.length - 1; j++) {
                rowMax = candies[i][j] == candies[i][j + 1] ? rowMax + 1 : 1;
                colMax = candies[j][i] == candies[j + 1][i] ? colMax + 1 : 1;
                max = Math.max(max, Math.max(rowMax, colMax));
            }
        }
        
        return max;
    }
    
}
