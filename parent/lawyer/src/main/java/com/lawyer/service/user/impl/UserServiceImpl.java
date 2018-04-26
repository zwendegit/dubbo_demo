package com.lawyer.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawyer.bean.user.DrMember;
import com.lawyer.dao.member.DrMemberDAO;
import com.lawyer.service.user.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private DrMemberDAO drMemberDao;
	@Override
	public DrMember test() {
		System.out.println("provider send 1");
		DrMember member=new DrMember();
		member.setUid(1);
		return drMemberDao.selectByPrimaryKey(member);
	}

}
