import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        Map<String , Integer> color_data = new HashMap<>();
        color_data.put("red" , 1);
        color_data.put("orange" , 2);
        color_data.put("yellow" , 3);
        color_data.put("green" , 4);
        color_data.put("blue" , 5);
        color_data.put("purple" , 6);

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            int val_1 = color_data.get(st.nextToken());
            int val_2 = color_data.get(st.nextToken());
            int val = Math.abs(val_1 - val_2);
            if (val == 0) sb.append("E").append("\n");
            else if (val == 1 || val == 5) sb.append("A").append("\n");
            else if (val == 3) sb.append("C").append("\n");
            else sb.append("X").append("\n");
        }

        bw.write(sb + "");
        bw.flush();
        br.close();
        bw.close();
    }
}