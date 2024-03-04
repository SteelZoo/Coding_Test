import java.io.*;
import java.util.*;

public class Main {
    static int sNum; // 학생수
    static int aNum; // 구간수
    static int[] sArray; // 점수 배열
    static int[] sumArray; // 구간합 배열

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        sNum = Integer.parseInt(st.nextToken());
        aNum = Integer.parseInt(st.nextToken());
        sArray = new int[sNum];
        sumArray = new int[sNum];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < sNum; i++){ // 구간 합 배열 초기화
            int temp = Integer.parseInt(st.nextToken());
            if (i == 0){ // 인덱스가 0일때는 그냥저장
                sumArray[i] = temp;
            } else { // 0이 아닐 때는 구간 합 로직 적용
                sumArray[i] = sumArray[i-1] + temp;
            }
        }

        // 정답 풀이
        for(int i = 0; i < aNum; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            String answer = getAvg(start, end);
            sb.append(answer).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    // 구간 평균 반환 함수
    static String getAvg(int start, int end){
        double result = 0.0;

        int l = start - 1;
        int r = end - 1;

        int sum = 0;
        if(l == 0){
            sum = sumArray[r];
        } else {
            sum = sumArray[r] - sumArray[l-1];
        }

        result = ((double)sum)/((double)(r-l+1));

        return String.format("%.2f",result);
    }
}