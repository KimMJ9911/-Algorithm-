import java.io.*;

public class Main {
    static int n;
    static int[][] QTree;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        n = Integer.parseInt(br.readLine());
        QTree = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                QTree[i][j] = line.charAt(j) - '0';
            }
        }

        solution(0 , 0 , n);

        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }

    private static void solution(int x , int y , int k) {
        int init = QTree[x][y];
        boolean flag = false;
        for (int i = x; i < x + k; i++) {
            for (int j = y; j < y + k; j++) {
                if (init == QTree[i][j]) flag = true;
                else {
                    flag = false;
                    break;
                }
            }
            if (!flag) break;
        }

        if (flag) sb.append(init);
        else {
            sb.append("(");
            solution(x , y , k / 2);
            solution(x , y + k / 2 , k / 2);
            solution(x + k / 2 , y , k / 2);
            solution(x + k / 2 , y + k / 2 , k / 2);
            sb.append(")");
        }
    }
}