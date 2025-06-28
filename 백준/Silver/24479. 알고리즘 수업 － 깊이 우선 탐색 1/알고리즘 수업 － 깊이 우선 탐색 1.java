import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    //그래프 생성
    static List<List<Integer>> graph = new ArrayList<>();
    //방문 배열
    static int[] visited;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine() , " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        visited = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        //간선 받기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            //그래프 간선 그리기 , 양방향 그래프로 그리기
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        //그래프 간선을 맘대로 받았으므로 크기 순서대로 정렬 (오름차순 설정)
        for (int i = 0; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
        }

        cnt = 1;
        DFS(r);

        //방문여부 배열에 간선에 방문 길이가 저장되어 있다.
        //index 편의를 위해 n + 1 개를 담았다.
        for (int i = 1; i < visited.length; i++) {
            sb.append(visited[i]).append("\n");
        }

        bw.write(sb + "");
        bw.flush();
        br.close();
        bw.close();
    }

    static void DFS(int m) {
        //방문 처리
        visited[m] = cnt;
        //갈 수 있는 간선 방향의 갯수만큼 반복
        for (int i = 0; i < graph.get(m).size(); i++) {
            //다음으로 갈 수 있는 정점
            int next = graph.get(m).get(i);
            //방문한 적이 없다면?
            if (visited[next] == 0) {
                cnt++;
                //다음 정점 방문하기
                DFS(next);
            }
        }
    }
}