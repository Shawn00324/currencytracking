package idv.shawn.dao;

import idv.shawn.entity.Member;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
//import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

@Mapper
public interface MemberMapper{
    int deleteByPrimaryKey(Long memberId);

    int insert(Member record);

    Member selectByPrimaryKey(Long memberId);
    
    Member selectByNaturalKey(String memberAccount);
    
    List<Member> selectAll();

    int updateByPrimaryKey(Member record);
}