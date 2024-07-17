

import command.*;

import java.util.Scanner;

public class App {
    // 여러 메소드에서 사용할 변수는 위로 정리해줌
    Menu menu;
    Command[] commands;

    public App() {
        // 생성자에서 Menu로 객체 생성해서 초기화
        menu = new Menu();
        commands = new Command[]{
                new InitScoresCommand(), //1. 학생 수 입력
                new GetScoresCommand(),// 2. 점수 입력
                new PrintScoreCommand(), // 3. 점수 출력
                new AnalizeCommand(), // 4.분석
                new ExitCommand(), // 5. 종료
        };
    }


    public void executeCommand(int selectNo){
        // 인덱스로 접근해야 하기 때문에 사용자가 입력한 번호에서 -1 해줌
       Command command = commands[selectNo-1];
       // 가져온 커맨드의 excute가 실행된다.
        command.execute();
    }

    public void run(){
        while (true){
            menu.printMenu();
            //getSelect는 int를 반환하는 메소드기 때문에 바로 받아와서 처리
            int selectNo = menu.getSelect();
            executeCommand(selectNo);
            }
        }


    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

}