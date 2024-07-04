package ch02.sec09;

public class StringConcatExample {
    public static void main(String[] args) {
        //숫자 연산
        int result1 = 10+2+8;
        System.out.println("result1: "+ result1);

        //결합 연산
//        숫자 두개가 앞에 낭오면 숫자부터 계산한 후 문자열 결합
        String result2 = 10+2+"8";
        System.out.println("result2: "+result2);

//실수를 정수에 넣을 경우 소수점 이하 값은 버려진다.
//맨 앞에 두개 중 하나라고 문자열이면 그 후로는 문자열 결합
        String result3 = 10+"2"+8;
        System.out.println("result3: "+result3);

        String result4 = "10"+2+8;
        System.out.println("result4 = " + result4);

     String result5 = "10"+(2+8);
        System.out.println("result5 = " +result5);
    }
}
