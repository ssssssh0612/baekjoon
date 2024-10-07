package BaekJoon.DataStructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 트럭_13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        int[] queueArr = new int[n];
        for (int i = 0; i < n; i++) {
            queueArr[i] = Integer.parseInt(st.nextToken());
        }
        int index = 0;
        int weight = queueArr[0];
        queue.add(queueArr[index]);
        while(!queue.isEmpty()) {
            
            if(queue.size() < k && ) {

            }
        }
    }
}
