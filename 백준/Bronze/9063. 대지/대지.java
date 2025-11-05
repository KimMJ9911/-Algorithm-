import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int MAX_X = Integer.MIN_VALUE;
		int MAX_Y = Integer.MIN_VALUE;
		int MIN_X = Integer.MAX_VALUE;
		int MIN_Y = Integer.MAX_VALUE;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			MAX_X = Math.max(MAX_X, x);
			MIN_X = Math.min(MIN_X, x);
			MAX_Y = Math.max(MAX_Y, y);
			MIN_Y = Math.min(MIN_Y, y);
		}
		
		int ans = (MAX_X - MIN_X) * (MAX_Y - MIN_Y);
		bw.write(String.valueOf(ans));
		bw.flush();
		br.close();
		bw.close();
	}
}