import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String num = br.readLine();

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += num.charAt(i) - '0';
        }
        bw.write(sum + "");
        bw.flush();
        br.close();
        bw.close();
    }
}