import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(br.readLine());

        A += C / 60;
        B += C % 60;

        int h = 0;
        int m = 0;
        if (B >= 60) {
            m = B % 60;
            h = B / 60;
        } else m = B;

        A += h;

        if (A >= 24) {
            A -= 24;
            h = A;
        } else h = A;

        bw.write(h + " " + m);
        bw.flush();
        br.close();
        bw.close();
    }
}