import java.util.*;
import java.io.*;

public class Main {
  static public void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int r = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    recur(N, r, c, 0, (1 << N) * (1 << N) - 1);
  }

  static void recur(int n, int r, int c, int start, int end) {
    if(n == 0) {
      System.out.println(start);
      return;
    } 
    
    int pow = (1 << n);
    int powpow = pow * pow;
    
    if(pow / 2 > r && pow / 2 > c) {
      recur(n - 1, r, c, start, start + powpow / 4 - 1);
      return;
    } 
    
    if(pow / 2 > r && pow / 2 <= c) {
      recur(n - 1, r, c - (pow / 2), start + powpow / 4, start + powpow / 2 - 1);
      return;
    }
    
    if(pow / 2 <= r && pow / 2 > c) {
      recur(n - 1, r - (pow / 2), c, start + powpow / 2, start + powpow / 4 * 3 - 1);
      return;
    }


    recur(n - 1, r - (pow / 2), c - (pow / 2), start + powpow / 4 * 3, end);
    return;
  }
}