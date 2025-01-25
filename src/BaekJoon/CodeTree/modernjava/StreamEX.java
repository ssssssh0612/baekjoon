package BaekJoon.CodeTree.modernjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

class Node{
    String name;
    int number;
    public Node(String name, int number){
        this.name = name;
        this.number = number;
    }
    public int getNumber(){
        return this.number;
    }
    public String getName(){
        return this.name;
    }
}
public class StreamEX {
    public static void main(String[] args){
        List<String> words = Arrays.asList("Modern", "Java", "In", "Action");
        List<Node> nodeList = new ArrayList<>();
        nodeList.add(new Node("nodeName1",10));
        nodeList.add(new Node("nodeName2",20));
        nodeList.add(new Node("nodeName3",30));
        nodeList.add(new Node("nodeName4",40));
        nodeList.add(new Node("nodeName5",50));
        int check = nodeList.stream().map(Node::getNumber).reduce(0, Integer::sum);
        System.out.println(check);
//  /      Map<String, List<Integer>> map = nodeList.stream().collect(groupingBy(Node::getName));
//
//        List<String[]> wordLengths = words.stream()
//                .map(word -> word.split(""))
//                .distinct()
//                .toList();
//        for(int i = 0 ; i < wordLengths.size(); i++){
//            String[] strLength = wordLengths.get(i);
//            for(int j = 0 ; j < strLength.length; j++){
//                System.out.print(strLength[j]+ " ");
//            }
//            System.out.println();
//        }
    }
}
