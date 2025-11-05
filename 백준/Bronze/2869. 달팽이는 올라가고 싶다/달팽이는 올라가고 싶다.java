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
		
		st = new StringTokenizer(br.readLine() , " ");
		long up = Long.parseLong(st.nextToken());
		long down = Long.parseLong(st.nextToken());
		long length = Long.parseLong(st.nextToken()) - up;
		long mid_term = 0L;
		long term = 0L;
		
		mid_term = length / (up - down);
		if (length > mid_term * (up - down)) term = mid_term + 1;
		else term = mid_term;
		
		bw.write(String.valueOf(term + 1));
		bw.flush();
		br.close();
		bw.close();
	}
}