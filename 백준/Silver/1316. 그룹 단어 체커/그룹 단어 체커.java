import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int ans_cnt = 0;
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            List<Character> current = new ArrayList<>();

            if (word.length() == 1) ans_cnt++;
            else {
                boolean flag = false;
                current.add(word.charAt(0));

                for (int j = 1; j < word.length(); j++) {
                    char pre = word.charAt(j - 1);
                    char now = word.charAt(j);
                    if (now != pre) {
                        if (current.contains(now)) {
                            flag = true;
                            break;
                        } else {
                            current.add(now);
                        }
                    }
                }

                if (!flag) ans_cnt++;
            }
        }
        bw.write(ans_cnt + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}