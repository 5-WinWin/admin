package admin.notice.model.service;

import static admin.member.common.JDBCTemplate.close;
import static admin.member.common.JDBCTemplate.commit;
import static admin.member.common.JDBCTemplate.getConnection;
import static admin.member.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import admin.ads.model.vo.Ads;
import admin.notice.model.dao.NoticeDao;
import admin.notice.model.vo.Notice;


public class NoticeService {
	

		private NoticeDao nDao = new NoticeDao();
		
		public ArrayList<Notice> readNotice() {
			Connection con = getConnection();
			
			ArrayList<Notice> nlist = nDao.selectList(con);
			
			close(con);
			return nlist;
		}
		
		public int insertNotice(Notice n) {
			Connection con = getConnection();

			con = getConnection();
			int result = nDao.insertNotice(con,n);
			
			if(result > 0) commit(con);
			else rollback(con);
			
			close(con);
			return result;
		}
	}

