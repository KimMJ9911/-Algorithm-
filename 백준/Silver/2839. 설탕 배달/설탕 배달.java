import java.io.*;

public class Main {
    static final int five = 5;
    static final int three = 3;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int t = n / five;
        int ans = Integer.MAX_VALUE;
        boolean flag = false;

        for (int i = t; i >= 0; i--) {
            if ((n - i * five) % three == 0) {
                flag = true;
                ans = Math.min(ans , i + (n - i * five) / three);
            }
        }

        if (!flag) ans = -1;

        bw.write(ans + "");
        bw.flush();
        br.close();
        bw.close();
    }
}