package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class AC_5430 {
    static int length;
    static boolean check = true;
    static Deque<Integer> deque = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for(int i = 0; i < testCase; i ++){
            // R은 배열에 있는 수의 순서를 뒤집는 함수이고,
            // D는 첫 번째 수를 버리는 함수이다.
            String str = input(br);
            boolean checking = false;
            for(int j = 0 ; j < str.length(); j ++){
                char ch = str.charAt(j);
                if(ch == 'R'){
                    check = !check;
                }else{
                    // 배열이 비어있는데 D를 사용한 경우에는 에러가 발생한다.
                    if(deque.isEmpty()){
                       System.out.print("error");
                       checking = true;
                       break;
                    }
                    if(check){
                        deque.pollFirst();
                    }else{
                        deque.pollLast();
                    }
                }
            }
            if(!checking){
                System.out.print("[");
                while(!deque.isEmpty()){
                    if(check){
                        System.out.print(deque.pollFirst());
                    }else{
                        System.out.print(deque.pollLast());
                    }
                    if(!deque.isEmpty()){
                        System.out.print(",");
                    }
                }
                System.out.print("]");
            }
            System.out.println();
            check = true;
            deque.clear();
        }
    }
    public static String input(BufferedReader br) throws IOException {
        String str = br.readLine();
        length = Integer.parseInt(br.readLine());
        String numbers = br.readLine();
        int index = 1;
        StringBuilder sb = new StringBuilder();
        while(true){
            // 숫자인지 아닌지 검증하기...
            // 쉼표가 나왔다면 현재까지 저장된 builder 숫자로 바꿔서 넣어주기
            char ch = numbers.charAt(index);
            if( ch != ']' && ch != ','){
                // 아니라면 숫자라는 의미
                sb.append(ch);
                index++;
            }else if( ch == ','){
                // builder 숫자로 바꿔서 넣어주기
                deque.add(changeNumber(sb));
                sb = new StringBuilder();
                index++;
            }else {
                if(sb.length() == 0){
                    break;
                }
                deque.add(changeNumber(sb));
                sb = new StringBuilder();
            }
        }
        return str;
    }

    public static int changeNumber(StringBuilder str){
        int result = 0;
        int index = 0;
        for(int i = str.length() - 1; i >= 0; i --){
            int number = str.charAt(i) - '0';
            if(index == 0){
                result += number;
                index++;
            }else{
                result += checkingNumber(index) * number;
                index++;
            }
        }
        return result;
    }
    public static int checkingNumber(int check){
        if(check == 0){
            return 1;
        }
        return 10 * checkingNumber(check - 1);
    }
}

