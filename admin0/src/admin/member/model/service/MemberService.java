package admin.member.model.service;

import static admin.member.common.JDBCTemplate.close;
import static admin.member.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import admin.member.model.dao.MemberDao;
import admin.member.model.vo.Member;

public class MemberService {

	private MemberDao mDao = new MemberDao();
	
	public ArrayList<Member> readMember() {
		Connection con = getConnection();
		
		ArrayList<Member> mlist = mDao.selectList(con);
		
		close(con);
		return mlist;
	}

}
