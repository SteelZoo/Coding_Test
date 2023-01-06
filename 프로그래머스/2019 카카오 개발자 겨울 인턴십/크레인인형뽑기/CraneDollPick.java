import java.util.ArrayList;
import java.util.List;

public class CraneDollPick {
    public static void main(String[] args) {
        //테스트
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};


        System.out.println(new CraneDollPick().solution(board,moves));
    }


    //해답
    //import java.util.ArrayList; 을 코드위에 작성해줘야함
    public int solution(int[][] board, int[] moves) {
        int result=0;
        List<Integer> basket = new ArrayList<>();
        int height = board.length;

        for(int i: moves){
            i-=1;
            for(int j=0;j<height;j++){
                if(board[j][i]!=0){
                    basket.add(board[j][i]);

                    board[j][i]=0;
                    if(basket.size()>=2
                            &&basket.get(basket.size()-1)== basket.get(basket.size()-2)){
                        basket.remove(basket.size()-1);
                        basket.remove(basket.size()-1);
                        result+=2;
                    }

                    break;
                }
            }
        }
        int answer = result;
        return answer;
    }

}
