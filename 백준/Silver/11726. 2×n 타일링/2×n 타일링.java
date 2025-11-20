import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int DIV = 10_007;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		//1 -> 2
		//2 -> 2
		//3 -> 3
		//4 -> 5 1111 , 112 , 121 , 211 , 22
		//5 -> 8 11111 , 1112 , 1121 , 1211 , 2111 , 122 , 212 , 221 
		//점화식 : dp[i] = dp[i-2] + dp[i-1]
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n + 1];
		
		if (n == 1) sb.append(1);
		else if (n == 2) sb.append(2);
		else {
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 3;
			for (int i = 3; i <= n; i++) {
				dp[i] = (dp[i - 2] + dp[i - 1]) % DIV;
			}
			
			sb.append(dp[n]);
		}
		
		bw.write(String.valueOf(sb));
		bw.flush();
		br.close();
		bw.close();
	}
}