public abstract class App {

    public void run(){
        init();

        while(true){
            try{
                menu.printMenu();
                Command command = menu.getSelect();
            } catch (Exception e) {
                e.printStackTrace();
//                System.out.println("에러: "+e.getMessage());
            }
        }
    }
}
