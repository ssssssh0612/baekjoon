package BaekJoon.CodeTree.modernjava.appleFilter;

import BaekJoon.CodeTree.modernjava.Apple;

public class AppleFilterPrintAppleIsHandsome implements AppleFilter{
    @Override
    public String printApple(Apple apple){
        return (apple.isHandsome()) ? "handSomeApple" : "uglyApple";
    }
}
