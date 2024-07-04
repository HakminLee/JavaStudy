package ch16.sec02.exam02;

public class Button {
    @FunctionalInterface
    public static interface Clicklistener{
        //추상메소드
        void onClick();
    }

    //필드
    private Clicklistener clicklistener;

    //메소드
    public void setClicklistener(Clicklistener clicklistener) {
        this.clicklistener = clicklistener;
    }

    public void click(){
        this.clicklistener.onClick();
    }
}
