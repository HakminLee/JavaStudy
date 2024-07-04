package ch07.sec08.exam01;

public class CarExample {
    public static void main(String[] args) {
        //Car 객체 생성
        Car myCar = new Car();
        // 동일하게 myCar의 run 메소드를 호출했지만 각기 다른 run이 호출됨
        // 가장 마지막에 호출한 run으로 저장되어, 다른 메소드 호출하려면 다시 불러줘야함

        //Tire 객체 장착
        //Tire 객체 하나를 생성해서 Car 클래스의 tire 필드에 넣어줌
        myCar.tire = new Tire();
        myCar.run();

        //한국타이어의 run 메소드 호출
        myCar.tire = new HakookTire();
        myCar.run();

        // 금호타이어의 run 메소드 호출
        myCar.tire = new KumhoTire();
        myCar.run();


    }
}
