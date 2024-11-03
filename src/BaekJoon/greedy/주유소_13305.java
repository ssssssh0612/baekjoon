package BaekJoon.greedy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주유소_13305 {
    static int nodeCount;
    static long[] distance;
    static int[] node;
    static long resultPay = 0;

    public static void main(String[] args) throws IOException {
        // 나보다 주유숫자가 낮은 지역까지 주유할 리터를 계산해서 이동하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
        start();
        System.out.println(resultPay);
    }

    public static void input(BufferedReader br) throws IOException {
        nodeCount = Integer.parseInt(br.readLine());
        distance = new long[nodeCount - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nodeCount - 1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }
        node = new int[nodeCount];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nodeCount; i++) {
            node[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void start() {
        long nodePay = node[0];
        for(int i = 0 ; i < node.length -1 ; i ++){
            resultPay += nodePay * distance[i];

            if(nodePay > node[i + 1]){
                nodePay = node[i + 1];
            }
        }
    }
}
