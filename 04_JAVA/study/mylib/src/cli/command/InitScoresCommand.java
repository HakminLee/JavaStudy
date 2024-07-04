package cli.command;

import cli.Input;
import domain.StudentScores;

public class InitScoresCommand implements Command{
    StudentScores studentScores = StudentScores.getInstance();

    @Override
    public void excute() {
        int studentNum = Input.getInt("학생수> ");
        studentScores.setStudentNum(studentNum);
    }
}
