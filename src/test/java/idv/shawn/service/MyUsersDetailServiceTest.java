package idv.shawn.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import idv.shawn.CurrencytrackingApplication;

@ExtendWith(SpringExtension.class)
@SpringBootTest( classes = { CurrencytrackingApplication.class } ) 
@Transactional
@Service
public class MyUsersDetailServiceTest {
	
	@Autowired
	private MyUsersDetailService myUsersDetailService;
	
	@Test
	public void testLoadUserByUsername() {
//		myUsersDetailService.loadUserByUsername("shawn@gg.com");
	}

}
