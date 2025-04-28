import java.io.*;

public class Main {
    public static final int five = 5;
    public static final int three = 3;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int ans = Integer.MAX_VALUE;
        int stand = n / five;
        boolean flag = false;

        for (int i = stand; i >= 0; i--) {
            if ((n - five * i) % three == 0) {
                flag = true;
                ans = Math.min(ans , i + (n - five * i) / three);
            }
        }

        if (!flag) ans = -1;

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}