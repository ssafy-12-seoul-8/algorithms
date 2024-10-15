import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {		
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
		StringBuilder S = new StringBuilder(br.readLine());
		
		System.out.println(S.length());
	}
}