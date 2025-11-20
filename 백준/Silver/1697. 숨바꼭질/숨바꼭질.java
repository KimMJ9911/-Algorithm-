import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] visited , arr;
	static int n , k;
	static Queue<Integer> queue;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine() , " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		visited = new int[100_001];
		queue = new LinkedList<>();
		
		queue.offer(n);
		
		if (k > n) {
			BFS();
			bw.write(visited[k] + "");
		} else bw.write(n - k + "");
		
		bw.flush();
		br.close();
		bw.close();
	}
	
	static void BFS() {
		int cnt = 0;
		while (!queue.isEmpty()) {
			int next = queue.poll();
			
			if (next > 0 && visited[next - 1] == 0) {
				queue.add(next - 1);
				visited[next - 1] = visited[next] + 1;
			}
			
			if (next < 100_000 && visited[next + 1] == 0) {
				queue.add(next + 1);
				visited[next + 1] = visited[next] + 1;
			}
			
			if (next < 50_001 && visited[next * 2] == 0) {
				queue.add(next * 2);
				visited[next * 2] = visited[next] + 1;
			}
			
		}
	}
}