package ch11.sec03.exam03;

public class ExceptionHandlingExample {
    public static void main(String[] args) {
        String[] array = {"100","1oo",null,"200"};

        for(int i = 0; i <=array.length; i++){
            try{
                //인덱스 0번과 3번의 경우 숫자이므로 올바르게 처리됨
//                배열의 요소를 차례대로 꺼내서 int로 변경해준다.
                int value = Integer.parseInt(array[i]);
                System.out.println("array[" + i + "]: " +value);
            }catch(ArrayIndexOutOfBoundsException e){
//                i = 4가 들아올 경우 인덱스 초과로 해당 예외 발생
                System.out.println("배열 인덱스가 초가됨: " +e.getMessage());
            }catch(NullPointerException | NumberFormatException e){
                //2가지 예외를 동일하게 처리
                // i = 1일 경우 숫자가 아니므로 NumberformatException 예외 발생
//                i = 2일 경우 null이므로 NullPointerException 예외 발생
                System.out.println("데이터에 문제가 있음: "+e.getMessage());
            }
        }
    }
}
