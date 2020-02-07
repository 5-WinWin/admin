package admin.company.model.dao;

import static admin.member.common.JDBCTemplate.close;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import admin.company.model.vo.Company;

public class CompanyDao {

	private Properties prop;
	
	public CompanyDao() {
		prop = new Properties();
		
		String filePath = CompanyDao.class.getResource("/config/Company_query.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Company> selectList(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Company> clist = null;
		
		String sql = prop.getProperty("readCompany");
		try {
			
			pstmt = con.prepareStatement(sql);
			rset=pstmt.executeQuery();
			
			clist = new ArrayList<Company>();
			
			while(rset.next()) {
				Company c = new Company();
				
				c.setcNo(rset.getInt("CNO"));
				c.setcName(rset.getString("CNAME"));
				c.setcId(rset.getString("C_ID"));
				c.setcPwd(rset.getString("C_PWD"));
				c.setcEmail(rset.getString("C_EMAIL"));
				c.setcPhone(rset.getString("C_PHONE"));
				c.setcIntro(rset.getString("C_INTRO"));
				c.setcBus(rset.getString("C_BUS"));
				c.setcRegDate(rset.getDate("C_REG_DATE"));
				c.setcModifyDate(rset.getDate("C_MODIFY_DATE"));
				c.setcModifyWriter(rset.getString("C_MODIFY_WRITER"));
				
				clist.add(c);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return clist;
	}

}
