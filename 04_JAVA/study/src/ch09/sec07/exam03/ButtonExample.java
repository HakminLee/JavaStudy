package ch09.sec07.exam03;

public class ButtonExample {
    public static void main(String[] args) {
        // OK 버튼 객체 생성
        Button btnOk = new Button();

        //기존에 CancelListener 클래스로 구현해줬던 코드를 바로 익명 객체ㅐ로 주입
        //Ok 버튼 클릭 이벤트를 처리할 ClickListener 구현 클래스(로컬 클래스 > main 메소드 안에 있기 때문에)
        btnOk.setClickListener(new Button.ClickListener() {
            @Override
            public void onClick() {
                System.out.println("Ok 버튼을 클릭했습니다.");
            }
        });

        //Ok  버튼 클릭하기
        btnOk.click();

        //Cancel 버튼 객체 생성
        Button btnCancel = new Button();

      btnCancel.setClickListener(new Button.ClickListener() {
          @Override
          public void onClick() {
              System.out.println("Cancel 버튼을 클릭했습니다.");
          }
      });

        //Cancel 버튼 클릭하기
        btnCancel.click();
    }
}
