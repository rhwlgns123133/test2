<%@ page import="java.sql.Connection" %>
<%@ page import="model.dao.ConnectionUtil" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="javax.xml.transform.Result" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
      <%
        request.setCharacterEncoding("utf-8");
        String memberId = request.getParameter("memberId");
        Connection connection = ConnectionUtil.INSTANCE.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM member WHERE memberid =?";

        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, memberId);
        resultSet = preparedStatement.executeQuery();

        if(resultSet.next()){
            out.print("{\"result\":\"true\"}");
        }else {
            out.print("{\"result\":\"false\"}");
        }

        if(resultSet != null){
          resultSet.close();
        }
        if(preparedStatement != null){
            preparedStatement.close();
        }
        if(connection != null){
            connection.close();
        }
      %>
