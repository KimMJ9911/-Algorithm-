import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        sb.append(n * n).append("\n")
                .append(2);

        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }
}