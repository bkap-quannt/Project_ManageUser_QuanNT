/**
 * Copyright(C), 2015, Luvina Software Company
 * TblUser.java, Jul 8, 2015, Nguyễn Trường Quân
 */
package net.luvina.manageuser.entities;

import java.io.Serializable;
import java.util.Date;
/**
 * @author LA-AM
 *
 */
public class TblUser implements Serializable {

	private int userId;
    private String loginId;
    private String password;
    private String fullName;
    private String email;
    private String tel;
    private int groupId;
    private String groupName;
	private String loginName;
	private int checkAccount;
	private String fullNamekana;
	private Date birthday;


    /**
	 * Contructor TblUser khởi tạo không tham số
	 */
    public TblUser() {
    	this.userId = 0;
		this.groupId = 0;
		this.loginName = "";
		this.password = "";
		this.checkAccount = 0;
		this.fullName = "";
		this.fullNamekana = "";
		this.email = "";
		this.tel = "";
		this.birthday = null;
    }

    /**
     *
     * @param id int ID
     * @param name String fullName
     * @param email String Email
     * @param tel String Tel
     * @param group_id int GroupID
     */
//    public TblUser(int id, String fullName, String email, String tel,
//            String groupName) {
//        this.userId = id;
//        this.fullName = fullName;
//        this.email = email;
//        this.tel = tel;
//        this.groupName = groupName;
//    }
    /**
    * Methor TblUser khởi tạo có tham số
    * @param id ID
    * @param fullName fullName
    * @param email email
    * @param tel tel
    * @param loginId loginId
    * @param password password
    */
  public TblUser(int id, String fullName, String email, String tel,
          String loginId, String password) {
      this.userId = id;
      this.fullName = fullName;
      this.email = email;
      this.tel = tel;
      this.loginId = loginId;
      this.password = password;
  }



  public TblUser(int userid, int groupid, String loginname, String password,
			int checkaccount, String fullname, String fullnamekana,
			String email, String tel, Date birthday) {
		this.userId = userid;
		this.groupId = groupid;
		this.loginName = loginname;
		this.password = password;
		this.checkAccount = checkaccount;
		this.fullName = fullname;
		this.fullNamekana = fullnamekana;
		this.email = email;
		this.tel = tel;
		this.birthday = birthday;
	}

	public TblUser(String loginname) {
		this.loginName = loginname;
	}

	public TblUser(int id) {
		this.userId = id;
	}

	public TblUser(int id, String email, String loginname) {
		this.userId = id;
		this.email = email;
		this.loginName = loginname;
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
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return the groupId
     */
    public int getGroupId() {
        return groupId;
    }

    /**
     * @param groupId the groupId to set
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
     * @param groupName the groupName to set
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * @return the loginId
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * @param loginId the loginId to set
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the loginName
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * @param loginName the loginName to set
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	/**
	 * @return the checkAccount
	 */
	public int getCheckAccount() {
		return checkAccount;
	}

	/**
	 * @param checkAccount the checkAccount to set
	 */
	public void setCheckAccount(int checkAccount) {
		this.checkAccount = checkAccount;
	}

	/**
	 * @return the fullAamekana
	 */
	public String getFullNamekana() {
		return fullNamekana;
	}

	/**
	 * @param fullAamekana the fullAamekana to set
	 */
	public void setFullNamekana(String fullAamekana) {
		this.fullNamekana = fullAamekana;
	}

	/**
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}
