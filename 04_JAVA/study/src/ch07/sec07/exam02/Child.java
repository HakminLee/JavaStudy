package ch07.sec07.exam02;

public class Child extends Parent {
// 메소드 오버라이딩

    @Override
    public void methods2() {
        System.out.println("Child-methods2()");
    }

    //메소드 선언
    public void methods3() {
        System.out.println("Child-methods3()");
    }
}
