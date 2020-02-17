package admin.eye.model.service;

import static admin.member.common.JDBCTemplate.close;
import static admin.member.common.JDBCTemplate.commit;
import static admin.member.common.JDBCTemplate.getConnection;
import static admin.member.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import admin.eye.model.dao.EyeDao;
import admin.eye.model.vo.Eye;


public class EyeService {
	

		private EyeDao eDao = new EyeDao();
		
		public ArrayList<Eye> readEye() {
			Connection con = getConnection();
			
			ArrayList<Eye> elist = eDao.selectList(con);
			
			close(con);
			return elist;
		}
		
		
		
		public Eye selectOne(int eNo) {
			
			Connection con = getConnection();
			
			Eye e = eDao.selectOne(con,eNo);
			
			if(e !=null) {
				
				
				commit(con);
				
			}else rollback(con);
			
			close(con);
			return e;
		}
		
		public int updateEye(Eye e) {
			Connection con = getConnection();

			con = getConnection();
			int result = eDao.updateEye(con,e);
			
			if(result > 0) commit(con);
			else rollback(con);
			
			close(con);
			return result;
		}
	}

