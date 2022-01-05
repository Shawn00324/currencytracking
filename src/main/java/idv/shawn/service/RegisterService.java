package idv.shawn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import idv.shawn.dao.MemberMapper;
import idv.shawn.dto.RegisterDto;
import idv.shawn.entity.Member;

@Service
public class RegisterService {

	@Autowired
	private MemberMapper memberMapper;

	@Autowired
	private Member member;

	public int addMember(RegisterDto dto) {
		Member loadUserByUsername = memberMapper.selectByNaturalKey(dto.getMemberAccount());
		if (loadUserByUsername != null) {
			return 1;
		} else {
			
			member.setMemberAccount(dto.getMemberAccount());
			member.setMemberName(dto.getMemberName());
			member.setMemberPassword(dto.getMemberPassword());
			member.setMemberStatus("1");
			memberMapper.insert(member);
			
			return 2;
		}
	}
}
