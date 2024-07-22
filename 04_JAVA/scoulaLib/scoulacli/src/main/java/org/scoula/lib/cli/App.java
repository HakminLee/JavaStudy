package org.scoula.lib.cli;

import org.scoula.lib.cli.command.Command;
import org.scoula.lib.cli.command.ExitCommand;
import org.scoula.lib.cli.ui.Menu;
import org.scoula.lib.cli.ui.MenuItem;

public abstract class App {
    // 여러 메소드에서 사용할 변수는 위로 정리해줌
    Menu menu;

    public App() {
    }

    public void init(){
        menu = new Menu();
        createMenu(menu);
        // 모든 앱에 동일하게 들어갈 수 있ㅎ는 종료 메뉴만 따로 빼둠
        menu.add(new MenuItem("종료",new ExitCommand()));
    }

    public void createMenu(Menu menu){
    }

    public void run(){
        //ArrayLisr로 변하면서 초기 사이즈를 정해줄 필요가 없어짐
        init();
        while (true){
            //try : 예외가 발생할 수 있는 코드
            try{
                menu.printMenu();
                // 사용자가 입력한 번호에 해당하는 command 리턴
                Command command = menu.getSelect();
                command.execute();
            }catch (Exception e){
                // try 문 내에서 해당 예외가 발생했을 경우 catch문으로 온다.
                e.printStackTrace();
                System.out.println("에러: "+e.getMessage());
            }
        }

            }
        }