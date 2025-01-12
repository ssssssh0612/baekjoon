package BaekJoon.tree;

import java.io.*;
import java.util.StringTokenizer;

class Node{
    char root;
    Node left;
    Node right;
    public Node(char root, Node left, Node right){
        this.root = root;
        this.left = left;
        this.right = right;
    }
}
public class 트리순회_1991_Practice {
    static Node head = new Node('A',null,null);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            insertNode(head, root, left, right);
        }
        preOrder(head);
        System.out.println();
        inOrder(head);
        System.out.println();
        postOrder(head);
        System.out.println();

    }
    private static void preOrder(Node node) {
        if (node == null) { // 더 이상 값이 없을 때 까지
            return;
        }
        System.out.print(node.root); // 출력
        preOrder(node.left); // 왼쪽 노드 탐색
        preOrder(node.right); // 오른쪽 노드 탐색
    }
    // 중위순회
    // 왼쪽 서브트리 → 현재 노드 → 오른쪽 서브트리
    private static void inOrder(Node node) {
        if (node == null) { // 더 이상 값이 없을 때 까지
            return;
        }
        inOrder(node.left); // 왼쪽 노드 탐색
        System.out.print(node.root); // 출력
        inOrder(node.right); // 오른쪽 노드 탐색
    }
    // 후위순회
    // 왼쪽 서브트리 → 오른쪽 서브트리 → 현재 노드
    private static void postOrder(Node node) {
        if (node == null) { // 더 이상 값이 없을 때 까지
            return;
        }
        postOrder(node.left); // 왼쪽 노드 탐색
        postOrder(node.right); // 오른쪽 노드 탐색
        System.out.print(node.root); // 출력
    }

    public static void insertNode(Node tmp, char root, char left, char right){
        if(tmp.root == root){
            if(left != '.'){
                tmp.left = new Node(left,null,null);
            }else{
                tmp.left = null;
            }

            if(right != '.'){
                tmp.right = new Node(right, null, null);
            }else{
                tmp.right = null;
            }
            // tmp.left = (left == '.' ? null : new Node(left, null, null));
            // tmp.right = (right == '.' ? null : new Node(right, null, null));
        }else{
            if(tmp.left != null){
                insertNode(tmp.left, root, left, right);
            }
            if(tmp.right != null){
                insertNode(tmp.right, root, left, right);
            }
        }
    }
}
