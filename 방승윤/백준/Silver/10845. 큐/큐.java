import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		Queue queue = new Queue();

		int N = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String com = st.nextToken();

			switch (com) {
			case "push":
				queue.push(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				sb.append(queue.pop()).append("\n");
				break;
			case "size":
				sb.append(queue.size()).append("\n");
				break;
			case "empty":
				sb.append(queue.empty()).append("\n");
				break;
			case "front":
				sb.append(queue.front()).append("\n");
				break;
			case "back":
				sb.append(queue.back()).append("\n");
				break;
			}
		}

		System.out.println(sb);

	}

}

class QueueNode {

	int data;
	QueueNode next;
	QueueNode prev;

}

class Queue {

	QueueNode head;
	QueueNode tail;
	int size;

	Queue() {
		head = new QueueNode();
		tail = new QueueNode();
		head.next = tail;
		tail.prev = head;
	}

	void push(int data) {

		size++;

		QueueNode newNode = new QueueNode();
		newNode.data = data;
		newNode.prev = tail.prev;
		newNode.next = tail;
		tail.prev.next = newNode;
		tail.prev = newNode;

	}

	int pop() {

		if (size == 0) {
			return -1;
		}

		size--;
		int num = head.next.data;
		head.next = head.next.next;
		head.next.prev = head;
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

	int front() {

		if (size == 0) {
			return -1;
		}
		
		return head.next.data;

	}
	
	int back() {
		
		if (size == 0) {
			return -1;
		}
		
		return tail.prev.data;
		
	}

}