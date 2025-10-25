import java.io.*;
import java.util.*;

public class Main {
  static int INFINITY = 100 * 100 * 100000;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());
    int[][] adjArray = new int[n][n];
    StringTokenizer st;
    
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++) {
        if(i == j) {
          adjArray[i][j] = 0;
        } else {
          adjArray[i][j] = INFINITY;
        }
      }
    }

    for(int t = 0; t < m; t++) {
      st = new StringTokenizer(br.readLine());
      int i = Integer.parseInt(st.nextToken());
      int j = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());

      adjArray[i - 1][j - 1] = Math.min(adjArray[i - 1][j - 1], cost);
    }

    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++) {
        for(int k = 0; k < n; k++) {
          adjArray[j][k] = Math.min(adjArray[j][k], adjArray[j][i] + adjArray[i][k]);
        }
      }
    }    

    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++) {
        if(adjArray[i][j] == INFINITY) {
          System.out.print(0);
        } else {
          System.out.print(adjArray[i][j]);
        }

        if(j != n - 1) {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }
}