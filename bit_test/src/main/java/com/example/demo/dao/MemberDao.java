package com.example.demo.dao;


import org.springframework.stereotype.Repository;


import com.example.demo.db.MemberManager;

import com.example.demo.vo.MemberVo;

@Repository
public class MemberDao {
	
	public int insert(MemberVo m) {
		System.out.println("추가하였습니다");
		return MemberManager.insert(m);
		
	}
	
	
}
