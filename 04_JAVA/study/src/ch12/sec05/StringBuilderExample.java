package ch12.sec05;

public class StringBuilderExample {
    public static void main(String[] args) {
        String data = new StringBuilder()
                .append("DEF") // "DEF"
                .insert(0,"ABC") //0번째 인덱스에 "ABC" 추가, "ABCDEF"
                .delete(3,4) //인덱스 3번째 글자 삭제, "ABCEF"
                .toString(); //StringBuilder 객체를 String으로 변환
        System.out.println(data);
    }
}
