package BaekJoon.Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 영단어암기는괴로워_20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            String a = br.readLine();
            if(a.length() >= m){
                map.put(a,map.getOrDefault(a,0) + 1);
            }
        }
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list,new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                if(Integer.compare( map.get(o1), map.get(o2)) != 0 ){
                    return map.get(o2) - map.get(o1);
                }
                if((o1.length() != o2.length())){
                    return o2.length() - o1.length();
                }
                return o1.compareTo(o2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for( String str : list){
            sb.append(str).append("\n");
        }
        System.out.println(sb);
    }
}
