package com.example.spring01.member.controller;

import java.util.Date;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.spring01.member.model.dto.MemberVO;
import com.example.spring01.member.service.MemberService;

@Controller // �쁽�옱�쓽 �겢�옒�뒪瑜� controller bean�뿉 �벑濡앹떆�궡
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	// MemberService 媛앹껜瑜� �뒪�봽留곸뿉�꽌 �깮�꽦�븯�뿬 二쇱엯�떆�궡
	@Inject
	MemberService memberService;
	
	// 01 �쉶�썝 紐⑸줉
	// url pattern mapping
	@RequestMapping("member/list.do")
	public String memberList(Model model){
	// controller => service => dao �슂泥�
		List<MemberVO> list = memberService.memberList();
		System.out.println(list);
		model.addAttribute("list", list);
		return "member/member_list";
	}
	
//	// 02_01 �쉶�썝 �벑濡� �럹�씠吏�濡� �씠�룞
//	@RequestMapping("member/write.do")
//	public String memberWrite(){
//		
//		return "member/member_write";
//	}
//	
//	// 02_02 �쉶�썝 �벑濡� 泥섎━ �썑 ==> �쉶�썝紐⑸줉�쑝濡� 由щ떎�씠�젆�듃
//	// @ModelAttribute�뿉 �뤌�뿉�꽌 �엯�젰�븳 �뜲�씠�꽣媛� ���옣�맂�떎.
//	@RequestMapping("member/insert.do")
//	// * �뤌�뿉�꽌 �엯�젰�븳 �뜲�씠�꽣瑜� 諛쏆븘�삤�뒗 踰� 3媛�吏� 
//	//public String memberInsert(HttpServlet request){
//	//public String memberInsert(String userId, String userPw, String userName, String userEmail){
//	public String memberInsert(@ModelAttribute MemberVO vo){
//		
//		Date date = new Date(); 
//		java.sql.Date today = new java.sql.Date(date.getTime());		
//		
//		vo.setUserRegdate(today);
//		// �뀒�씠釉붿뿉 �젅肄붾뱶 �엯�젰
//		memberService.insertMember(vo);
//		// * (/)�쓽 �쑀臾댁뿉 李⑥씠
//		// /member/list.do : 猷⑦듃 �뵒�젆�넗由щ�� 湲곗�
//		// member/list.do : �쁽�옱 �뵒�젆�넗由щ�� 湲곗�
//		// member_list.jsp濡� 由щ떎�씠�젆�듃
//		return "redirect:/member/list.do";
//	}
//	
//	// 03 �쉶�썝 �긽�꽭�젙蹂� 議고쉶
//	@RequestMapping("member/view.do")
//	public String memberView(@RequestParam String userId, Model model){
//		// �쉶�썝 �젙蹂대�� model�뿉 ���옣
//		model.addAttribute("dto", memberService.viewMember(userId));
//		//System.out.println("�겢由��븳 �븘�씠�뵒 �솗�씤 : "+userId);
//		logger.info("�겢由��븳 �븘�씠�뵒 : "+userId);
//		// member_view.jsp濡� �룷�썙�뱶
//		return "member/member_view";
//	}
//	// 04. �쉶�썝 �젙蹂� �닔�젙 泥섎━
//	@RequestMapping("member/update.do")
//	public String memberUpdate(@ModelAttribute MemberVO vo, Model model){
//		// 鍮꾨�踰덊샇 泥댄겕
//		boolean result = memberService.checkPw(vo.getUserId(), vo.getUserPw());
//		if(result){ // 鍮꾨�踰덊샇媛� �씪移섑븯硫� �닔�젙 泥섎━�썑, �쟾泥� �쉶�썝 紐⑸줉�쑝濡� 由щ떎�씠�젆�듃
//			memberService.updateMember(vo);
//			return "redirect:/member/list.do";
//		} else { // 鍮꾨�踰덊샇媛� �씪移섑븯吏� �븡�뒗�떎硫�, div�뿉 遺덉씪移� 臾멸뎄 異쒕젰, viwe.jsp濡� �룷�썙�뱶
//			// 媛��엯�씪�옄, �닔�젙�씪�옄 ���옣
//			MemberVO vo2 = memberService.viewMember(vo.getUserId());
//			vo.setUserRegdate(vo2.getUserRegdate());
//			vo.setUserUpdatedate(vo2.getUserUpdatedate());
//			model.addAttribute("dto", vo);
//			model.addAttribute("message", "鍮꾨�踰덊샇 遺덉씪移�");
//			return "member/member_view";
//		}
//		
//	}
//	// 05. �쉶�썝�젙蹂� �궘�젣 泥섎━
//	// @RequestMapping : url mapping
//	// @RequestParam : get or post諛⑹떇�쑝濡� �쟾�떖�맂 蹂��닔媛�
//	@RequestMapping("member/delete.do")
//	public String memberDelete(@RequestParam String userId, @RequestParam String userPw, Model model){
//		// 鍮꾨�踰덊샇 泥댄겕
//		boolean result = memberService.checkPw(userId, userPw);
//		if(result){ // 鍮꾨�踰덊샇媛� 留욌떎硫� �궘�젣 泥섎━�썑, �쟾泥� �쉶�썝 紐⑸줉�쑝濡� 由щ떎�씠�젆�듃
//			memberService.deleteMember(userId);
//			return "redirect:/member/list.do";
//		} else { // 鍮꾨�踰덊샇媛� �씪移섑븯吏� �븡�뒗�떎硫�, div�뿉 遺덉씪移� 臾멸뎄 異쒕젰, viwe.jsp濡� �룷�썙�뱶
//			model.addAttribute("message", "鍮꾨�踰덊샇 遺덉씪移�");
//			model.addAttribute("dto", memberService.viewMember(userId));
//			return "member/member_view";
//		}
//	}
}
