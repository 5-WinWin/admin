package admin.project.model.service;

import static admin.member.common.JDBCTemplate.close;
import static admin.member.common.JDBCTemplate.commit;
import static admin.member.common.JDBCTemplate.getConnection;
import static admin.member.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import admin.member.model.vo.Member;
import admin.project.model.dao.ProjectDao;
import admin.project.model.vo.Project;

public class ProjectService {

	private ProjectDao pDao = new ProjectDao();
	
	public ArrayList<Project> readProject() {
		Connection con = getConnection();
		
		ArrayList<Project> plist = pDao.selectList(con);
		
		close(con);
		return plist;
	}

	public int updateProject(Project p) {
		Connection con = getConnection();

		con = getConnection();
		int result = pDao.updateProject(con,p);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		return result;
	}
	
public Project selectOne(int pNo) {
		
		Connection con = getConnection();
		
		Project p = pDao.selectOne(con,pNo);
		
		if(p !=null) {
			
			
			commit(con);
			
		}else rollback(con);
		
		close(con);
		return p;
	}
}
