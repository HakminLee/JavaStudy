package ch16.sec04;

import ch16.sec01.Calculable;

public class Person {
    public void action(Calcuable calcuable){
//        clac 함수는 매개변수가 2개고 return 값이 double인 함수 - 예측 가능
        double result = calcuable.calc(10,4);
        System.out.println("결과: "+result);
    }
}
