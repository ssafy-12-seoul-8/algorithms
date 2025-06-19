import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    StringTokenizer sizes = new StringTokenizer(br.readLine());
    StringTokenizer TandP = new StringTokenizer(br.readLine());
    int T = Integer.parseInt(TandP.nextToken());
    int P = Integer.parseInt(TandP.nextToken());
    int shirtsBundles = 0;
    int penBundles = 0;
    int onePenCount = 0;

    while(sizes.hasMoreTokens()) {
      int size = Integer.parseInt(sizes.nextToken());
      if(size != 0) {
        shirtsBundles += size / T;
        
        shirtsBundles += size % T != 0 ? 1 : 0;
      }
    }
    
    penBundles = N / P;
    onePenCount = N % P;

    System.out.println(shirtsBundles);
    System.out.printf("%d %d\n", penBundles, onePenCount);
  }  
}