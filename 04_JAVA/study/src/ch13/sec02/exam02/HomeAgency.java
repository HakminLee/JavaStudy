package ch13.sec02.exam02;

// 인터페이스의 P가 Home으로 전부 대체됨
public class HomeAgency implements Rentable<Home> { //타입 파라미터 P를 Home으로 대체
    @Override
    public Home rent() {
        return new Home();
    }
}
