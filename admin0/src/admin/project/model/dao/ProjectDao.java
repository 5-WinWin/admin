package admin.project.model.dao;

import static admin.member.common.JDBCTemplate.close;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import admin.project.model.vo.Project;

public class ProjectDao {

	private Properties prop;
	
	public ProjectDao() {
		prop = new Properties();
		
		String filePath = ProjectDao.class.getResource("/config/Project_query.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Project> selectList(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Project> plist = null;
		
		String sql = prop.getProperty("readProject");
		try {
			
			pstmt = con.prepareStatement(sql);
			rset=pstmt.executeQuery();
			
			plist = new ArrayList<Project>();
			
			while(rset.next()) {
				Project p = new Project();
				
				p.setpNo(rset.getInt("PNO"));
				p.setpEnro(rset.getDate("P_ENRO"));
				p.setpTitle(rset.getString("P_TITLE"));
				p.setpBang(rset.getString("P_BANG"));
				p.setpType(rset.getString("P_TYPE"));
				p.setpDetail(rset.getString("P_DETAIL"));
				p.setpCotx(rset.getString("P_COTX"));
				p.setpCost(rset.getInt("P_COST"));
				p.setpStart(rset.getDate("P_START"));
				p.setpEnd(rset.getDate("P_END"));
				p.setpGo(rset.getDate("P_GO"));
				p.setpModifyDate(rset.getDate("P_MODIFY_DATE"));
				p.setpModifyWriter(rset.getString("P_MODIFY_WRITER"));
				p.setcNo(rset.getInt("CNO"));
				
				plist.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return plist;
	}

}
