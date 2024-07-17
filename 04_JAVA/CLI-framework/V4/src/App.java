

import command.*;
import ui.Menu;
import ui.MenuItem;

public class App {
    // 여러 메소드에서 사용할 변수는 위로 정리해줌
    Menu menu;
    Command[] commands;

    public App() {
        // 생성자에서 Menu로 객체 생성해서 초기화
//        menu = new Menu();
//        commands = new Command[]{
//                new InitScoresCommand(), //1. 학생 수 입력
//                new GetScoresCommand(),// 2. 점수 입력
//                new PrintScoreCommand(), // 3. 점수 출력
//                new AnalizeCommand(), // 4.분석
//                new ExitCommand(), // 5. 종료
//        };
    }

    public void init(int menuSize){
        menu = new Menu(menuSize);
        createMenu(menu);
    }

    public void createMenu(Menu menu){
        // MenuItem 배열의 해당 인덱스에 메뉴 이름과 Command를 묶어서 추가해준다.
        menu.add(0, new MenuItem("학생수",new InitScoresCommand()));
        menu.add(1, new MenuItem("점수 입력",new GetScoresCommand()));
        menu.add(2, new MenuItem("점수리스트",new PrintScoreCommand()));
        menu.add(3, new MenuItem("분석",new AnalizeCommand()));
        menu.add(4, new MenuItem("종료",new ExitCommand()));
    }

    public void run(){
        init(5);
        while (true){
            menu.printMenu();
            // 사용자가 입력한 번호에 해당하는 command 리턴
            Command command = menu.getSelect();
           command.execute();
            }
        }


    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

}