package ch03.sec04;

public class AccuracyExample1 {
    public static void main(String[] args) {
        int apple = 1;
        int totalPieces = apple * 10; // 사과를 10조각으로 나눈 총 조각 수
        int number = 7;

        int remainingPieces = totalPieces - number;
        double result = remainingPieces / 10.0; // 남은 조각을 다시 사과의 개수로 변환

        System.out.println("사과 1개에서 남은 양: " + result);
    }
}

