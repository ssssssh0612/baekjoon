package BaekJoon.CodeTree.modernjava.appleFilter;

import BaekJoon.CodeTree.modernjava.Apple;

public class AppleFilterPrintAppleWeight implements AppleFilter {
    @Override
    public String printApple(Apple apple){
        return apple.getWeight() + " ";
    }
}
