package admin.company.model.service;

import static admin.member.common.JDBCTemplate.close;
import static admin.member.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import admin.company.model.dao.CompanyDao;
import admin.company.model.vo.Company;

public class CompanyService {

	private CompanyDao cDao = new CompanyDao();
	
	public ArrayList<Company> readCompany() {
		Connection con = getConnection();
		
		ArrayList<Company> clist = cDao.selectList(con);
		
		close(con);
		return clist;
	}

}
