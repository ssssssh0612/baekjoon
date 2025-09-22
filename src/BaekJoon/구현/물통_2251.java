package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 물통_2251 {
    static boolean[][][] visited = new boolean[201][201][201];
    static boolean[] check = new boolean[201];
    static int[] arr = new int[3];
    static int a;
    static int b;
    static int c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[3];
        a = Integer.parseInt(st.nextToken());
        arr[0] = a;
        b = Integer.parseInt(st.nextToken());
        arr[1] = b;
        c = Integer.parseInt(st.nextToken());
        arr[2] = c;

        bfs();
        for (int i = 0; i < check.length; i++) {
            if(check[i]){
                System.out.print(i + " ");
            }
        }
    }
    public static void bfs(){
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0,0,c});
        visited[0][0][c] = true;
        while(!queue.isEmpty()){
            int[] now = queue.poll();

            if(now[0] == 0) check[now[2]] = true;
//            System.out.println(now[0] + " " + now[1] + " " + now[2]);
            // 물을 담을 수 있는 양
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(i == j) continue;

                    // 물을 i -> j 이런식으로 옮김
                    // 물을 붓는 쪽이 0이거나 받는쪽이 꽉 차거나
                    // 일단 붓는 쪽은 0보다 커야함

                    // 물을 부울 수 있나 ?
                    if(now[i] > 0){
                        // 부울 수 있다면 물을 붓고나서의 상태를 확인
                        // 붓기 전 상태 확인

                        // 부울 수 있는 물의 양
                        int addWater = now[i];

                        // 물통의 빈 양
                        int bottle = arr[j] - now[j];

                        if(bottle == 0) continue;

                        if(addWater > bottle){
                            int[] add = new int[]{-1,-1,-1};
                            add[i] = addWater - bottle;
                            add[j] = arr[j];
                            for (int k = 0; k < 3; k++) {
                                if(add[k] == -1){
                                    add[k] = now[k];
                                    break;
                                }
                            }
                            if(!visited[add[0]][add[1]][add[2]]){
                                queue.add(add);
                                visited[add[0]][add[1]][add[2]] = true;
                            }
                        }else if(addWater < bottle){
                            int[] add = new int[]{-1,-1,-1};
                            add[i] = 0;
                            add[j] = now[j] + addWater;
                            for (int k = 0; k < 3; k++) {
                                if(add[k] == -1){
                                    add[k] = now[k];
                                    break;
                                }
                            }
                            if(!visited[add[0]][add[1]][add[2]]){
                                queue.add(add);
                                visited[add[0]][add[1]][add[2]] = true;
                            }
                        }else{
                            int[] add = new int[]{-1,-1,-1};
                            add[i] = 0;
                            add[j] = arr[j];
                            for (int k = 0; k < 3; k++) {
                                if(add[k] == -1){
                                    add[k] = now[k];
                                    break;
                                }
                            }
                            if(!visited[add[0]][add[1]][add[2]]){
                                queue.add(add);
                                visited[add[0]][add[1]][add[2]] = true;
                            }
                        }
                    }
                }
            }



        }

    }
}
