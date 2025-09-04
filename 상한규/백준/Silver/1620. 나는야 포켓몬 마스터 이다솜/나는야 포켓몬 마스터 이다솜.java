import java.util.*;
import java.io.*;

public class Main {
  static public void main (String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    Map<Integer, String> numberKeyMap = new HashMap<Integer, String>();
    Map<String, Integer> nameKeyMap = new HashMap<String, Integer>();

    for(int i = 1; i <= N; i++) {
      String pocketmonName= br.readLine();
      numberKeyMap.put(i, pocketmonName);
      nameKeyMap.put(pocketmonName, i);
    }

    for(int i = 0; i < M; i++) {
      String searchKey = br.readLine();
      String result;
      
      if(searchKey.toCharArray()[0] >= '0' && searchKey.toCharArray()[0]<= '9') {
        result = numberKeyMap.get(Integer.parseInt(searchKey));
      } else {
        result = nameKeyMap.get(searchKey).toString();
      }

      System.out.println(result);
    }
  }
}