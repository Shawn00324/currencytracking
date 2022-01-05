package idv.shawn.service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idv.shawn.dao.MemberMapper;
import idv.shawn.entity.Member;

@Service
public class MyUsersDetailService implements UserDetailsService{
	
	@Autowired
	private MemberMapper memberMapper;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		System.out.println("username = " + username);
		Member member = memberMapper.selectByNaturalKey(username);
		if(member == null) {
			throw new UsernameNotFoundException("此帳號不存在");
		}
		System.out.println("member.getMemberPassword() = " + member.getMemberPassword());
		
		List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList("role");
		
		return new User(member.getMemberAccount(), PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(member.getMemberPassword()), auths);
	}
}
