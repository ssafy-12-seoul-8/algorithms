import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		Stack stack = new Stack();

		int N = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String com = st.nextToken();

			switch (com) {
			case "push":
				stack.push(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				sb.append(stack.pop()).append("\n");
				break;
			case "size":
				sb.append(stack.size()).append("\n");
				break;
			case "empty":
				sb.append(stack.empty()).append("\n");
				break;
			case "top":
				sb.append(stack.top()).append("\n");
				break;
			}
		}

		System.out.println(sb);

	}

}

class Node {

	int data;
	Node link;

}

class Stack {

	Node tail;
	int size;

	Stack() {
		tail = new Node();
	}

	void push(int data) {

		size++;

		Node newNode = new Node();
		newNode.data = data;
		newNode.link = tail;
		tail = newNode;

	}

	int pop() {

		if (size == 0) {
			return -1;
		}

		size--;
		int num = tail.data;
		tail = tail.link;
		return num;

	}

	int size() {

		return size;

	}

	int empty() {

		if (size == 0) {
			return 1;
		}

		return 0;

	}

	int top() {

		if (size == 0) {
			return -1;
		}
		
		return tail.data;

	}

}