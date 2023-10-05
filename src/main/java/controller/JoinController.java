package controller;

import lombok.extern.log4j.Log4j2;
import service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@WebServlet("/join")
public class JoinController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("join GET...");
        req.getRequestDispatcher("/WEB-INF/member/join.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("join POST...");

        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        String memberId = req.getParameter("memberId");
        String passwd = req.getParameter("passwd");
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");

        try {
            MemberService.INSTANCE.addMember(memberId, passwd, name, phone);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        resp.sendRedirect("/login");
    }
}
