package admin.project.model.service;

import static admin.member.common.JDBCTemplate.close;
import static admin.member.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

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

}
