import java.io.*;
import java.util.*;

public class Main {
    static int[] rank , inDegree;
    static boolean[][] tk;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine() , " ");
            rank = new int[n];
            inDegree = new int[n + 1];
            tk = new boolean[n + 1][n + 1];
            //순위 미리 받아두기 -> 순위를 통해 나중에 가중치를 받을 예정
            for (int j = 0; j < n; j++) {
                rank[j] = Integer.parseInt(st.nextToken());
            }
            //순서에 대한 T/F 를 판단하기 위한 데이터 받기
            //해당 순서가 맞는지 미리 저장
            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int start = rank[j];
                    int end = rank[k];

                    tk[start][end] = true;
                    inDegree[end]++;
                }
            }
            int m = Integer.parseInt(br.readLine());
            //뒤바꿀 순서 받기
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine() , " ");
                int team_1 = Integer.parseInt(st.nextToken());
                int team_2 = Integer.parseInt(st.nextToken());

                if (tk[team_1][team_2]) {
                    tk[team_1][team_2] = false;
                    tk[team_2][team_1] = true;
                    inDegree[team_1]++;
                    inDegree[team_2]--;
                } else {
                    tk[team_1][team_2] = true;
                    tk[team_2][team_1] = false;
                    inDegree[team_1]--;
                    inDegree[team_2]++;
                }
            }

            Queue<Integer> queue = new LinkedList<>();
            List<Integer> ans = new ArrayList<>();
            boolean flag = true;
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (inDegree[j] == 0) queue.offer(j);
            }

            while (!queue.isEmpty()) {
                //가중치가 2개 이상인 경우 순서를 특정할 수 없는 경우이므로 바로 탈출 후 Impossible 반환
                if (queue.size() > 1) {
                    flag = false;
                    break;
                }

                int next = queue.poll();
                ans.add(next);
                cnt++;
                for (int j = 1; j <= n; j++) {
                    if (tk[next][j]) {
                        inDegree[j]--;
                        if (inDegree[j] == 0) queue.offer(j);
                    }
                }
            }

            //순서를 알 수 없는 경우와 별개로 모든 노드를 순회하지 않은 경우도 포함해야 한다.
            if (!flag || cnt < n) sb.append("IMPOSSIBLE");
            else {
                for (Integer a : ans) {
                    sb.append(a).append(" ");
                }
            }
            sb.append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }
}