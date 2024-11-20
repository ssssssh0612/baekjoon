package softeer;

import javax.sound.sampled.Line;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
    }

    public static void input(BufferedReader br) throws  IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        while(st.hasMoreTokens()){
            int number = Integer.parseInt(st.nextToken());
            if(list.contains(number)){
                for(int i = 0; i < list.size(); i++){
                    int check = list.get(i);
                    if(check == number){
                        list.remove(i);
                        break;
                    }
                }
                list.add(0,number);
            }else{
                list.add(0,number);
                if(list.size() == 4 ){
                    // 3번째꺼를 빼서 넣어주기
                    int resultNumber = list.remove(3);
                    result.add(resultNumber);
                }
            }
//            System.out.println(list);
            // 리스트에 추가하면서 해당 이게 잇는지 없는지 체크하고 리스트의 길이를 3으로 맞춰야함
            // 추가하기전에 일단 list에 추가하려는게 존재하는지 안존재하는지 체크
        }
        if(result.isEmpty()){
            System.out.println(0);
        }else{
            for (int number : result) {
                System.out.print(number + " ");
            }
        }
    }
}
