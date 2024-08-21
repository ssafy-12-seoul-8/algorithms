import java.io.*;
import java.util.*;

public class Main {
    
    static class Stack {
        int[] items;
        int size;
        
        Stack(int n) {
            items = new int[n];
            size = 0;
        }
        
        void push(int item) {
            items[size++] = item;
        }
        
        int pop() {
            if (empty()) {
                return -1;
            }
            
            return items[--size];
        }
        
        int size() {
            return size;
        }
        
        boolean empty() {
            return size == 0;
        }
        
        int top() {
            if (empty()) {
                return -1;
            }
            
            return items[size - 1];
        }
        
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack stack = new Stack(n);
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            
            switch (command) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "top":
                    sb.append(stack.top())
                        .append("\n");
                    break;
                case "pop":
                    sb.append(stack.pop())
                        .append("\n");
                    break;
                case "empty":
                    sb.append(stack.empty() ? 1 : 0)
                        .append("\n");
                    break;
                case "size":
                    sb.append(stack.size())
                        .append("\n");
                    break;
                default:
                    break;
            }
        }
        
        System.out.println(sb);
    }
    
}