package cli.command;

import domain.StudentScores;

public class PrintScoreCommand implements Command {
StudentScores studentScores = StudentScores.getInstance();

    @Override
    public void excute() {
        int [] scores = studentScores.getScores();

        for(int i=0; i<scores.length; i++){
            System.out.println("scores["+i+"]: "+scores[i]);
        }
    }
}
