package ch05.sec04;

public class NullPointExceptionExample {
    public static void main(String[] args) {
        int[] intArray = null;
//        null인 배열의 0번째 값을 할당했기 때문에 NullPointException 발생
        //intArray[0] = 10; //NullPointException

        String str = null;
//        System.out.println("총 문자 수:  " + str.length()); //NullpointException
    }
}
