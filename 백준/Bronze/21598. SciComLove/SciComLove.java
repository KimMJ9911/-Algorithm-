import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        IntStream.range(0 , n).forEach(i -> {
            sb.append("SciComLove").append("\n");
        });

        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }
}