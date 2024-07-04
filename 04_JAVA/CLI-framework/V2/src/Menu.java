public class Menu {
    String menus[] = {"학생수", "점수입력", "점수리스트", "분석", "종료"};

    public void printMenu(){
        System.out.println("--------------------------------------------");
        for (int i =0; i < menus.length; i++){
            // index는 0부터 시작이기 떄문에 앞쪽 번호는 1을 더해줬다.
            System.out.printf("%d.%s |", i+1, menus[i]);
        }
        System.out.println();
        System.out.println("--------------------------------------------");
    }

    public int getSelect(){
        // 사용자가 입력한 숫자를 받아서 selectNo에 저장
        int selectNo = Input.getInt("선택> ");
        // 클래스로 접근한 함수이면 static 이다. 그 함수는 하나뿐이니 어디서 사용하든 똑같다.

        return selectNo;
    }
}
