package cli.command;

import cli.Input;
import domain.StudentScores;

public class GetScoresCommand implements Command {
StudentScores studentScores = StudentScores.getInstance();

    @Override
    public void excute() {
        int [] scores = studentScores.getScores();

        for (int i = 0; i < scores.length; i++){
            scores[i] = Input.getInt("scores["+i+"]");
        }
    }
}
