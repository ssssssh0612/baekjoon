package BaekJoon.DataStructure.stack;

import java.util.*;

public class 스택_수열_1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        List<Boolean> flag = new ArrayList<>();
        boolean check = true;
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        int startNum = 1;
        for (int i = 0; i < n; i++) {
            if( startNum > list.get(i)){
                if(Objects.equals(list.get(i), stack.pop())){
                    flag.add(false);
                }else{
                    check = false;
                    break;
                }
            }else if ( startNum < list.get(i)){
                for (int j = startNum; j <= list.get(i) ; j++) {
                    stack.push(j);
                    flag.add(true);
                    startNum++;
                }
                stack.pop();
                flag.add(false);
            }else if( startNum == list.get(i)){
                stack.push(startNum);
                flag.add(true);
                stack.pop();
                flag.add(false);
                startNum++;
            }

        }
        if(check){
            for (int i = 0; i < flag.size(); i++) {
                if(flag.get(i)){
                    System.out.println("+");
                }else{
                    System.out.println("-");
                }
            }
        }else{
            System.out.println("NO");
        }
        // 리스트에 저장하고

    }
}
