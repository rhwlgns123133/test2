import lombok.extern.log4j.Log4j2;
import model.dao.MemberDAO;
import model.dto.MemberDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Log4j2
public class UserDAOTests {

    private MemberDAO userDAO;

    @BeforeEach
    public void reaby(){
        userDAO = new MemberDAO();
    }

    @Test
    public void testinsertMember() throws Exception {
        MemberDTO userDTO = new MemberDTO();

        userDTO.getMemberId();
        userDTO.setPasswd("456789");
        userDTO.getName();
        userDTO.setPhone("010-1111-1111");

        userDAO.insertMember(userDTO);

        log.info("조인 테스트");
    }

    @Test
    public void testgetLoginMember() throws Exception{
        MemberDTO userDTO = new MemberDTO();
        String email = "test@naver.com";
        String passwd = "123456";

        userDTO = userDAO.getLoginMember(email, passwd);
        log.info(userDTO);
    }
}
