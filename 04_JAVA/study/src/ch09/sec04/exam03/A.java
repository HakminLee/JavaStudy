package ch09.sec04.exam03;

public class A {
//메소드
    public void method1(int arg) {
        // final int arg
        // 로컬 변수
        int var = 1;   // final int var = 1;
        // 로컬 클래스가 추가되먄서 arg와 var은 상수 처리 된다.
        // 즉, 읽기는 가능하지만 쓰기가 불가능해진다.

        //로컬 클래스
        class B {
            void method2() {
                //로컬 변수 읽기
                System.out.println("arg: " + arg);  //(o)
                System.out.println("var: " + var); //(o)

                //로컬 변수 수정
                //arg = 2;  // (x)
                //var = 2;  // (x)
            }
        }

        //로컬 객체 생성
        B b = new B();
        //로컬 객체 메소드 호출
        b.method2();

        //로컬 변수 수정
        //arg = 3;   // (x)
        //var = 3;   // (x)
    }
}
