
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
		int cnt = 0;
		int idx = 0;
		
		while (idx < n) {
			cnt++;
			idx += cnt;
		}
		//짝수인 경우 시작이 오른쪽
		if (cnt % 2 == 0) {
			sb.append(cnt - (idx - n)).append("/").append(idx - n +1);
		} else {
			sb.append(idx - n + 1).append("/").append(cnt - (idx - n));
		}
		
		bw.write(String.valueOf(sb));
		bw.flush();
		br.close();
		bw.close();
	}
}