import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for(int i = 0; i < T; i++) {
      String[] functions = br.readLine().split("");
      Deque<Integer> deque = new LinkedList<>();
      int size = Integer.parseInt(br.readLine());
      StringBuilder numberString = new StringBuilder(br.readLine());
      boolean isReverse = false;
      boolean isError = false;
      StringBuilder result = new StringBuilder();

      numberString.deleteCharAt(0);
      numberString.deleteCharAt(numberString.length() - 1);
      
      if(size != 0) {
        String[] numberStrings = numberString.toString().split(",");
        
        for(int j = 0; j < numberStrings.length; j++) {
          deque.add(Integer.parseInt(numberStrings[j]));
        }
      }

      for(int j = 0; j < functions.length; j++) {
        if(functions[j].equals("R")) {
          isReverse = !isReverse;
        } else { // case D
          if(deque.size() == 0) {
            isError = true;
            
            break;
          } else {
            if(isReverse) {
              deque.pollLast();
            } else {
              deque.pollFirst();
            }
          }
        }
      }

      if(isError) {
        System.out.println("error");
      } else {
        result.append("[");

        int resultSize = deque.size();

        for(int j = 0; j < resultSize; j++) {
          result.append(isReverse ? deque.pollLast() : deque.pollFirst());
        
          if(j != resultSize - 1) {
            result.append(",");
          }
        }
      
        result.append("]");

        System.out.println(result);
      }
    } 
  }
}