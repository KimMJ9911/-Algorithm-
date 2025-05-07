import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n , m;
    static String[] chess_Board;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine() , " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        chess_Board = new String[n];
        for (int i = 0; i < n; i++) {
            chess_Board[i] = br.readLine();
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                ans = Math.min(check_chess_Board(i , j) , ans);
            }
        }

        bw.write(ans + "");
        bw.flush();
        br.close();
        bw.close();
    }
    static int check_chess_Board(int x , int y) {
        String start_board_1 = "WBWBWBWB";
        String start_board_2 = "BWBWBWBW";
        int ans = 0;

        int ans_W = 0;
        int ans_B = 0;
        for (int i = x; i < x + 8; i++) {

            for (int j = y; j < y + 8; j++) {
                if (chess_Board[i].charAt(j) != start_board_1.charAt(j - y)) {
                    ans_W++;
                }

                if (chess_Board[i].charAt(j) != start_board_2.charAt(j - y)) {
                    ans_B++;
                }

            }
            if (start_board_1.equals("WBWBWBWB")) start_board_1 = "BWBWBWBW";
            else start_board_1 = "WBWBWBWB";
            
            if (start_board_2.equals("BWBWBWBW")) start_board_2 = "WBWBWBWB";
            else start_board_2 = "BWBWBWBW";

        }
        return Math.min(ans_W , ans_B);
    }
}