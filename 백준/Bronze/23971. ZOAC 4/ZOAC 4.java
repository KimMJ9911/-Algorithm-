import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        //앉는 가짓수를 구하는게 아니라 최대 인원을 구하는거라 DFS 는 안써도 될 듯???
        st = new StringTokenizer(br.readLine() , " ");
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken()) + 1;
        int m = Integer.parseInt(st.nextToken()) + 1;

        int horizon = 0;
        int vertical = 0;

        if (h % n == 0) horizon = h / n;
        else horizon = h / n + 1;
        if (w % m == 0) vertical = w / m;
        else vertical = w / m + 1;

        bw.write(String.valueOf(horizon * vertical));
        bw.flush();
        br.close();
        bw.close();
    }
}