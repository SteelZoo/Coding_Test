package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class bj_2217 {
    static Integer[] ropeArray;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        ropeArray = new Integer[count];
        for (int i = 0; i < count; i++) {
            ropeArray[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ropeArray,((o1, o2) -> {
            return o2-o1;
        }));

        int max = 0;
        for (int i = 0; i < ropeArray.length; i++) {
            int nowMax = ropeArray[i]*(i+1);
            if (nowMax > max) max = nowMax;
        }

        bw.write(Integer.toString(max));
        bw.flush();
        bw.close();
    }
}
