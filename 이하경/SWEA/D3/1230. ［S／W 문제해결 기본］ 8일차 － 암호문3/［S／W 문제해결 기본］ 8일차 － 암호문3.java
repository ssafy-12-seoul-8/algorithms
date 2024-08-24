import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static StringBuilder sb = new StringBuilder();
    // 중간에서 삽입, 삭제 연산을 빠르게 하기 위해 중간 노드를 저장해준다
    static int current;
    static int size;
    static Node currentNode;
    static Node headNode;
    static Node tailNode;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int t = 1; t <= 10; t++) {
            sb.append("#").append(t);

            makeLinkedList();

            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                insert(Integer.parseInt(st.nextToken()));
            }

            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                String cmd = st.nextToken();
                if (cmd.equals("I")) {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    move(x);
                    for (int j = 0; j < y; j++) {
                        int s = Integer.parseInt(st.nextToken());
                        insert(s);
                    }
                } else if (cmd.equals("D")) {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    move(x);
                    for (int j = 0; j < y; j++) {
                        delete();
                    }
                } else { // cmd = A
                    int y = Integer.parseInt(st.nextToken());
                    for (int j = 0; j < y; j++) {
                        int s = Integer.parseInt(st.nextToken());
                        add(s);
                    }
                }
            }
            printTen();
        }
        System.out.println(sb);
    }

    static void makeLinkedList(){
        Node head = new Node();
        Node tail = new Node();
        head.next = tail;
        tail.next = head;
        current = 0;
        size = 1; // tail 노드의 위치
        currentNode = head;
        headNode = head;
        tailNode = tail;
    }

    // x번 노드가 current가 되게 한다
    static void move(int x) {
        if (x < current) {
            if (x < current / 2) {
                currentNode = headNode;
                for (int i = 0; i < x; i++) {
                    currentNode = currentNode.next;
                }
            } else {
                for (int i = current; i > x; i--) {
                    currentNode = currentNode.prev;
                }
            }
        } else {
            if (x < (x + size) / 2) {
                for (int i = current; i < x; i++) { // for문을 1번 돌면 current는 i번의 다음 노드가 된다
                    currentNode = currentNode.next;
                }
            } else {
                currentNode = tailNode;
                for (int i = size; i > x; i--) {
                    currentNode = currentNode.prev;
                }
            }
        }
        current = x;
    }

    // 현재 노드 오른쪽에 삽입
    static void insert(int s) {
        Node newNode = new Node();
        newNode.data = s;
        newNode.next = currentNode.next;
        newNode.prev = currentNode;
        currentNode.next.prev = newNode;
        currentNode.next = newNode;
        currentNode = newNode; // 삽입한 노드를 현재 노드로 해야 그 뒤에 다음노드 삽입 가능
        current++;
        size++;
    }

    // 현재 노드 오른쪽 삭제
    static void delete() {
        currentNode.next = currentNode.next.next;
        currentNode.next.prev = currentNode;
        size--;
    }

    static void add(int s) {
        Node newNode = new Node();
        newNode.data = s;
        newNode.next = tailNode;
        newNode.prev = tailNode.prev;
        tailNode.prev.next = newNode;
        tailNode.prev = newNode;
        size++;
    }

    static void printTen() {
        Node cur = headNode.next;
        int cnt = 0;
        while (cnt < 10 && cur != tailNode) {
            sb.append(" ").append(cur.data);
            cur = cur.next;
            cnt++;
        }
        sb.append("\n");
    }
}

class Node {
    int data;
    Node prev;
    Node next;
}
