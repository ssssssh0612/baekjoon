package BaekJoon.DataStructure.stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 오큰수_17298 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[a];
        for (int i = 0; i < a; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer> list = new ArrayList<Integer>();
        int[] result = new int[a];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < a; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            result[stack.pop()] = -1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a; i++) {
            sb.append(result[i]).append(' ');
        }

        System.out.println(sb);




























//
//        Scanner in = new Scanner(System.in);
//        Stack<Integer> stack = new Stack<Integer>();
//
//        int N = in.nextInt();
//        int[] seq = new int[N];
//
//        for (int i = 0; i < N; i++) {
//            seq[i] = in.nextInt();
//        }
//        for (int i = 0; i < N; i++) {
//            /*
//             * 스택이 비어있지 않으면서
//             * 현재 원소가 스택의 맨 위 원소가 가리키는 원소보다 큰 경우
//             * 해당 조건을 만족할 때 까지 stack의 원소를 pop하면서
//             * 해당 인덱스의 값을 현재 원소로 바꿔준다.
//             */
//            while (!stack.isEmpty() && seq[stack.peek()] < seq[i]) {
//                seq[stack.pop()] = seq[i];
//            }
//
//            stack.push(i);
//        }
//
//        /*
//         * 스택의 모든 원소를 pop하면서 해당 인덱스의 value를
//         * -1로 초기화한다.
//         */
//        while (!stack.isEmpty()) {
//            seq[stack.pop()] = -1;
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < N; i++) {
//            sb.append(seq[i]).append(' ');
//        }
//
//        System.out.println(sb);
    }
}
