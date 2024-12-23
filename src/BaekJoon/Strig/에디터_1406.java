package BaekJoon.Strig;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class 에디터_1406 {
    static int cursor;
    static String str;
    static LinkedList<Character> list = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        int index = 0;
        for (int i = 0; i < (str.length() * 2) + 1; i++) {
            if( i % 2 == 0 ){
                list.add(' ');
            }else{
                list.add(str.charAt(index));
                index++;
            }
        }

        int number = Integer.parseInt(br.readLine());
        cursor = list.size() - 1;
        for (int i = 0; i < number; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
//            System.out.println("??");
            if(order.equals("P")){
                String character = st.nextToken();
                P(character.charAt(0));
            } else if (order.equals("L")) {
                L();
            } else if (order.equals("D")) {
                D();
            } else {
                B();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) != ' '){
                sb.append(list.get(i));
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//writer선언
        bw.write(sb + "\n");
    }
    //L 커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
    //D	커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
    //삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로임
    //P $	$라는 문자를 커서 왼쪽에 추가함
    public static void B(){
    //B	커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨)
        if(cursor != 0){
            list.remove(cursor - 1);
            list.remove(cursor - 1);
            cursor -= 2;
        }
    }
    public static void D(){
        if(cursor != list.size() - 1){
            cursor += 2;
        }
    }
    public static void L(){
        if(cursor != 0){
            cursor -= 2;
        }
    }
    // _ a _ b _ c _ d _
    // 0 1 2 3 4 5 6 7 8
    // _ a _ b _ c _ d _ f _
    // 0 1 2 3 4 5 6 7 8 9 10
    public static void P(char ch){
        list.add(cursor, ch);
        list.add(cursor, ' ');
        cursor += 2;
//        for (int i = 0; i < list.size(); i++) {
//            System.out.print(list.get(i) + " ");
//        }
//        System.out.println(cursor);
    }
}
