import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();
		String bomb = br.readLine();
		
		Stack<Character> afterBomb = new Stack<>();
		
		one: for (int i = 0; i < str.length(); i++) {
			afterBomb.push(str.charAt(i));
			
			if (afterBomb.size() >= bomb.length() && str.charAt(i) == bomb.charAt(bomb.length() - 1)) {
				for (int j = 1; j < bomb.length(); j++) {
					if (afterBomb.get(afterBomb.size() - 1 - j) != bomb.charAt(bomb.length() - 1 - j)) {
						continue one;
					}
				}
				
				for (int j = 0; j < bomb.length(); j++) {
					afterBomb.pop();
				}
			}
		}
		
		for (char c : afterBomb) {
			sb.append(c);
		}
		
		System.out.println(afterBomb.size() != 0 ? sb : "FRULA");

	}

}