package admin.portfolio.model.dao;

import static admin.member.common.JDBCTemplate.close;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import admin.member.model.vo.Member;
import admin.portfolio.model.vo.Portfolio;

public class PortfolioDao {

	private Properties prop;
	
	public PortfolioDao() {
		prop = new Properties();
		
		String filePath = PortfolioDao.class.getResource("/config/Portfolio_query.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Portfolio> selectList(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Portfolio> flist = null;
		
		String sql = prop.getProperty("readPortfolio");
		try {
			
			pstmt = con.prepareStatement(sql);
			rset=pstmt.executeQuery();
			
			flist = new ArrayList<Portfolio>();
			
			while(rset.next()) {
				Portfolio f = new Portfolio();
				
				f.setPortNo(rset.getInt("PORTNO"));
				f.setuNo(rset.getInt("UNO"));
				f.setPort(rset.getString("PORT"));
				f.setPoModifyDate(rset.getDate("PO_MODIFY_DATE"));
				f.setPoModifyWriter(rset.getString("PO_MODIFY_WRITER"));
				
	
				flist.add(f);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return flist;
	}
	public Portfolio selectOne(Connection con, int portNo) {
		Portfolio f  = null;
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      
	      String sql = prop.getProperty("selectOne");
	      try {
	         pstmt = con.prepareStatement(sql);
	         
	         pstmt.setInt(1, portNo);
	         
	         
	         // INSERT, UPDATE, DELETE : executeUpdate();
	         // SELECT : executeQuery();
	         rset = pstmt.executeQuery();
	                  
	         // if, while
	         if(rset.next()) {
	        	 f = new Portfolio();
	        	 
	        	 f.setPortNo(rset.getInt("PORTNO"));
					f.setuNo(rset.getInt("UNO"));
					f.setPort(rset.getString("PORT"));
					f.setPoModifyDate(rset.getDate("PO_MODIFY_DATE"));
					f.setPoModifyWriter(rset.getString("PO_MODIFY_WRITER"));
					
					
					

	         }
	         
	         System.out.println("Portfolio 확인 : "+ f);
	         
	      }catch(SQLException e) {
	         e.printStackTrace();
	      }finally {
	         close(rset);
	         close(pstmt);
	      }
	      System.out.println(portNo);
	      return f;
	   }
	/**
	 * 회원정보 수정
	 * @param con
	 * @param n
	 * @return
	 */
	public int updatePortfolio(Connection con, Portfolio f) {
	int result = 0;
	
	PreparedStatement pstmt = null;
	
	
	try {
		String sql = prop.getProperty("updatePortfolio");
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, f.getuNo());
		pstmt.setString(2, f.getPort());
		pstmt.setDate(3, f.getPoModifyDate());
		pstmt.setString(4, f.getPoModifyWriter());
		
		pstmt.setInt(5, f.getPortNo());
		
		result = pstmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		close(pstmt);
	}
	System.out.println("포폴업뎃디에이오");
	System.out.println(result);

		return result;
		
}

}
