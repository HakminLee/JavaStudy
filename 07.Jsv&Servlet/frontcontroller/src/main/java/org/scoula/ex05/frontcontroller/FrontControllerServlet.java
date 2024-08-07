package org.scoula.ex05.frontcontroller;

import org.scoula.ex05.frontcontroller.command.Command;
import org.scoula.ex05.frontcontroller.controller.HomeController;
import org.scoula.ex05.frontcontroller.controller.TodoController;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name="FrontControllerServlet", value = "/")
// 경로 지정하는 방법은 두가지가 있다. 1)디렉토리 기반 / 2) 확장명 기반
// 디렉토리 기반(/board), 확장명 기반(/*.do)
public class FrontControllerServlet extends HttpServlet {
    Map<String, Command> getMap; // GET 요청이 들어왔을 경우 사용할 맵
    Map<String, Command> postMap; //POST 요청이 들어왔을 경우 사용할 맵

    TodoController todoController = new TodoController();

    String prefix="/WEB-INF/views/";
    String suffix=".jsp";

    HomeController homeController = new HomeController();

    //서블릿 초기화 메소드
    public void init() {
        // Map은 인터페이스 이므로 구현 클래스인 HashMap으로 객체 생성
        getMap = new HashMap<>();
        postMap = new HashMap<>();

        getMap.put("/",homeController::getIndex);

        getMap.put("/todo/list",todoController::getList);
        getMap.put("/todo/view",todoController::getView);
        getMap.put("/todo/create",todoController::getCreate);
        getMap.put("/todo/update",todoController::getUpdate);

        postMap.put("/todo/create", todoController::postCreate);
        postMap.put("/todo/update", todoController::postUpdate);
        postMap.put("/todo/delete", todoController::postDelete);
    }

    private String getCommandName(HttpServletRequest request) {
        String requestURI = request.getRequestURI(); // "/context값/식별값"
        String contextPath = request.getContextPath(); //"context값"
        //subString(시작인덱스) : 해당 인덱스로부터 문자열을 잘라준다.
        return requestURI.substring(contextPath.length()); // "/식별값"
    }

    private Command getCommand(HttpServletRequest request) {
        // request에서 command 이름만 추출
        String commandName = getCommandName(request);

        Command command;
        //equalsIgnoreCase("GET") : "get"이라는 단어와 대소문자 구분 없이 비교
//        request에서 받아온 메소드가 GET이면 getMap에서 커멘드 찾기
        if (request.getMethod().equalsIgnoreCase("GET")) {
            command = getMap.get(commandName);
        } else {
//            request에서 받아온 메소드가 POST이면 postMap에서 커멘드 찾기
            command = postMap.get(commandName);
        }
        return command;
    }
    public  void execute(Command command, HttpServletRequest request, HttpServletResponse response)
        //커멘드의 실행결과는 jsp의 이름으로 받아온다.
            throws IOException, ServletException {

        String viewName = command.execute(request, response);
        if (viewName.startsWith("redirect:")) {//redirecr 처리
            // redirect로 처리할 경우 view의 경로에서 "redirect:"를 제외하고 띄운다.
            response.sendRedirect(viewName.substring("redirect:".length()));
        } else { // forward 처리
            // forward로 처리할 경우
            // 가지고 온 뷰의 이름에 "/views/"를 앞에, "/jsp"를 뒤에 붙여준다.
            String view = prefix + viewName + suffix;
            RequestDispatcher dis = request.getRequestDispatcher(view);
            dis.forward(request, response);
        }
    }
        @Override
        public void doGet(HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {
            Command command = getCommand(request);
            if (command != null) {
                execute(command, request, response);
            } else {// 업는 페이지일 경우 404 에러 처리
                String view = prefix+"404"+suffix;
                RequestDispatcher dis = request.getRequestDispatcher(view);
                dis.forward(request, response);
            }
        }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response); // doGet() 호출로 POST 요청 처리
    }
    }
