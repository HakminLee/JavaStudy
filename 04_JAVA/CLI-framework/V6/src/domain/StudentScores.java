package domain;

public class StudentScores {
    int studentNum = 0;
    int[] scores = null;

    // alt + insert 키로 getter 만들어주기
    public int getStudentNum() {
        return studentNum;
    }
    // alt + insert 키로 getter 만들어주기
    public int[] getScores() {
        return scores;
    }

    public void setStudentNum(int studentNum){
        this.studentNum = studentNum;
        // 학생 수 만큼 점수 배열의 크기를 초기화
        this.scores = new int[studentNum];
    }

    //singleton 패턴
    //생성자는 private으로 막아두고  getInstance()를 통해서만 객체를 바ㅣㄴ환한다.
    //따라서 밖에서는 객체 생성을 할 수 없고, 동이ㅣㄹ한 객체만 사용 가능한다.
    private StudentScores() {}

    private static StudentScores instance = new StudentScores();
    public static StudentScores getInstance(){
        return instance;
    }
}
