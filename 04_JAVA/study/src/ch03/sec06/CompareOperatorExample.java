package ch03.sec06;public class CompareOperatorExample {

    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 10;
        boolean result1 = (num1==num2); //num1 과 nuum2가 같나
        boolean result2 = (num1!=num2); // num1 과 num2가 같거나 크니>
        boolean result3 = (num1 <=num2); // num2가 num2보다가 같거나 크니?

        System.out.println("result1: "+result1);
        System.out.println("result2: "+result2);
        System.out.println("result3: "+result3);



        int num3 = 1;
        double num4 = 1.0;
        boolean result5 =(num3 == num4); // double로 변경돼서 둘다 같다고 나옴
        System.out.println("result5: " +result5);

        float num5 = 0.1f;
        double num6 = 0.1;
        boolean result6 = (num5==num6);
        boolean result7 = (num5==(float) num6);
    }}



