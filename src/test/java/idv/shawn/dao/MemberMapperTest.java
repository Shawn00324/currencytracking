package idv.shawn.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import idv.shawn.CurrencytrackingApplication;
import idv.shawn.entity.Member;

@ExtendWith(SpringExtension.class)
@SpringBootTest( classes = { CurrencytrackingApplication.class } ) 
@Transactional
public class MemberMapperTest {

	@Autowired
	private MemberMapper mapper;
	
	@Test
	@Rollback
	public void testInsert() {
		Member member = new Member();
		member.setMemberAccount("shawn@gg.com");
		member.setMemberName("Shawn");
		member.setMemberPassword("123456");
		member.setMemberStatus("1");
		
		mapper.insert(member);
		Member result = mapper.selectByNaturalKey(member.getMemberAccount());
		
		assertEquals(result.getMemberAccount(), member.getMemberAccount());
	}
}
