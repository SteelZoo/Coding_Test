package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

//10974_모든 순열
public class bj_10974 {
    static StringBuilder sb = new StringBuilder();
    static LinkedList<Integer> list = new LinkedList<>();
    static boolean[] visited;
    static int num;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        num = Integer.parseInt(br.readLine());
        visited = new boolean[num+1];

        getPermutation(1);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void getPermutation(int depth){
        if (depth>num){
            printList();
            return;
        }

        for (int i = 1; i <= num; i++) {
            if (!visited[i]){
                visited[i] = true;
                list.add(i);
                getPermutation(depth+1);
                visited[i] = false;
                list.removeLast();
            }
        }
    }
    static void printList(){
        for (Integer i : list) {
            sb.append(i.toString()).append(" ");
        }
        sb.append("\n");
    }
}
