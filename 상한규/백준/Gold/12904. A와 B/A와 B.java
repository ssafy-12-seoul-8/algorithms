import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {		
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
		StringBuilder S = new StringBuilder(br.readLine());
		StringBuilder T = new StringBuilder(br.readLine());
		
		
		while(T.length() != S.length()) {
			if(T.charAt(T.length() - 1) == 'A') {
				T = new StringBuilder(T.substring(0, T.length() - 1));
			} else if(T.charAt(T.length() - 1) == 'B') {
				T = new StringBuilder(T.substring(0, T.length() - 1)).reverse();
			}
		}
		
		System.out.println(S.toString().equals(T.toString()) ? 1 : 0);
	}
}