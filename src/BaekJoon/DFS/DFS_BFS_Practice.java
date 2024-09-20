package BaekJoon.DFS;

import java.util.LinkedList;
import java.util.Stack;

public class DFS_BFS_Practice {
    public static void main(String[] args) {

    }
}
class Graph {

    class Node {
        int data;
        LinkedList<Node> adjacent;
        boolean visited = false;
        public Node(int data) {
            this.data = data;
            this.visited = false;
            adjacent = new LinkedList<>();
        }
    }
    // 노드들을 저장할 배열이 필요
    Node[] nodes;
    Graph(int size){
        nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
            // 노드의 숫자와
        }
    }
    // 두 노드의 관계를 저장하는 함수
    void addEdge(int v, int w) {
        Node n1 = nodes[v];
        Node n2 = nodes[w];
        if(!n1.adjacent.contains(n2)){
            n1.adjacent.add(n2);
        }
        if(!n2.adjacent.contains(n1)){
            n2.adjacent.add(n1);
        }
    }

    void dfs(int index){
        Node root = nodes[index];
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        root.visited = true;
        while(!stack.isEmpty()){
            Node r = stack.pop();
            for ( Node n : r.adjacent){
                if(n.visited == false){
                    n.visited = true;
                    stack.push(n);
                }
            }
            visit(r);
        }

    }
    void visit(Node n){
        System.out.println(n.data +" ");
    }
}