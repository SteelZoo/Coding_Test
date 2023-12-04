package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_1026 {
    static Integer[] a;
    static Integer[] b;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        a = new Integer[count];
        b = new Integer[count];
        //a
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < count; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        //b
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < count; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        Arrays.sort(b, (o1, o2) -> {
            return o2 - o1;
        });

        int answer = 0;
        for (int i = 0; i < a.length; i++) {
            answer += (a[i] * b[i]);
        }

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }
}

//재귀 풀이
//public class bj_1026 {
//    static int[] a;
//    static int[] b;
//    static boolean[] aVisit;
//    static LinkedList<Integer> aSorted = new LinkedList<>();
//    static int answer = Integer.MAX_VALUE;
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int count = Integer.parseInt(st.nextToken());
//        a = new int[count];
//        b = new int[count];
//        aVisit = new boolean[count];
//        //a
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < count; i++) {
//            a[i] = Integer.parseInt(st.nextToken());
//        }
//        //b
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < count; i++) {
//            b[i] = Integer.parseInt(st.nextToken());
//        }
//
//        minValueByRecur(0, 0);
//
//        bw.write(Integer.toString(answer));
//        bw.flush();
//        bw.close();
//    }
//
//    public static void minValueByRecur(int depth, int total) {
//        if (total > answer) return;
//        if (depth == a.length) {
//            answer = total;
//            return;
//        }
//
//        for (int i = 0; i < a.length; i++) {
//            if (!aVisit[i]) {
//                aVisit[i] = true;
//                aSorted.add(a[i]);
//                minValueByRecur(depth + 1, (total + (aSorted.getLast() * b[aSorted.size()-1])));
//                aSorted.removeLast();
//                aVisit[i] = false;
//            }
//        }
//    }
//
//}
