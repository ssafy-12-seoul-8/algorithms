import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			Map<String, Integer> map = new HashMap<>();
			Set<String> set = new HashSet<>();
			int N = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				st.nextToken();
				String type = st.nextToken();
				
				if (!set.contains(type)) {
					if (map.containsKey(type)) {
						map.replace(type, map.get(type) + 1);
					} else {
						map.put(type, 1);
					}
				}
			}
			
			int cnt = 1;
			
			for (String cloth : map.keySet()) {
				cnt *= map.get(cloth) + 1;
			}
			
			sb.append(cnt - 1).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
}