package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class 코드트리DB {
    static LinkedHashMap<String,Integer> map = new LinkedHashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int queryCount = Integer.parseInt(br.readLine());
        while(queryCount > 0) {
            queryCount--;
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if(str.equals("init")){
                map.clear();
            }else if(str.equals("insert")){
                String name = st.nextToken();
                int value = Integer.parseInt(st.nextToken());
                insert(name,value);
            }else if(str.equals("delete")){
                String name = st.nextToken();
                delete(name);
            }else if(str.equals("rank")){
                int number = Integer.parseInt(st.nextToken());
                rank();
            }else{
                rank();
            }
        }

    }
    public static void init(){

    }
    public static void insert(String name, int value){
        if(map.containsKey(name) || map.containsValue(value)){
            System.out.println("0");
        }else{
            map.put(name,value);
            System.out.println("1");
        }
    }
    public static void delete(String name){
        if(map.containsKey(name)){
            System.out.println(map.get(name));
            map.remove(name);
        }else{
            System.out.println("0");
        }
    }
    public static void rank(){
        System.out.println(map);
    }
    public static void sum(){

    }
}
