import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max = Integer.MIN_VALUE;
        int idx = 0;
        for (int i = 1; i <= 9; i++) {
            int val = Integer.parseInt(br.readLine());
            if (max < val) {
                max = val;
                idx = i;
            }
        }

        bw.write(max + "\n" + idx);
        bw.flush();
        br.close();
        bw.close();
    }
}