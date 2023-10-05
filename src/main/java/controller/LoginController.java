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
@WebServlet("/login")
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("login GET...");
        req.getRequestDispatcher("WEB-INF/member/login.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("login POST...");

        String memberId = req.getParameter("memberId");
        String passwd = req.getParameter("passwd");
        String auto = req.getParameter("auto");
        boolean rememberMe = auto != null && auto.equals("on"); // auto에 체크하면 true;

        MemberDTO memberDTO = new MemberDTO();

        try {
            memberDTO = MemberService.INSTANCE.loginMember(memberId, passwd);

            if(memberDTO != null){
                if(rememberMe){
                    // 로그인 성공을 해야 임의의 문자열 생성
                    String uuid = UUID.randomUUID().toString(); // 임의의 문자열 생성

                    MemberService.INSTANCE.modifyUuid(memberId, uuid);
                    memberDTO.setUuid(uuid);

                    Cookie rememberCookie = new Cookie("remember-me", uuid);
                    rememberCookie.setMaxAge(7 * 24 * 60 * 60); // 쿠키 유효기한은 1주일
                    rememberCookie.setPath("/");

                    resp.addCookie(rememberCookie);
                }

                if(memberDTO.getMemberId() != null){
                    HttpSession session = req.getSession();
                    session.setAttribute("loginInfo", memberDTO);
                    session.setAttribute("sessionMemberId", memberDTO.getMemberId());
                    session.setAttribute("sessionMemberName", memberDTO.getName());

                    //resp.sendRedirect("/tipList.tip");원레경로 는 이게 맞음 난중에 써야함
                    resp.sendRedirect("/mypage");//로그인 하고 마이페이지로 실험용 임 난중에 지워도 무상관
                }

            }
            log.info(memberDTO);
            if(memberDTO.getMemberId() == null) {
                log.info("로그인 이후 memberDTO 가 널 값일때");
                resp.sendRedirect("/login?result=error");//이친구 고치기
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
