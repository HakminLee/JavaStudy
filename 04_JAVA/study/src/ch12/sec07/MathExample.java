package ch12.sec07;

public class MathExample {
    public static void main(String[] args) {
        // 큰 정수 또는 작은 정수 얻기
        double v1 = Math.ceil(5.3);
        // ceil : 해당 값을 올림
        double v2 = Math.floor(5.3);
        // floor : 해당 값을 내림
        System.out.println("v1: " + v1);
        System.out.println("v2: " + v2);

        // 큰 값 또는 작은 값 얻기
        long v3 = Math.max(3,7);
        // max : 둘 중 큰 값 얻기
        long v4 = Math.min(3,7);
        // min : 둥 중 작은 값 얻기
        System.out.println("v3: " + v3);
        System.out.println("v4: " + v4);

        //소수 이하 두 자리 얻기
        double value = 12.3456;
        double temp1 = value * 100; // 1234.56
        long temp2 = Math.round(temp1); //1325
//        round: 해당 값을 반올림 처리
        double v5 = temp2 / 100.0; //12.35
        System.out.println("v5= " + v5);
    }
}
