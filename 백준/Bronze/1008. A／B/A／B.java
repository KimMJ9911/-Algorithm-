import java.io.*;
import java.text.DecimalFormat;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine() , " ");
        double n = Double.parseDouble(st.nextToken());
        double m = Double.parseDouble(st.nextToken());

        DecimalFormat df = new DecimalFormat("0.000000000");

        sb.append(df.format(n / m)).append("\n");

        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }
}