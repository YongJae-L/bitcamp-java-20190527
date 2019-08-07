package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.Member;

// 회원 관리 DAO의 사용 규칙을 정의한다.
public interface MemberDao {
  public int insert(Member member) throws Exception;
  public List<Member> findAll() throws Exception;
  public Member findBy(int no) throws Exception;
  public int update(Member member) throws Exception;
  public int delete(int no) throws Exception;
}








