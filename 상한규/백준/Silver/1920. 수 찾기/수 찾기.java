import java.io.*;
import java.util.*;

/*
수 찾기 문제의 경우 N의 개수가 10만이기 때문에 nlogn이 가능한 이분 탐색을 쓴다. 카운팅 배열을 쓰면 빠르게 가능하지만,
정수의 범위가 2의 31제곱 즉 2억이기 때문에 채택하지 않는다.
해쉬셋의 경우는 가능하나 이분탐색보다는 느리다.
*/ 

public class Main {
    static int N;
    static int M;
    static int[] A;
    static int[] checks;
    
    public static void main(String[] args) throws IOException {
      // BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N];

        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        checks = new int[M];

        for(int i = 0; i < M; i++) {
            checks[i] = Integer.parseInt(st.nextToken());
        }
        

        for(int value : checks) {
            boolean isExist = Arrays.binarySearch(A, value) > -1;
            
            System.out.println(isExist ? 1 : 0);
        }
    }
}
