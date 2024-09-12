import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;
        
        for(int i = 0; i < 5; i++) {
            result += Math.pow((double)Integer.parseInt(st.nextToken()), 2);
        }
        
        result = result % 10;
       
        System.out.println(result);
    }
}