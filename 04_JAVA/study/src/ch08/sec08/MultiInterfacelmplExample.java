package ch08.sec08;

public class MultiInterfacelmplExample {
    public static void main(String[] args) {
        //RemoteControl 인터페이스 변수 선언 및 구현 객체 대입
        RemoteControl rc=new SmartTelevision();
        //RemoteControl 인터페이스에 선언된 추상 메소드만 호출 가능
        rc.turnOn();
        rc.turnOff();

        //Serchable 인터페이스 변수 선언 및 구현 객체 대입
        Serchable serchable = new SmartTelevision();
        serchable.serch("http://www.youtube.com");
    }

}
