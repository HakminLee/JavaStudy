package command;

import basic.Input;
import domain.StudentScores;
// 2번 메뉴인 점ㅁ수 입력 기능 처리하는 클래서ㅡ

public class GetScoresCommand implements Command{
    StudentScores studentScores = StudentScores.getInstance();

    @Override
    public void execute() {
        // 기존에 저장 되어 있는 학생들의 점수 리스트를 가져옴
        int [] scores = studentScores.getScores();
        // 점수 리스트를 돌면서 사용자한테 입력받은 점수를 넣어줌
        for(int i=0;i<scores.length;i++){
            scores[i] = Input.getInt("scores["+i+"]> ");
        }
    }
}
