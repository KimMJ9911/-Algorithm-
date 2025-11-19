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
		int c = Integer.parseInt(st.nextToken());
		long[] arr = new long[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		Arrays.sort(arr);
		
		long end = arr[n - 1] - arr[0];
		long start = 1L;
		long mid = 0L;
		long ans = 0L;
		
		while (true) {
			if (start > end) break;
			//가능한 거리 최댓값
			mid = (start + end) / 2;
			int cnt = 1;
			long curr = arr[0];
			
			for (int i = 1; i < n; i++) {
				if (arr[i] - curr >= mid) {
					cnt++;
					curr = arr[i];
				}
				
			}
			
			if (cnt >= c) {
				start = mid + 1;
				ans = mid;
			} else end = mid - 1;
		}
		
		
		
		bw.write(String.valueOf(ans));
		bw.flush();
		br.close();
		bw.close();
	}
}