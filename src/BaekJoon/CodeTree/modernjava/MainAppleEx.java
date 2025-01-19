package BaekJoon.CodeTree.modernjava;

import BaekJoon.CodeTree.modernjava.appleFilter.AppleFilterPrintAppleIsHandsome;
import BaekJoon.CodeTree.modernjava.appleFilter.AppleFilterPrintAppleWeight;

import java.util.ArrayList;
import java.util.List;

public class MainAppleEx {
    public static void main(String[] args){

        // 사과를 넣기
        List<Apple> appleList = new ArrayList<>();
        // 색, 무게, 잘생김
        appleList.add(new Apple("red", 10, true));
        appleList.add(new Apple("green", 20, false));
        appleList.add(new Apple("blue", 30, true));
        appleList.add(new Apple("green", 40, false));
        appleList.add(new Apple("red", 10, true));
        appleList.add(new Apple("blue", 20, false));
        appleList.add(new Apple("green", 30, false));
        ServiceApple.prettyPrintApple(appleList, new AppleFilterPrintAppleIsHandsome());
        ServiceApple.prettyPrintApple(appleList, new AppleFilterPrintAppleWeight());

    }
}
