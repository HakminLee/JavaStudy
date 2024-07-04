package ch03.sec11;

public class ConditionalOperatorExample {
    public static void main(String[] args) {
        int score = 85;

        // 보통 if-else문을 간략히 쓸 때 사용한다.
        char grade = (score>90) ? 'A' : ((score>80)?'B':'C');
        System.out.println(score+"점은 " + grade+"등급 입니다.");
    }
}
