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
		int[] dp = new int[1000001];
		
		dp[2] = 1;
		dp[3] = 1;
		for (int i = 4; i <= n; i++) {
			int cnt = dp[i - 1] + 1;
			if (i % 3 == 0) cnt = Math.min(dp[i / 3] + 1, cnt);
			if (i % 2 == 0) cnt = Math.min(dp[i / 2] + 1, cnt);
			
			dp[i] = cnt;
		}
		
		bw.write(String.valueOf(dp[n]));
		bw.flush();
		br.close();
		bw.close();
	}
}