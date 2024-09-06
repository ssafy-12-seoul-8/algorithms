import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		BigInteger A = new BigInteger(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		BigInteger B = new BigInteger(st.nextToken());
		
		sb.append(A.add(B)).append("\n").append(A.subtract(B)).append("\n").append(A.multiply(B));
		
		System.out.println(sb);
		
	}
	
}
