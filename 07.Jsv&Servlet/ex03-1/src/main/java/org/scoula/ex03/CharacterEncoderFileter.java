package org.scoula.ex03;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.rmi.ServerException;

//WebFilter : 어노테이션 적용해야 필터로 인식함
@WebFilter(urlPatterns={"/*"})
public class CharacterEncoderFileter implements Filter {

    // 필터 초기화 메소드, 필터가 생성될 때 호출된다.
    @Override
    public void init(FilterConfig fConfig) throws ServerException{
        Filter.super.init(filterConfig);
    }

    //필터 소멸 메소드, 필터가 소멸될 때 호출된다. 자원 해제 작업 수행
    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    // 실제 로직을 구현하는 메소드, request와 response를 받아올 때 필터가 수행할 작업
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletExceptiom{
        request.setCharacterEncoding("UTF-8"); //request의 문자 인코딩 UTF-8로 변경
        filterChain.doFilter(servletRequest, servletResponse);

        chain.doFilter(request, response);
    }

}
