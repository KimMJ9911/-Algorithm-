import java.io.*;
import java.util.*;

//위상 정렬 알고리즘 다시 정리하기 (유형화)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //위상정렬 알고리즘 구현
        st = new StringTokenizer(br.readLine() , " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        //수가 n + 2개 이므로 그 숫자들을 잇는 선의 갯수는 n + 1이다
        int[] inDegree = new int[n + 1];
        //그래프 가중치를 생각하면 최초 값의 앞 값과 뒷 값이 존재해야 하므로 총 n + 2게 필요하다
        for (int i = 0; i <= n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        //그래프 생성
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            int val_1 = Integer.parseInt(st.nextToken());
            int val_2 = Integer.parseInt(st.nextToken());
            //인접 리스트를 이용해 차수가 없는 그래프를 구현했다. 해당 그래프를 저장하는 방식을 생각하면 수를 이어주어야 한다.
            graph.get(val_1).add(val_2);
            //다음에 올 값은 현재 값 = val_1 보다 아래에 존재하는 차수가 하나 더해진 값이 된다.
            inDegree[val_2]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        //초기 값인 차수가 0인 시작값을 queue에 먼저 저장
        for (int i = 1; i < inDegree.length; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int val = queue.poll();
            //척 번째 값은 차수가 0으로 확정된 값이므로 바로 정답 배열에 저장
            //다음 값 부터는 차수를 0으로 만든 후 저장
            ans.add(val);
            for (int next : graph.get(val)) {
                inDegree[next]--;
                if (inDegree[next] == 0) queue.add(next);
            }
        }

        for (Integer an : ans) {
            bw.write(an + " ");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}