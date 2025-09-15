import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] status;
    static boolean[] visited;
    static int n , sub = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        visited = new boolean[n];
        status = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            for (int j = 0; j < n; j++) {
                status[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Capacity(0 , 0);

        bw.write(sub + "");
        bw.flush();
        br.close();
        bw.close();
    }
    static List<Integer> team_A = new ArrayList<>() , team_B = new ArrayList<>();

    private static void Capacity(int k , int depth) {
        if (depth == n / 2) {
            team_A.clear();
            team_B.clear();

            for (int i = 0; i < n; i++) {
                if (visited[i]) team_A.add(i);
                else team_B.add(i);
            }

            int val = Math.abs(calculate(team_A) - calculate(team_B));
            sub = Math.min(val , sub);
        } else {
            for (int i = k; i < n; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    Capacity(i + 1 , depth + 1);
                    visited[i] = false;
                }
            }
        }
    }

    private static int calculate(List<Integer> team) {
        int ans = 0;
        for (int i = 0; i < team.size() - 1; i++) {
            for (int j = i + 1; j < team.size(); j++) {
                ans += status[team.get(i)][team.get(j)] + status[team.get(j)][team.get(i)];
            }
        }
        return ans;
    }
}