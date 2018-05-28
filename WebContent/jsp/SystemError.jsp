<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/user.js"></script>
<title>ユーザ管理</title>
</head>
<body>
<!-- Begin vung header -->
<jsp:include page="header.jsp" />
<!-- End vung header -->

<!-- Begin vung input-->
<form action="System_Error.do" method="post" name="inputform">
<table class="tbl_input" border="0" width="80%" cellpadding="0"
	cellspacing="0">
	<tr>
		<td align="center" colspan="2">
		<div style="height: 50px"></div>
		</td>
	</tr>
	<tr>
		<td align="center" colspan="2"><font color="red">${message}</font></td>
	</tr>
	<tr>
		<td align="center" colspan="2">
		<div style="height: 70px"></div>
		</td>
	</tr>
	<tr>
		<td align="center" colspan="2"><input class="btn"
			onclick="location.href='ListUser.do'" name="btnback" type="button"
			value="OK" /></td>
	</tr>
</table>
</form>
<!-- End vung input -->

<!-- Begin vung footer -->
<jsp:include page="footer.jsp" />
<!-- End vung footer -->
</body>

</html>