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
		
		long n = Long.parseLong(br.readLine());
		sb.append(n * (n - 1) * (n - 2) / 6).append("\n").append(3);
		
		bw.write(String.valueOf(sb));
		bw.flush();
		br.close();
		bw.close();
	}
}