package admin.member.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Member implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7487643460817190566L;
	
	private int uNo;
	private String uName;
	private String uId;
	private String uPwd;
	private String uIntro;
	private String uprofile;
	private String uEmail;
	private String uPhone;
	private Date uRegDate;
	private Date uModifyDate;
	private String uModifyWriter;
	
	public Member() {
	}

	public Member(int uNo, String uName, String uId, String uPwd, String uIntro, String uprofile, String uEmail,
			String uPhone, Date uRegDate, Date uModifyDate, String uModifyWriter) {
		super();
		this.uNo = uNo;
		this.uName = uName;
		this.uId = uId;
		this.uPwd = uPwd;
		this.uIntro = uIntro;
		this.uprofile = uprofile;
		this.uEmail = uEmail;
		this.uPhone = uPhone;
		this.uRegDate = uRegDate;
		this.uModifyDate = uModifyDate;
		this.uModifyWriter = uModifyWriter;
	}

	public int getuNo() {
		return uNo;
	}

	public void setuNo(int uNo) {
		this.uNo = uNo;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getuPwd() {
		return uPwd;
	}

	public void setuPwd(String uPwd) {
		this.uPwd = uPwd;
	}

	public String getuIntro() {
		return uIntro;
	}

	public void setuIntro(String uIntro) {
		this.uIntro = uIntro;
	}

	public String getUprofile() {
		return uprofile;
	}

	public void setUprofile(String uprofile) {
		this.uprofile = uprofile;
	}

	public String getuEmail() {
		return uEmail;
	}

	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}

	public String getuPhone() {
		return uPhone;
	}

	public void setuPhone(String uPhone) {
		this.uPhone = uPhone;
	}

	public Date getuRegDate() {
		return uRegDate;
	}

	public void setuRegDate(Date uRegDate) {
		this.uRegDate = uRegDate;
	}

	public Date getuModifyDate() {
		return uModifyDate;
	}

	public void setuModifyDate(Date uModifyDate) {
		this.uModifyDate = uModifyDate;
	}

	public String getuModifyWriter() {
		return uModifyWriter;
	}

	public void setuModifyWriter(String uModifyWriter) {
		this.uModifyWriter = uModifyWriter;
	}
	
	
	@Override
	public String toString() {
		return "Member [uNo=" + uNo + ", uName=" + uName + ", uId=" + uId + ", uPwd=" + uPwd + ", uIntro=" + uIntro
				+ ", uprofile=" + uprofile + ", uEmail=" + uEmail + ", uPhone=" + uPhone + ", uRegDate=" + uRegDate
				+ ", uModifyDate=" + uModifyDate + ", uModifyWriter=" + uModifyWriter + "]";
	}
	
}
