import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine() , " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine() , " ");
		long[] len = new long[n];
		for (int i = 0; i < n; i++) {
			len[i] = Long.parseLong(st.nextToken());
		}
		
		
		long end = Arrays.stream(len).max().getAsLong();
		long total = 0L;
		long start = 0L;
		long mid = 0L;
		
		while (true) {
			mid = (end + start) / 2;
			if (end < start) break;
			
			
			for (int i = 0; i < n; i++) {
				if (len[i] - mid >= 0) total += len[i] - mid;
			}
			
			if (total > m) {
				start = mid + 1;
				total = 0;
			} else if (total == m) break;
			else {
				end = mid - 1;
				total = 0;
			}
		}
		
		sb.append(mid);
		
		bw.write(String.valueOf(sb));
		bw.flush();
		br.close();
		bw.close();
	}
}