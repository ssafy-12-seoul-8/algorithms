import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    
    static int N;
    static int size;
    static int[] heap;
    static StringBuilder sb;
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int test_case = 1; test_case <= T; test_case++) {
            
            sb = new StringBuilder();
            sb.append("#").append(test_case);
            
            N = Integer.parseInt(br.readLine());
            
            heap = new int[N + 1];
            size = 0;
            
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                if (Integer.parseInt(st.nextToken()) == 1) {
                    add(++size, Integer.parseInt(st.nextToken()));
                } else {
                    poll(1);
                    if (size != 0) {
                        size--;
                    }
                }
            }
            
            System.out.println(sb);
            
        }
        
    }
    
    static void add (int idx, int num) {
        if (heap[idx / 2] >= num || idx == 1) {
            heap[idx] = num;
        } else {
            heap[idx] = heap[idx / 2];
            add(idx / 2, num);
        }
    }
    
    static void poll (int idx) {
        if (size == 0) {
            sb.append(" ").append("-1");
        } else if (idx == 1) {
            sb.append(" ").append(heap[1]);
            heap[1] = heap[size];
            heap[size] = 0;
        }
        
        int high = idx * 2;
        
        if (idx * 2 == N) {
            high = idx * 2;
        } else if (idx * 2 + 1 > N) {
         	high = 0;
        } else {
            if (heap[idx * 2] > heap[idx * 2 + 1]) {
                high = idx * 2;
            } else {
                high = idx * 2 + 1;
            }
        } 
        if (heap[idx] < heap[high]) {
            int temp = heap[idx];
            heap[idx] = heap[high];
            heap[high] = temp;
            poll(high);
        }
        
    }
    
}