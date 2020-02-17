package admin.notice.model.dao;

import static admin.member.common.JDBCTemplate.close;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import admin.ads.model.vo.Ads;
import admin.member.model.vo.Member;
import admin.notice.model.vo.Notice;

public class NoticeDao {

	private Properties prop;
	
	public NoticeDao() {
		prop = new Properties();
		
		String filePath = NoticeDao.class.getResource("/config/Notice_query.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Notice> selectList(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Notice> nlist = null;
		
		String sql = prop.getProperty("readNotice");
		try {
			
			pstmt = con.prepareStatement(sql);
			rset=pstmt.executeQuery();
			
			nlist = new ArrayList<Notice>();
			
			while(rset.next()) {
				Notice n = new Notice();
				
				n.setnNo(rset.getInt("N_NO"));
				n.setnTitle(rset.getString("N_TITLE"));
				n.setnWriter(rset.getString("N_WRITER"));
				n.setnDate(rset.getDate("N_DATE"));
				n.setnCount(rset.getInt("N_COUNT"));
				n.setnContent(rset.getString("N_CONTENT"));
				n.setnModifyDate(rset.getDate("N_MODIFY_DATE"));
				n.setnModifyWriter(rset.getString("N_MODIFY_WRITER"));
			
				
	
				nlist.add(n);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return nlist;
	}
	
	public int insertNotice(Connection con, Notice n) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		
		try {
			String sql = prop.getProperty("insertNotice");
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, n.getnTitle());
			pstmt.setString(2, n.getnWriter());
			pstmt.setString(3, n.getnContent());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
			return result;
			
	}
	
	/*public Member selectOne(Connection con, int uNo) {
		Member m  = null;
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      
	      String sql = prop.getProperty("selectOne");
	      try {
	         pstmt = con.prepareStatement(sql);
	         
	         pstmt.setInt(1, uNo);
	         
	         
	         // INSERT, UPDATE, DELETE : executeUpdate();
	         // SELECT : executeQuery();
	         rset = pstmt.executeQuery();
	                  
	         // if, while
	         if(rset.next()) {
	        	 m = new Member();
	        	 
					m.setuNo(uNo);
					m.setfNo(rset.getInt("FNO"));
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
					
					

	         }
	         
	         
	      }catch(SQLException e) {
	         e.printStackTrace();
	      }finally {
	         close(rset);
	         close(pstmt);
	      }
	      return m;
	   }
	*//**
	 * 회원정보 수정
	 * @param con
	 * @param n
	 * @return
	 *//*
	public int updateMember(Connection con, Member m) {
	int result = 0;
	
	PreparedStatement pstmt = null;
	
	
	try {
		String sql = prop.getProperty("updateMember");
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, m.getuName());
		pstmt.setString(2, m.getuId());
		pstmt.setString(3, m.getuPwd());
		pstmt.setString(4, m.getuIntro());
		pstmt.setString(5, m.getuProfile());
		pstmt.setString(6, m.getuEmail());
		pstmt.setString(7, m.getuPhone());
		pstmt.setDate(8, m.getuModifyDate());
		pstmt.setString(9, m.getuModifyWriter());
		pstmt.setString(10, m.getuYn().toUpperCase());
		pstmt.setInt(11, m.getfNo());
		pstmt.setInt(12, m.getuNo());
		
		result = pstmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		close(pstmt);
	}
		return result;
		
}
*/
}
