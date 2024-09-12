import java.io.*;
import java.util.*;

public class Main {
	static Character[] yonsei = new Character[] {'Y', 'O', 'N', 'S', 'E', 'I'};
	static Character[] korea = new Character[] {'K', 'O', 'R', 'E', 'A'};
	static int indexY = 0;
	static int indexK = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		
		for(int i = 0; i < S.length(); i++) {
			if(S.charAt(i) == yonsei[indexY]) {
				indexY++;
			}
			if(S.charAt(i) == korea[indexK]) {
				indexK++;
			}
			
			if(indexY == yonsei.length) {
				System.out.println("YONSEI");
				break;
			} else if(indexK == korea.length) {
				System.out.println("KOREA");
				break;
			}
		}
	}
}