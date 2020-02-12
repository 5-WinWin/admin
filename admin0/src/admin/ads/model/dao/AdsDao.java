package admin.ads.model.dao;

import static admin.member.common.JDBCTemplate.close;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import admin.ads.model.vo.Ads;
import admin.company.model.vo.Company;

public class AdsDao {

	private Properties prop;
	
	public AdsDao() {
		prop = new Properties();
		
		String filePath = AdsDao.class.getResource("/config/Ads_query.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Ads> selectList(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Ads> alist = null;
		
		String sql = prop.getProperty("readAds");
		try {
			
			pstmt = con.prepareStatement(sql);
			rset=pstmt.executeQuery();
			
			alist = new ArrayList<Ads>();
			
			while(rset.next()) {
				Ads a = new Ads();
				
				a.setcNo(rset.getInt("CNO"));
				a.setpNo(rset.getInt("PNO"));
				a.setAdsStart(rset.getDate("ADS_START"));
				a.setAdsEnd(rset.getDate("ADS_END"));
				a.setAdsPrice(rset.getInt("ADS_PRICE"));
				a.setAdsModifyDate(rset.getDate("ADS_MODIFY_DATE"));
				a.setAdsModifyWriter(rset.getString("ADS_MODIFY_WRITER"));
				
				alist.add(a);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return alist;
	}
	
	public Ads selectOne(Connection con, int cNo) {
		Ads a  = null;
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      
	      String sql = prop.getProperty("selectOne");
	      try {
	         pstmt = con.prepareStatement(sql);
	         
	         pstmt.setInt(1, cNo);
	         
	         
	         rset = pstmt.executeQuery();
	                  
	         // if, while
	         if(rset.next()) {
	        	 a = new Ads();
	        	 
					a.setcNo(cNo);
					a.setpNo(rset.getInt("PNO"));
					a.setAdsStart(rset.getDate("ADS_START"));
					a.setAdsEnd(rset.getDate("ADS_END"));
					a.setAdsPrice(rset.getInt("ADS_PRICE"));
					a.setAdsModifyDate(rset.getDate("C_MODIFY_DATE"));
					a.setAdsModifyWriter(rset.getString("C_MODIFY_WRITER"));
					
					

	         }
	         
	         System.out.println("Ads 확인 : "+ a);
	         
	      }catch(SQLException e) {
	         e.printStackTrace();
	      }finally {
	         close(rset);
	         close(pstmt);
	      }
	      return a;
	   }
	/**
	 * 회원정보 수정
	 * @param con
	 * @param n
	 * @return
	 */
	public int updateAds(Connection con, Ads a) {
	int result = 0;
	
	PreparedStatement pstmt = null;
	
	
	try {
		String sql = prop.getProperty("updateAds");
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, a.getpNo());
		pstmt.setDate(2, a.getAdsStart());
		pstmt.setDate(3, a.getAdsEnd());
		pstmt.setInt(4, a.getAdsPrice());
		pstmt.setDate(5, a.getAdsModifyDate());
		pstmt.setString(6, a.getAdsModifyWriter());
		pstmt.setInt(7, a.getcNo());
		
		result = pstmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		close(pstmt);
	}
		return result;
		
}

}
