package ch04.sec02;

public class IfElseExample {
    public static void main(String[] args) {
        int score = 85;
        // if-else문은 위의 if문dl  true일 경우 아래 조건을 체크하지 않는다.
        if (score >= 90) {
            System.out.println("점수가 90보다 큽니다");
            System.out.println("등급은 A입니다.");
        }
        // 중괄호로 묶어주지 않는 경우 한줄까지만 if문 내에 있는 문장으로 인식
        else {
            System.out.println("점수가 90보다 작습니다");
            System.out.println("등급은 B입니다.");

        }
    }
}
