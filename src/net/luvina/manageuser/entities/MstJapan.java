/*
 * Copyright(C) 2015 Luvina Software Company
 * MstJapan.java, July 09, 2015 Nguyễn Trường Quân
 */
package net.luvina.manageuser.entities;

/**
 * @author QuanNT
 *
 */
public class MstJapan {

		private String codeLevel;
		private String nameLevel;

		/**
		 * Methor MstJapan khởi tạo không tham số
		 */
		public MstJapan() {
			super();
		}

		/**
		 * Methor MstJapan khởi tạo có tham số
		 * @param codeLevel
		 * @param nameLevel
		 */
		public MstJapan(String codeLevel, String nameLevel) {
			this.codeLevel = codeLevel;
			this.nameLevel = nameLevel;
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
		 * @return the nameLevel
		 */
		public String getNameLevel() {
			return nameLevel;
		}
		/**
		 * @param nameLevel the nameLevel to set
		 */
		public void setNameLevel(String nameLevel) {
			this.nameLevel = nameLevel;
		}

}
