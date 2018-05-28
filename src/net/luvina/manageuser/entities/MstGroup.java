/**
 * Copyright(C), 2015, Luvina Software Company
 * TblGroup.java, Jul 8, 2015, Nguyễn Trường Quân
 */
package net.luvina.manageuser.entities;

import java.io.Serializable;

/**
 * @author LA-AM
 *
 */
public class MstGroup implements Serializable {

	private int groupid;
    private String groupname;

    /**
	 * Methor MstGroup khởi không tham số
	 */
	public MstGroup() {
		super();
	}

    /**
     * Methor MstGroup khởi có tham số
     * @param id int ID
     * @param name String groupName
     */
    public MstGroup(int id, String name) {
        this.groupid = id;
        this.groupname = name;
    }

	/**
	 * @return the groupId
	 */
	public int getGroupid() {
		return groupid;
	}

	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupid(int groupId) {
		this.groupid = groupId;
	}

	/**
	 * @return the groupName
	 */
	public String getGroupname() {
		return groupname;
	}

	/**
	 * @param groupName the groupName to set
	 */
	public void setGroupname(String groupName) {
		this.groupname = groupName;
	}

}
