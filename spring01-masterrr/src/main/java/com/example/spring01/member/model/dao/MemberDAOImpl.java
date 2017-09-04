package com.example.spring01.member.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.spring01.member.model.dto.MemberVO;

// �쁽�옱 �겢�옒�뒪瑜� DAO bean�쑝濡� �벑濡앹떆�궡
@Repository
public class MemberDAOImpl implements MemberDAO {
	
	// SqlSession 媛앹껜瑜� �뒪�봽留곸뿉�꽌 �깮�꽦�븯�뿬 二쇱엯�떆耳쒖��떎.
	// �쓽議닿�怨� 二쇱엯(Dependency Injection, DI)
	// �뒓�뒪�븳 寃고븿
	// IoC(Inversion of Control, �젣�뼱�쓽 �뿭�쟾)
	@Inject
	// Inject�븷�끂�뀒�씠�뀡�씠 �뾾�쑝硫� sqlSession�� null�긽�깭�씠吏�留�
	// Inject�븷�끂�뀒�씠�뀡�씠 �엳�쑝硫� �쇅遺��뿉�꽌 媛앹껜瑜� 二쇱엯�떆耳쒖＜寃� �맂�떎. 
	// try catch臾�, finally臾�, 媛앹껜瑜� close�븷 �븘�슂媛� �뾾�뼱議뚮떎.
	SqlSession sqlSession;
	
	// 01. �쟾泥� �쉶�썝 紐⑸줉 議고쉶
	@Override
	public List<MemberVO> memberList() {
		
		System.out.println(sqlSession);
		return sqlSession.selectList("member.memberList");
	}
	// 02. �쉶�썝 �벑濡�
	@Override
	public void insertMember(MemberVO vo) {
		sqlSession.insert("member.insertMember", vo);
	}
	// 03. �쉶�썝 �젙蹂� �긽�꽭 議고쉶
	@Override
	public MemberVO viewMember(String userId) {
		return sqlSession.selectOne("member.viewMember", userId);
	}
	// 04. �쉶�썝 �젙蹂� �닔�젙 泥섎━
	@Override
	public void deleteMember(String userId) {
		sqlSession.delete("member.deleteMember",userId);
	}
	// 05. �쉶�썝 �젙蹂� �궘�젣 泥섎━
	@Override
	public void updateMember(MemberVO vo) {
		sqlSession.update("member.updateMember", vo);

	}
	// 06. �쉶�썝 �젙蹂� �닔�젙 諛� �궘�젣瑜� �쐞�븳 鍮꾨�踰덊샇 泥댄겕
	@Override
	public boolean checkPw(String userId, String userPw) {
		boolean result = false;
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("userPw", userPw);
		int count = sqlSession.selectOne("member.checkPw", map);
		if(count == 1) result= true;
		return result;
	}

}
