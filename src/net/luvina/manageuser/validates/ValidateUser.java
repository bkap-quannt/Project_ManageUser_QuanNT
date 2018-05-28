/**
 * Copyright(C), 2015, Luvina Software Company
 * ValidateUser.java, Jul 8, 2015, Nguyễn Trường Quân
 */
package net.luvina.manageuser.validates;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.StyledEditorKit.BoldAction;

import com.sun.org.apache.xpath.internal.operations.Equals;

import net.luvina.manageuser.entities.MstGroup;
import net.luvina.manageuser.entities.MstJapan;
import net.luvina.manageuser.entities.TblUser;
import net.luvina.manageuser.entities.UserInfor;
import net.luvina.manageuser.logics.impl.MstGroupLogicImpl;
///
import net.luvina.manageuser.logics.impl.TblUserLogicImpl;
import net.luvina.manageuser.utils.Common;
import net.luvina.manageuser.utils.MessageProperties;

/**
 * @author LA-AM
 *
 */
public class ValidateUser {

	/**
	 * validateLogin
	 * @param loginId String loginId
	 * @param password String password
	 * @return list errorMess
	 */
	public static List<String> validateLogin(String loginId, String password) {
		List<String> lsErrorMess = new ArrayList<String>();
		if (loginId.trim().length() == 0) {
			lsErrorMess
					.add("「アカウント名」　" + MessageProperties.getMessage("ER001"));
		}
		if (password.length() == 0) {
			lsErrorMess.add("「パスワード」 " + MessageProperties.getMessage("ER001"));
		}
		TblUserLogicImpl userLogic = new TblUserLogicImpl();
		if (loginId.trim().length() != 0 && password.length() != 0) {
			if (!userLogic.existLoginId(loginId, password)) {
				lsErrorMess.add(MessageProperties.getMessage("ER016"));
			}
		}

		return lsErrorMess;
	}

}
