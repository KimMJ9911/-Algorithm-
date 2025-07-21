import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int x , y;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        if (a == 0) {
            y = c / b;
            x = (f - e * c / b) / d;
        }
        else if (b == 0) {
            x = c / a;
            y = (f - d * c / a) / e;
        }
        else if (d == 0) {
            y = f / e;
            x = (c - b * f / e) / a;
        }
        else if (e == 0) {
            x = f / d;
            y = (c - a * f / d) / b;
        }
        else {
            y = (c * d  - f * a) / (d * b - a * e);
            x = (c * e - f * b) / (a * e - b * d);
        }

        bw.write(x + " " + y);
        bw.flush();
        br.close();
        bw.close();
    }
}