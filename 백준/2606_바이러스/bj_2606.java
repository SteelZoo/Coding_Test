package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bj_2606 {
    static boolean[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int comCount = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int pairCount = Integer.parseInt(st.nextToken());

        map = new boolean[comCount+1][comCount+1];
        visited = new boolean[comCount+1];

        for (int i = 0; i < pairCount; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = true;
            map[b][a] = true;
        }

        int answer = bfs();
        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }

    static int bfs(){
        int result = 0;
        LinkedList<Integer> q = new LinkedList<>();

        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()){
            int poll = q.poll();
            for (int i = 0; i < map[poll].length; i++) {
                if (map[poll][i] && !visited[i]){
                    visited[i] = true;
                    result++;
                    q.add(i);
                }
            }
        }

        return result;
    }
}
