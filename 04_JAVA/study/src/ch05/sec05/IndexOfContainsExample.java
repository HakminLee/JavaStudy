package ch05.sec05;

public class IndexOfContainsExample {
    public static void main(String[] args) {
        String subject = "자바 프로그래밍";
        
        int location = subject.indexOf("프로그래밍");
        System.out.println(location);
        String substring = subject.substring(location);
        System.out.println(substring);
        
        location = subject.indexOf("자바");
        // "자바"라는 글자가 subjectㅇ[ㅔ 없으면 location에 -1을 반환
        // location 이 -1과 같지 않다는 것은 "자바"라는 글자가 어딘가에 포함되어 있다는 뜻
        if (location != -1){
            System.out.println("자바와 관련된 책이군요.");
        }else {
            System.out.println("자바와 관련 없는 책이군요.");
        }

//        String.contains(word) : 해당 단어가 문자열에 포함되어 있는지 여부를boolean 값으로 반환
        boolean result = subject.contains("자바");
        if(result){
            System.out.println("자바와 관련된 책이군요");
        }else {
            System.out.println("자바와 관련 없는 책이군요");
        }
    }
}