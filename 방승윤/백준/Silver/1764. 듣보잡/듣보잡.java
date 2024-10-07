import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Set<String> list = new HashSet<String>();
		List<String> listDBJ = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			list.add(br.readLine());
		}
		
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			if (list.contains(str)) {
				listDBJ.add(str);
			}
		}
		
		listDBJ.sort(null);
		
		sb.append(listDBJ.size()).append("\n");
		
		for (String str : listDBJ) {
			sb.append(str).append("\n");
		}
		
		System.out.print(sb);
		
	}
		
}