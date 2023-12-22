package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//1012_유기농 배추
public class bj_1012 {
    static int[][] news = {{-1,0},{0,1},{1,0},{0,-1}};
    static boolean[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        // 각 테스트 케이스
        for (int tc = 0; tc < T; tc++) {
            // 케이스 별 정보
            st = new StringTokenizer(br.readLine());
            int col = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());
            int cabbage = Integer.parseInt(st.nextToken());

            // 케이스별 맵 설정
            map = new boolean[row][col];
            for (int i = 0; i < cabbage; i++) {
                st = new StringTokenizer(br.readLine());
                int colP = Integer.parseInt(st.nextToken());
                int rowP = Integer.parseInt(st.nextToken());

                map[rowP][colP] = true;
            }

            int answer = getSectionCount();
            sb.append(answer).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static int getSectionCount(){
        int result = 0;

        // bfs 큐
        Queue<int[]> q = new LinkedList<>();

        int[] point = getNotCheckedPoint(); //시작 지점
        while (point != null){
            q.add(point);
            map[point[0]][point[1]] = false;
            while (!q.isEmpty()){
                int[] poll = q.poll();
                for (int i = 0; i < news.length; i++) {
                    int tRow = poll[0] + news[i][0];
                    int tCol = poll[1] + news[i][1];

                    if ((0 <= tRow && tRow < map.length && 0 <= tCol && tCol < map[0].length)
                            &&map[tRow][tCol]){
                        map[tRow][tCol] = false;
                        q.add(new int[]{tRow,tCol});
                    }
                }
            }

            result++;
            point = getNotCheckedPoint();
        }

        return result;
    }

    static int[] getNotCheckedPoint(){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j]){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
}
