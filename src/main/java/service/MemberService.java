package service;

import model.dao.MemberDAO;
import model.dto.MemberDTO;
import model.domain.MemberVo;
import org.modelmapper.ModelMapper;
import modelMapper.*;
//import util.MapperUtil;

public enum MemberService {
    INSTANCE;

    private MemberDAO memberDAO;

    private ModelMapper modelMapper;

    MemberService() {
        memberDAO = new MemberDAO();
        modelMapper = MapperUtil.INSTANCE.getInstance();
    }

    public void addMember(String memberId, String passwd, String name, String phone) throws Exception {
        MemberDTO memberDTO = MemberDTO.builder()
                .memberId(memberId)
                .passwd(passwd)
                .name(name)
                .phone(phone)
                .build();
        memberDAO.insertMember(memberDTO);
    }

    public MemberDTO loginMember (String memberId, String passwd) throws Exception {
        MemberDTO memberDTO = memberDAO.getLoginMember(memberId, passwd);

        return memberDTO;
    }

    public void modifyUuid(String mid, String uuid) throws Exception {
        memberDAO.updateUuid(mid, uuid);
    }

    public MemberDTO getByUuid(String uuid) throws Exception {
        MemberVo memberVO = memberDAO.selectUuid(uuid);

        MemberDTO memberDTO = modelMapper.map(memberVO, MemberDTO.class);

        return memberDTO;
    }
}
