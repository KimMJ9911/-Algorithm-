import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        StringBuilder sb = new StringBuilder();

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        if (A == B && B == C) sb.append(10_000 + A * 1_000);
        else if (A != B && B != C && A != C) {
            int max = IntStream.of(A , B , C).max().getAsInt();
            sb.append(max * 100);
        } else {
            if (A == B) sb.append(A * 100 + 1_000);
            else if (B == C) sb.append(B * 100 + 1_000);
            else sb.append(A * 100 + 1_000);
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }
}