package model.dao;

import lombok.Cleanup;
import model.domain.MemberVo;
import model.dto.MemberDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
    public void insertMember (MemberDTO memberDTO) throws Exception {
        String sql = "INSERT INTO member (memberId, passwd, name, phone) VALUES (?, ?, ?, ?)";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, memberDTO.getMemberId());
        preparedStatement.setString(2, memberDTO.getPasswd());
        preparedStatement.setString(3, memberDTO.getName());
        preparedStatement.setString(4, memberDTO.getPhone());

        preparedStatement.executeUpdate();
    }

    public MemberDTO getLoginMember(String memberId, String passwd) throws Exception {
        MemberDTO memberDTO = new MemberDTO();

        String sql = "SELECT * FROM member WHERE memberId = ? AND passwd = ?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, memberId);
        preparedStatement.setString(2, passwd);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        if(resultSet.next()){
            memberDTO.setMemberId(resultSet.getString("memberId"));
            memberDTO.setPasswd(resultSet.getString("passwd"));
            memberDTO.setName(resultSet.getString("name"));
            memberDTO.setPhone(resultSet.getString("phone"));
        }
        return memberDTO;
    }
    //내정보 수정 updateMember 만 하나 해놓음 마이페이지 하나 임의로 만들고 해야 작업 수월할거 같음 이까지함
    public void updateMember(MemberDTO memberDTO) throws Exception{

        String sql = "UPDATE member SET passwd = ?, name = ?, phone = ? where memberId =? and passwd=?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, memberDTO.getPasswd());
        preparedStatement.setString(2, memberDTO.getName());
        preparedStatement.setString(3, memberDTO.getPhone());
        preparedStatement.setString(4, memberDTO.getMemberId());
        preparedStatement.setString(5, memberDTO.getPasswd());

        preparedStatement.executeUpdate();
    }

    public void updateUuid(String memberId, String uuid) throws Exception {
        String sql = "UPDATE  `member` SET `uuid` = ? WHERE `memberId`= ?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, uuid);
        preparedStatement.setString(2, memberId);

        preparedStatement.executeUpdate();
    }

    public MemberVo selectUuid(String uuid) throws Exception {
        String sql = "SELECT `memberId`, `passwd`, `name`, `uuid` FROM `member` WHERE `uuid` = ?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, uuid);

        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
        MemberVo memberVO = null;
        if(resultSet.next()){
            memberVO = MemberVo.builder()
                    .memberId(resultSet.getString("memberId"))
                    .passwd(resultSet.getString("passwd"))
                    .name(resultSet.getString("name"))
                    .uuid(resultSet.getString("uuid"))
                    .build();
        }
        return memberVO;
    }
}
