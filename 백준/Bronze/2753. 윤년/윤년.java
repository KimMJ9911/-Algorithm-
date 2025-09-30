import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        if ((n % 4 == 0 && n % 100 != 0) || n % 400 == 0) bw.write(String.valueOf(1));
        else bw.write(String.valueOf(0));
        bw.flush();
        br.close();
        bw.close();
    }
}