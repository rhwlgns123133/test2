package controller;

import lombok.extern.log4j.Log4j2;
import model.dto.MemberDTO;
import service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.UUID;

@Log4j2
@WebServlet("/mypage")
public class MypageController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Mypage GET...");
        req.getRequestDispatcher("WEB-INF/member/mypage.jsp").forward(req, resp);
    }
}
