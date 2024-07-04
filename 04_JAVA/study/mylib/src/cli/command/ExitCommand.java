package cli.command;

public class ExitCommand implements Command {
    @Override
    public void excute() {
        System.out.println("프로그램 종료");
        System.exit(0);

    }
}
