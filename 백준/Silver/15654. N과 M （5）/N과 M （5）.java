import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n , m;
	static int[] arr , ans;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine() , " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		visited = new boolean[n];
		ans = new int[m];
		
		st = new StringTokenizer(br.readLine() , " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		DFS(0);
		
		bw.write(String.valueOf(sb));
		bw.flush();
		br.close();
		bw.close();
	}
	
	static void DFS(int depth) {
		if (depth == m) {
			for (int i = 0; i < m; i++) {
				sb.append(ans[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				ans[depth] = arr[i];
				DFS(depth + 1);
				ans[depth] = 0;
				visited[i] = false;
			}
		}
	}
}