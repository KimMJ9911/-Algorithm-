import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        n /= 4;
        sb.append("long ".repeat(n)).append("int");

        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }
}