package org.scoula.todo.service;

import org.scoula.lib.cli.ui.Input;
import org.scoula.todo.dao.UserDao;
import org.scoula.todo.dao.UserDaolmpl;
import org.scoula.todo.domain.UserVO;
import org.scoula.todo.exception.PasswordMissmatchException;
import org.scoula.todo.exception.UserNameDuplicateException;

import javax.swing.text.html.Option;
import java.sql.SQLException;
import java.util.Optional;

public class AccountService {
    UserDao dao = new UserDaolmpl();


    public void join(){
        try{
            //유저의 정보를 받아와서 users 테이블에 추가해준다.
            UserVO user = getUser();
        }catch (UserNameDuplicateException | PasswordMissmatchException e) {
            System.out.println(e.getMessage());
        }catch (Exception e){
            // 지정한 예외 외에 다른 예외 발생 시 runtime 예외로 처리한다.
            throw new RuntimeException(e);
        }
    }

    private UserVO getUser() throws SQLException, UserNameDuplicateException, PasswordMissmatchException{
        String username = Input.getLine("사용자 ID: ");
        // 사용자한테 ID 입력 받은 후 중복 체크
        checkDuplication(username);

        String password = Input.getLine("비밀번호: ");
        String password2 = Input.getLine("비밀번호 확인: ");
        // 비밀번호와 비밀번호 확인 란이 같지 않으면 PasswordMissmatchException 발생시킴
        if(!password.equals(password2)){
            throw new PasswordMissmatchException();
        }

        String name=Input.getLine("이름: ");
        String role=Input.getLine("역할: ");

        // 사용자한테 받아온 데이터들로 UserVO 객체 생성
        return UserVO.builder()
                .id(username)
                .password(password)
                .name(name)
                .role(role)
                .build();
    }
    public boolean checkDuplication(String username) throws UserNameDuplicateException, SQLException{
        // 유저희 이름으로 해당하는 db저 정보 받아오기(SELECT)
        Optional<UserVO> result = dao.get(username);
        if(result.isPresent()){
            // 이미 해당 유저가 존재할 경우 예외 던지기
            // 해당 코드로 돌아오면 예외 발생 후 함수 종료
            throw new UserNameDuplicateException();
        }
        //중복이 안됐다는 뜻으로
        return  false;
    }

}
