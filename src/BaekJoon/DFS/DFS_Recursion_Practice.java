package BaekJoon.DFS;

public class DFS_Recursion_Practice {
    static int [][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};
    static boolean [] visited = new boolean[9];

    // 2차원 배열에서
    public static void main(String[] args) {
        dfs(1);
    }
    public static void dfs(int index){
        visited[index] = true;
        System.out.print(index +"->");
        //1->2->6->8->3->5->4->7->
        for (int i = 0; i < graph[index].length; i++) {
            if(!visited[graph[index][i]]){
                dfs(graph[index][i]);
            }
        }
    }
}
