/*
 * Copyright(C) 2015 Luvina Software Company
 * UserInfor.java, Jul 9, 2015, Nguyễn Trường Quân
 */
package net.luvina.manageuser.entities;
import java.util.Date;
/**
 * @author LA-AM
 *
 */
public class UserInfor {

	private int id;
	private String loginName;
	private String password;
	private String fullName;
	private String fullNameKana;
	private String email;
	private String tel;
	private Date birthday;

	private int groupId;
	private String groupName;

	private String codelevel;
	private String namelevel;

	private int detalID;
	private Date startdate;
	private Date enddate;
	private String total;

	//
	/**
	 * Methor UserInfor khởi tạo không tham số
	 */
	public UserInfor() {
		this.id = 0;
		this.loginName = "";
		this.password = "";

		this.fullName = "";
		this.fullNameKana = "";
		this.email = "";
		this.birthday = null;
		this.tel = "";
		this.groupId = 0;
		this.groupName = "";
		this.codelevel = "";
		this.namelevel = "";
		this.detalID = 0;
		this.startdate = null;
		this.enddate = null;
		this.total = "";
		///
	}
//
//

//

	//

///

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the loginName
	 */
	public String getloginName() {
		return loginName;
	}

	/**
	 * @param loginName
	 *            the loginName to set
	 */
	public void setloginName(String loginName) {
		this.loginName = loginName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName
	 *            the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the fullNameKana
	 */
	public String getFullNameKana() {
		return fullNameKana;
	}

	/**
	 * @param fullNameKana
	 *            the fullNameKana to set
	 */
	public void setFullNameKana(String fullNameKana) {
		this.fullNameKana = fullNameKana;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @param tel
	 *            the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday
	 *            the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return the groupId
	 */
	public int getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId
	 *            the groupId to set
	 */
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	/**
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * @param groupName
	 *            the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	/**
	 * @return the codelevel
	 */
	public String getCodelevel() {
		return codelevel;
	}

	/**
	 * @param codelevel
	 *            the codelevel to set
	 */
	public void setCodelevel(String codelevel) {
		this.codelevel = codelevel;
	}

	/**
	 * @return the namelevel
	 */
	public String getNamelevel() {
		return namelevel;
	}

	/**
	 * @param namelevel
	 *            the namelevel to set
	 */
	public void setNamelevel(String namelevel) {
		this.namelevel = namelevel;
	}

	/**
	 * @return the detalID
	 */
	public int getDetalID() {
		return detalID;
	}

	/**
	 * @param detalID
	 *            the detalID to set
	 */
	public void setDetalID(int detalID) {
		this.detalID = detalID;
	}

	/**
	 * @return the startdate
	 */
	public Date getStartdate() {
		return startdate;
	}

	/**
	 * @param startdate
	 *            the startdate to set
	 */
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	/**
	 * @return the enddate
	 */
	public Date getEnddate() {
		return enddate;
	}

	/**
	 * @param enddate
	 *            the enddate to set
	 */
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}



	/**
	 * @return the total
	 */
	public String getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(String total) {
		this.total = total;
	}

	//


}
