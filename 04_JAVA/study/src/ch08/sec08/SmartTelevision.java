package ch08.sec08;

public class SmartTelevision implements RemoteControl, Serchable {
    //turnON 추상 메소드 오버라이딩
    @Override
    public void turnOn() {
        System.out.println("tv를 켭니다.");
    }

    //turnOff 추상 메소드 오버라이딩
    @Override
    public void turnOff() {
        System.out.println("Tv를 끕니다.");
    }
    //serch() 추상메소드 오버라이딩

    @Override
    public void serch(String url) {
        System.out.println(url + "을 검색합니다.");
    }
}
