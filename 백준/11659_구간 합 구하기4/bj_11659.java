package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj_11659 {
    static int[] array;
    static int[] sumArray;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int total = Integer.parseInt(st.nextToken());
        int test_case = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        array = new int[total];
        sumArray = new int[total];
        for (int i = 0; i < total; i++) {
            array[i] = Integer.parseInt(st.nextToken());
            if (i == 0){
                sumArray[i] = array[i];
            } else {
                sumArray[i] = array[i] + sumArray[i-1];
            }
        }

        for (int i = 0; i <test_case; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end  = Integer.parseInt(st.nextToken());
            sb.append(getSum(start,end)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static int getSum(int start, int end){
        start--;
        end--;

        if (start == 0){
            return sumArray[end];
        } else {
            return sumArray[end] - sumArray[start-1];
        }
    }
}
