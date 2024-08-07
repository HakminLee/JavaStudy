package org.scoula.ex05.frontcontroller;

import org.scoula.ex05.frontcontroller.command.Command;

import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import java.util.HashMap;
import java.util.Map;

@WebServlet
public class DispatcherServlet extends HttpServlet {
    Map<String, Command> getMap;
    Map<String, Command> postMap;

    String prefix="/WEB-INF/views/";
    String suffix=".jsp";

    public void init() {
        getMap = new HashMap<>();
        postMap = new HashMap<>();
        createMap(getMap, postMap);
}

protected void createMap(Map<String, Command>getMap, Map<String, Command>postMap){

}
}