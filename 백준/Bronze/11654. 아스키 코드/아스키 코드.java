import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char ans = br.readLine().charAt(0);
        bw.write((int) ans + "");
        bw.flush();
        br.close();
        bw.close();
    }
}