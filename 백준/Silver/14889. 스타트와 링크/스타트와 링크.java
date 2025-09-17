import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int n , cnt = Integer.MAX_VALUE;
    private static int[][] arr;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        visited = new boolean[n];
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        set_Capacity(0 , 0);

        bw.write(String.valueOf(cnt));
        bw.flush();
        br.close();
        bw.close();
    }
    static List<Integer> team_start = new ArrayList<>() , team_link = new ArrayList<>();

    private static void set_Capacity(int k , int depth) {
        if (depth == n / 2) {
            team_start.clear();
            team_link.clear();

            for (int i = 0; i < n; i++) {
                if (visited[i]) team_start.add(i);
                else team_link.add(i);
            }
            
            int val = Math.abs(capacity(team_start) - capacity(team_link));
            cnt = Math.min(cnt , val);
        } else {
            for (int i = k; i < n; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    set_Capacity(i + 1 , depth + 1);
                    visited[i] = false;
                }
            }
        }
    }

    private static int capacity(List<Integer> team) {
        int sum = 0;
        for (int i = 0; i < team.size() - 1; i++) {
            for (int j = i + 1; j < team.size(); j++) {
                sum += arr[team.get(i)][team.get(j)] + arr[team.get(j)][team.get(i)];
            }
        }
        return sum;
    }
}