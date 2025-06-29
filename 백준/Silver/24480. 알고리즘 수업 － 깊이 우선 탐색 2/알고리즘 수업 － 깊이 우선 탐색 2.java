import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    //무방향 그래프 작성
    static List<List<Integer>> graph = new ArrayList<>();
    //방문 배열 작성
    static boolean[] visited;
    static int[] sequence;
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

        //정점의 수 + 1 만큼 방문 배열 작성
            //index 표시에서 혼선이 없도록 하기 위함
        visited = new boolean[n + 1];
        sequence = new int[n + 1];

        //그래프 형식 완성
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        //정점 이동방향을 받아 간선 작성 (그래프 작성)
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            //양방향 그래프 작성
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        //무작위로 간선을 받았으므로 내림차순으로 정렬
        for (int i = 0; i < graph.size(); i++) {
            Collections.sort(graph.get(i) , Collections.reverseOrder());
        }

        cnt = 1;
        DFS(r);

        for (int i = 1; i < sequence.length; i++) {
            sb.append(sequence[i]).append("\n");
        }

        bw.write(sb + "");
        bw.flush();
        br.close();
        bw.close();
    }
    static void DFS(int start_vertex) {
        visited[start_vertex] = true;
        sequence[start_vertex] = cnt;
        for (int i = 0; i < graph.get(start_vertex).size(); i++) {
            int next_vertex = graph.get(start_vertex).get(i);
            if (!visited[next_vertex]) {
                cnt++;
                DFS(next_vertex);
            }
        }
    }
}