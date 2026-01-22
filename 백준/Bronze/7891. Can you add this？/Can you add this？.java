import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine() , " ");

            Long A = Long.parseLong(st.nextToken());
            Long B = Long.parseLong(st.nextToken());

            sb.append(A + B).append("\n");
        }


        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }
}