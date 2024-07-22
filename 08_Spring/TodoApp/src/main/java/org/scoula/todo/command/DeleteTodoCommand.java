package org.scoula.todo.command;

import org.scoula.lib.cli.command.Command;
import org.scoula.lib.cli.ui.Input;
import org.scoula.todo.dao.TodoDao;
import org.scoula.todo.dao.TodoListDao;

public class DeleteTodoCommand implements Command {
    TodoDao dao = TodoListDao.getInstance();

    @Override
    public void execute() {
        // 사용자에게 삭제할 todo의 아이디 입력받기
        int id = Input.getInt("삭제할 Todo Id : ");
        // 해당하는 id의 todo를 목록에서 삭제
        dao.delete(id);

        System.out.println();
    }
}
