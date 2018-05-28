/*
 * Copyright(C) 2015 Luvina Software Company
 * TblDetailUserJapan.java, Jul 9, 2015, Nguyễn Trường Quân
 */
package net.luvina.manageuser.entities;
import java.util.Date;
/**
 * @author LA-AM
 *
 */
public class TblDetailUserJapan {

	private int detailUserJapanId;
	private int userId;
	private String codeLevel;
	private Date startDate;
	private Date endDate;
	private int total;

	/**
	 * Methor TblDetailUserJapan khởi không tham số
	 */
	public TblDetailUserJapan() {
		super();
	}

	/**
	 * Methor TblDetailUserJapan khởi có tham số
	 * @param detailUserJapanId
	 * @param userId
	 * @param codeLevel
	 * @param startDate
	 * @param endDate
	 * @param total
	 */
	public TblDetailUserJapan(int detailUserJapanId, int userId,
			String codeLevel, Date startDate, Date endDate, int total) {
		//super();
		this.detailUserJapanId = detailUserJapanId;
		this.userId = userId;
		this.codeLevel = codeLevel;
		this.startDate = startDate;
		this.endDate = endDate;
		this.total = total;
	}

	/**
	 * @return the detailUserJapanId
	 */
	public int getDetailUserJapanId() {
		return detailUserJapanId;
	}
	/**
	 * @param detailUserJapanId the detailUserJapanId to set
	 */
	public void setDetailUserJapanId(int detailUserJapanId) {
		this.detailUserJapanId = detailUserJapanId;
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
	 * @return the codeLevel
	 */
	public String getCodeLevel() {
		return codeLevel;
	}
	/**
	 * @param codeLevel the codeLevel to set
	 */
	public void setCodeLevel(String codeLevel) {
		this.codeLevel = codeLevel;
	}
	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}
}
