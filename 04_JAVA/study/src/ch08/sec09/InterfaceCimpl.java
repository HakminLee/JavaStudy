package ch08.sec09;

public class InterfaceCimpl implements InterfaceC {
    @Override
    public void methodA() {
        System.out.println("InterfaceCImpl-methodA() 실행");
    }

    public void methodB(){
        System.out.println("InterfaceCImpl-methodB() 실행");
    }

    public void methodC() {
        System.out.println("InterfaceCImpl-methodC() 실행");
    }
}
