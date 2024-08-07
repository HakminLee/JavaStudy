package ch11.sec02.exam01;

public class ExceptionHandlingExample2 {
public static void printLength(String data) {
    try{
        int result = data.length();
        System.out.println("문자 수: "+result);
    } catch(NullPointerException e){ //해당 예외가 발생했을 경우 처리하는 부분
        System.out.println(e.getMessage());
//        System.out.println(e.toString());
//        e.printStackTrace(); // 예외가 어느 부분에서 발생했는지 알려줌
    } finally { // 예외가 발생하든 안하든 무조건 실행되는 부분
        System.out.println("[마무리 실행]\n");
    }
}

    public static void main(String[] args) {
        System.out.println("[프로그램 시작]\n");
        printLength("ThisIsJava");
        printLength(null);
        System.out.println("[프로그램 종료]");
    }
}
