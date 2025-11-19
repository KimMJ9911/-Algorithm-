import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[][] sudoku;
	static boolean[][] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		//1 -> 1
		//2 -> 2
		//3 -> 4
		//4 -> 7
		//5 = 11111 / 122 , 212 , 221 / 1112 , 1121 , 1211 , 2111 / 32 , 23 / 311 , 131 , 113 -> 13
		//6 -> 24
		//점화식 -> dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1]
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[12];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int i = 4; i <= 11; i++) {
			dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
		}
		
		for (int i = 0; i < n; i++) {
			sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
		}
		
		bw.write(String.valueOf(sb));
		bw.flush();
		br.close();
		bw.close();
	}
}