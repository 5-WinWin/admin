package admin.ads.model.service;

import static admin.member.common.JDBCTemplate.close;
import static admin.member.common.JDBCTemplate.commit;
import static admin.member.common.JDBCTemplate.getConnection;
import static admin.member.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import admin.ads.model.dao.AdsDao;
import admin.ads.model.vo.Ads;

public class AdsService {

	private AdsDao aDao = new AdsDao();
	
	public ArrayList<Ads> readAds() {
		Connection con = getConnection();
		
		ArrayList<Ads> alist = aDao.selectList(con);
		
		close(con);
		return alist;
	}

	public int updateAds(Ads a) {
		Connection con = getConnection();

		con = getConnection();
		int result = aDao.updateAds(con,a);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		return result;
	}
	
public Ads selectOne(int cNo) {
		
		Connection con = getConnection();
		
		Ads a = aDao.selectOne(con,cNo);
		
		if(a !=null) {
			
			
			commit(con);
			
		}else rollback(con);
		
		close(con);
		return a;
	}
}
