import java.util.*;
import java.io.*;

public class Main {
  static public void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] times = new int[N];
    int result = 0;
    
    for(int i = 0; i < N; i++) {
      times[i] = Integer.parseInt(st.nextToken());
    }
    
    Arrays.sort(times);

    for(int i = 0; i < N; i++) {
      result += (N - i) * times[i];
    }

    System.out.println(result);
  }
}