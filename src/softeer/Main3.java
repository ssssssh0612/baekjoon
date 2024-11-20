package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main3 {
    static int cardCount;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);

    }
    public static void input(BufferedReader br) throws  IOException {
        // 카드 개수
        cardCount = Integer.parseInt(br.readLine());
        // 카드 섞기 수행횟수
        int rotate = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < cardCount; i++){
            list.add(i + 1);
        }
        for(int i = 0; i < rotate; i ++){
            int number = Integer.parseInt(br.readLine());
            cardRotate(number, cardCount);
        }
        result();
    }
    public static void result(){
        for(int i = 0; i < 5; i++ ){
            if(i == 4){
                System.out.print(list.get(i));
            }else{
                System.out.print(list.get(i) + " ");
            }
        }
    }


    public static void cardRotate(int number, int cardSize){
        int numberLength = number * 2;
        int checkingNumber = cardSize - (number * 2);
        int addNumberLength = cardSize - number;

        for(int i = number - 1 ; i >= 0; i --){
            int addNumber = list.get(i);
            list.add(addNumberLength,addNumber);
        }

        for (int i = 0; i < number; i++) {
            list.remove(0);
        }

        if(numberLength < checkingNumber){
            cardRotate(number, checkingNumber);
        }
    }
}

