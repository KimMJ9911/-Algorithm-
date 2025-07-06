import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static int[] dp_Black , dp_White;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int max = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            int B = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            dp_Black = new int[B];
            dp_White = new int[W];

            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int Z = Integer.parseInt(st.nextToken());
            max = search_MAX(B , W , X , Y , Z);

            bw.write(max + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    static int search_MAX(int B, int W, int X, int Y, int Z) {
        //검은 공이 가능한 경우는 검은 상자 or 흰 상자 -> B * X or B * Z
        //반대로 흰 공이 가능한 경우는 -> W * Y or W * Z
        int MAX_B = 0;

        //검은 공 먼저 들어가는 경우
        int bt = 0;
        if (X > Z) {
            MAX_B = B * X + W * Y;
        } else {
            if (B >= W) MAX_B = Math.max(W * Z  + (B - W) * X + W * Z, B * X + W * Y);
            else MAX_B = Math.max(B * Z + (W - B) * Y + B * Z , B * X + W * Y);
        }

        int MAX_W = 0;
        if (Y > Z) {
            MAX_W = B * X + W * Y;
        } else {
            if (B >= W) MAX_W = Math.max(W * Z  + (B - W) * X + W * Z, B * X + W * Y);
            else MAX_W = Math.max(B * Z + (W - B) * Y + B * Z , B * X + W * Y);
        }

        return Math.max(MAX_B , MAX_W);
    }
}