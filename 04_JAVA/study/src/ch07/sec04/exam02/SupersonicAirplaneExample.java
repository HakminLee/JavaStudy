package ch07.sec04.exam02;

public class SupersonicAirplaneExample {
public static void main(String[] args) {
    SupersonicAirplane sa = new SupersonicAirplane();
//    Airplane의 takeOff 메소드 실행
    sa.takeoff();
//    flyMode의 기본값이 Normal이므로 Airplane의 fly호출
    sa.fly();
//    static 값은 클래스명으로 접근.
//    fltMode를 SUPERSONIC으로 변경해줌
    sa.flymode = SupersonicAirplane.SUPERSONIC;
//    flyMODE가 SUPERSONIC으로 변경됐으므로 if문을 통해 자식의 코드 출력
    sa.fly();
    sa.flymode = SupersonicAirplane.NORMAL;
//    다시 NORMAL로 변경됐으므로 Airplane의 fly호출
    sa.fly();
//    Airplane의 land 메소드 실행
    sa.land();
}
}
