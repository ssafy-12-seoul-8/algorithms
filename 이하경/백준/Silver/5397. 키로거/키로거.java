import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static Node[] linkedList;
	static int nextId;
	static int cursor;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			String input = br.readLine();

			int n = input.length();
			init(n);
			for (int i = 0; i < n; i++) {
				char c = input.charAt(i);

				if (c == '-') {
					remove();
				} else if (c == '<') {
					moveLeft();
				} else if (c == '>') {
					moveRight();
				} else {
					add(c);
				}
			}

			print();
		}
		System.out.println(sb);
	}

	static void init(int n) {
		nextId = 0;
		cursor = 0;
		linkedList = new Node[n + 2];
		linkedList[nextId] = new Node(nextId++, ' ');
		linkedList[nextId] = new Node(nextId++, ' ');
		linkedList[0].next = 1;
		linkedList[0].prev = -1;
		linkedList[1].next = -1;
		linkedList[1].prev = 0;
	}

	static void add(char c) {
		Node newNode = new Node(nextId, c);
		linkedList[nextId++] = newNode;
		newNode.next = linkedList[cursor].next;
		newNode.prev = cursor;
		linkedList[newNode.next].prev = newNode.id;
		linkedList[newNode.prev].next = newNode.id;
		cursor = newNode.id;
	}

	static void remove() {
		if (cursor == 0) {
			return;
		}
		linkedList[linkedList[cursor].next].prev = linkedList[cursor].prev;
		linkedList[linkedList[cursor].prev].next = linkedList[cursor].next;
		cursor = linkedList[cursor].prev;
	}

	static void moveLeft() {
		if (cursor == 0) {
			return;
		}
		cursor = linkedList[cursor].prev;
	}

	static void moveRight() {
		if (linkedList[cursor].next == 1) {
			return;
		}
		cursor = linkedList[cursor].next;
	}

	static void print() {
		int idx = linkedList[0].next;

		while (idx != 1) { // 1이 tail Node의 index
			sb.append(linkedList[idx].data);
			idx = linkedList[idx].next;
		}
		sb.append("\n");
	}
}

class Node {
	int id;
	char data;
	int prev;
	int next;

	public Node(int id, char data) {
		this.id = id;
		this.data = data;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return data + " " + prev + " " + next;
	}
}
