package bj;

import java.awt.event.WindowAdapter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class bj_2164 {
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
//        int pow = (int)(Math.log10(count)/Math.log10(2));
//        int answer = (int)Math.pow(2,pow);
//
//        bw.write(Integer.toString(answer));
        for (int i = 1; i <= count ; i++) {
            q.add(i);
        }

        while (q.size() > 1){
            q.poll();
            Integer poll = q.poll();
            q.add(poll);
        }
        int answer = q.poll();
        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }
}
