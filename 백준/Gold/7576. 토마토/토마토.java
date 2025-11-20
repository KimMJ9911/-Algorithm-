import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int[][] tomato_box , visited;
	static int n , m;
	static Queue<int[]> queue;
	static int[] dx = {-1 , 1 , 0 , 0} , dy = {0 , 0 ,-1 , 1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine() , " ");
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		visited = new int[n][m];
		tomato_box = new int[n][m];
		queue = new LinkedList<>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			for (int j = 0; j < m; j++) {
				tomato_box[i][j] = Integer.parseInt(st.nextToken());
				if (tomato_box[i][j] == 0) visited[i][j] = -1;
				if (tomato_box[i][j] == 1) queue.offer(new int[] {i , j});
			}
		}
		
		BFS();
		
		int ans = Integer.MIN_VALUE;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visited[i][j] == -1) {
					bw.write("-1");
					bw.flush();
					return;
				}
				ans = Math.max(ans, visited[i][j]);
			}
		}
		
		
		bw.write(String.valueOf(ans));
		bw.flush();
		br.close();
		bw.close();
	}
	
	static void BFS() {
		while (!queue.isEmpty()) {
			int[] next = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = next[1] + dx[i];
				int ny = next[0] + dy[i];
				
				if (isValid(nx , ny) && visited[ny][nx] == -1) {
					visited[ny][nx] = visited[next[0]][next[1]] + 1;
					//새로운 1을 저장
					queue.offer(new int[] {ny , nx});
				}
			}
		}
	}
	
	static boolean isValid(int nx , int ny) {
		if (nx < 0 || ny < 0 || nx >= m || ny >= n)
			return false;
		return true;
	}
}