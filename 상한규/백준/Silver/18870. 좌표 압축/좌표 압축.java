import java.util.*;
import java.io.*;

public class Main {
  static public void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] array = new int[N];
    Map<Integer, Integer> rankMap = new HashMap<>();
    int rank = 0;
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    for(int i = 0; i < N; i++) {
      array[i] = Integer.parseInt(st.nextToken());
    }

    int[] sortedArray = Arrays.copyOf(array, array.length);
    
    Arrays.sort(sortedArray);

    for(int i = 0; i < sortedArray.length; i++) {
      if(!rankMap.containsKey(sortedArray[i])) {
        rankMap.put(sortedArray[i], rank++);
      }
    }

    for(int i = 0; i < array.length; i++) {
      sb.append(rankMap.get(array[i]) + " ");
    }
    System.out.println(sb);
  }
}