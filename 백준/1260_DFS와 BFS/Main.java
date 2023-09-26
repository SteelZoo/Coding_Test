import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int N, M, V;
    static int[][] map;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int dep = Integer.parseInt(st.nextToken());
            int des = Integer.parseInt(st.nextToken());

            map[dep][des]++;
            map[des][dep]++;
        }

        dfs(V);

        sb.append("\n");

        visited = new boolean[N + 1];

        bfs(V);

        System.out.println(sb);
    }

    static void dfs(int start) {
        Stack<Integer> stack = new Stack<>();

        stack.push(start);

        while (!stack.isEmpty()) {
            int temp = stack.pop();

            if (!visited[temp]) {
                visited[temp] = true;
                sb.append(temp).append(" ");
            }

            for (int i = N; i >= 1; i--) {
                if (i != temp) {
                    if (map[temp][i] != 0) {
                        if (!visited[i]) {
                            stack.push(i);
                        }
                    }
                }
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;
        sb.append(start).append(" ");

        while (!queue.isEmpty()) {
            int temp = queue.poll();

            for (int i = 1; i <= N; i++) {
                if (i != temp) {
                    if (map[temp][i] != 0) {
                        if (!visited[i]) {
                            queue.add(i);
                            visited[i] = true;
                            sb.append(i).append(" ");
                        }
                    }
                }
            }
        }
    }
}