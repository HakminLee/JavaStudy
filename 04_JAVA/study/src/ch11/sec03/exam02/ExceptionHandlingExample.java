package ch11.sec03.exam02;

public class ExceptionHandlingExample {
    public static void main(String[] args) {
        String[] array = {"100","1oo"};

        for(int i = 0; i <=array.length; i++){
            try{
//                배열의 요소를 차례대로 꺼내서 int로 변경해준다.
                int value = Integer.parseInt(array[i]);
                System.out.println("array[" + i + "]: " +value);
            }catch(ArrayIndexOutOfBoundsException e){
                // i가 2인 경우, 배열의 요소는 0,1까지 밖에 없으므로 해당 예외 발생
                System.out.println("배열 인덱스가 초가됨: " +e.getMessage());
            }catch(Exception e){
//                // Exception은 모든 예외의 부모 클래스로 위에서 해당하지 않은 예외들이 들어올 경우 처리해줌
                /// if문에서 else와 같은 역할
                System.out.println("실행에 문제가 있습니다.");
            }
        }
    }
}