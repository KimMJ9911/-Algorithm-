import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String[] C = br.readLine().split("");
        int all_size = C.length;
        String word = "";

        for (int i = 0; i < all_size; i++) {
            if (!word.contains(C[i])) word += C[i];
        }
        int word_size = word.length();
        //케이스 받을 때 바로 넣기 위해 + 1
        int[][] arr = new int[word_size + 1][all_size + 1];

        for (int i = 0; i < word_size; i++) {
            int cnt = 0;
            for (int j = 0; j < all_size; j++) {
                if (String.valueOf(word.charAt(i)).equals(C[j])) cnt++;
                arr[i + 1][j + 1] = cnt;
            }
        }

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String k = st.nextToken();
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int loc = word.indexOf(k);

            //r > 1
            //누적합 알고리즘에 의해
            sb.append(arr[loc + 1][r + 1] - arr[loc + 1][l]).append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }
}