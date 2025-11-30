import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int go_to_sleep = Integer.parseInt(br.readLine());
        int wake_up = Integer.parseInt(br.readLine());

        int ans = 0;
        if (go_to_sleep >= 20) ans = 24 - (go_to_sleep - wake_up);
        else ans = wake_up - go_to_sleep;
        sb.append(ans);

        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }
}