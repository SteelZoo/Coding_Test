package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bj_15655 {
    static int arrayLength;
    static int depth;
    static int[] array;
    static boolean[] visited;
    static LinkedList<Integer> comb = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        arrayLength = Integer.parseInt(st.nextToken());
        depth = Integer.parseInt(st.nextToken());
        array = new int[arrayLength];
        visited = new boolean[arrayLength];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arrayLength; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);

        combination(0,0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void combination(int nowDepth,int start){
        if (nowDepth == depth){
            combToString();
            return;
        }

        for (int i = start; i < arrayLength; i++) {
            if (visited[i] == false){
                visited[i] = true;
                comb.add(array[i]);
                combination(nowDepth+1,i+1);
                visited[i] = false;
                comb.removeLast();
            }
        }
    }

    static void combToString(){
        for (Integer e:comb) {
            sb.append(e.toString()).append(" ");
        }
        sb.append("\n");
    }
}
