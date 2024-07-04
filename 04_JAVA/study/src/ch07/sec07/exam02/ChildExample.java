package ch07.sec07.exam02;

public class ChildExample {
    public static void main(String[] args) {
        //자식 객체 생성
        Child child = new Child();

        //자동 타입 변환
        Parent parent = child;

        //메소드 호출
        parent.methods1();
        parent.methods2();
        // 부모 타입은 자식타입으로 지동 변환되지 않기 때문에 컴파일 에러 발생
        //parent.method3(); 호출 불가능
    }
}
