package ui;

import basic.Input;
import command.Command;

public class Menu {
//    메뉴들을 MenuItem의 객체로 만들어서 관리해줌
   MenuItem[] menus;

   // 메뉴의 개수를 받아와서ㅏ 메뉴 리스트를 초기화해줌
   public Menu(int size) {
       menus = new MenuItem[size];
   }

   // 메뉴 항목 주입
    public void add(int ix, MenuItem item){
       menus[ix]=item;
    }

    public void printMenu(){
        System.out.println("--------------------------------------------");
        for (int i =0; i < menus.length; i++){
            // menus[i]는 MenuItem의 객체이므로 title만 가져와서 출력
            // index는 0부터 시작이기 떄문에 앞쪽 번호는 1을 더해줬다.
            System.out.printf("%d.%s |", i+1, menus[i].getTitle());
        }
        System.out.println();
        System.out.println("--------------------------------------------");
    }

    public Command getSelect(){
        // 사용자가 입력한 숫자를 받아서 selectNo에 저장
        int selectNo = Input.getInt("선택> ");
        // 클래스로 접근한 함수이면 static 이다. 그 함수는 하나뿐이니 어디서 사용하든 똑같다.
        // menus에서 MenuItem 객체 하나를 접근해서 COmmand만 가져온다.
        return menus[selectNo-1].getCommand();
    }
}
