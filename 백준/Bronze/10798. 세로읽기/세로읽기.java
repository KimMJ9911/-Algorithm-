import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String[][] mag = new String[15][15];

        for (int i = 0; i < 5; i++) {
            String[] line = br.readLine().split("");

            for (int j = 0; j < line.length; j++) {
                mag[i][j] = line[j];
            }

            for (int j = line.length; j < 15; j++) {
                mag[i][j] = null;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (mag[j][i] != null) sb.append(mag[j][i]);
            }
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }
}