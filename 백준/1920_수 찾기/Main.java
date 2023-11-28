import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

//1920_수 찾기
public class Main {
    static int givenCount;
    static HashSet<Integer> givenNumSet = new HashSet<>();
    static int targetCount;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        //주어진 숫자 배열
        StringTokenizer st = new StringTokenizer(br.readLine());
        givenCount = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < givenCount; i++) {
            givenNumSet.add(Integer.parseInt(st.nextToken()));
        }

        //찾아야 하는 숫자 배열
        targetCount = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < targetCount; i++) {
            Integer targetNum = Integer.parseInt(st.nextToken());
            if (givenNumSet.contains(targetNum)){
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
