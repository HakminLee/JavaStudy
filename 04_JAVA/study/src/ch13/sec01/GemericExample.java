package ch13.sec01;

import javax.swing.*;

public class GemericExample {
    public static void main(String[] args) {
        //Box<String> box1 = new Box<String>();
        // 앞에 타입이 들어가면 뒤에 <>안에 타입은 생략 가능(타입 추론)
        Box<String> box1 = new Box(); // Box 생성시 타입파라미터인 T/ 대신 Sting으로 대체
        box1.content = "안녕하세요";
        String str = box1.content;
        System.out.println(str);

        // generic에 들러가는 타입은 무조건 참조 형식이어야 한다.
        //Box<Integer> box2 = new Box<Integer>();
        Box<Integer> box2 = new Box<>(); // Box 생성시 타입파라미터 T 대신 Integer로 대체
        box2.content = 100;
        int value = box2.content;
        System.out.println(value);
    }
}
