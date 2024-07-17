package command;

import domain.StudentScores;

public class PrintScoreCommand implements Command{
    StudentScores studentScores = StudentScores.getInstance();

    @Override
    public void execute() {
        // 기존에 저장되어 있는 학생들의 점수 리스트를 가져옴
        int[] scores = studentScores.getScores();

        // 점수 리스트를 돌면서 각각의 점수들을 출력해줌
        for(int i=0; i<scores.length; i++){
            System.out.println("scores["+i+"): "+scores[i]);
        }
    }
}
