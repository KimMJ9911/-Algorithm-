import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int Double = 1;
        int init = 2;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            if (i != 0) Double *= 2;
            init += Double;
        }

        int ans = init * init;

        bw.write(ans + "");
        bw.flush();
        br.close();
        bw.close();
    }
}