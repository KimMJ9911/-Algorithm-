import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());

        bw.write(getQuadrantLocate(x , y) + "");
        bw.flush();
        br.close();
        bw.close();
    }
    static int getQuadrantLocate(int x , int y) {
        if (x > 0) {
            if (y > 0) return 1;
            else return 4;
        } else {
            if (y > 0) return 2;
            else return 3;
        }
    }
}