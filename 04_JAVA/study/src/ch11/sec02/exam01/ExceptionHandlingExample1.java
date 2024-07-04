package ch11.sec02.exam01;

public class ExceptionHandlingExample1 {
//    받아온 data 값의 길이를 result에 할당
public static void printLength(String data){
    int result = data.length(); //data가 null일 경우 NullPointException 발생
    System.out.println("문자 수: "+result);
}

    public static void main(String[] args) {
        System.out.println("[프로그램 시작]/n");
        printLength("ThisISJava"); // 위쪽에 있는 printLength 메소드 호출
        printLength(null); //매개값으로 null 대입
        System.out.println("[프로그램 종료]"); // 위쪽에서 예외 발생으로 해당 부분 출력 안됨
    }
}
