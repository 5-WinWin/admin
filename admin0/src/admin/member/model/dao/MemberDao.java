package admin.member.model.dao;

import static admin.member.common.JDBCTemplate.*;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import admin.member.model.vo.Member;

public class MemberDao {

	private Properties prop;
	
	public MemberDao() {
		prop = new Properties();
		
		String filePath = MemberDao.class.getResource("/config/Member_query.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Member> selectList(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> mlist = null;
		
		String sql = prop.getProperty("readMember");
		try {
			
			pstmt = con.prepareStatement(sql);
			rset=pstmt.executeQuery();
			
			mlist = new ArrayList<Member>();
			
			while(rset.next()) {
				Member m = new Member();
				
				m.setuNo(rset.getInt("UNO"));
				m.setuName(rset.getString("UNAME"));
				m.setuId(rset.getString("U_ID"));
				m.setuPwd(rset.getString("U_PWD"));
				m.setuIntro(rset.getString("U_INTRO"));
				m.setuProfile(rset.getString("U_PROFILE"));
				m.setuEmail(rset.getString("U_EMAIL"));
				m.setuPhone(rset.getString("U_PHONE"));
				m.setuRegDate(rset.getDate("U_REG_DATE"));
				m.setuModifyDate(rset.getDate("U_MODIFY_DATE"));
				m.setuModifyWriter(rset.getString("U_MODIFY_WRITER"));
				m.setuYn(rset.getString("U_YN"));
				
				mlist.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return mlist;
	}

}
