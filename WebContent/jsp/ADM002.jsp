
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="net.luvina.manageuser.entities.*"%>
<%@page import="net.luvina.manageuser.utils.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<jsp:include page="header.jsp" />

<!-- Begin vung dieu kien tim kiem -->
<form action="ListUser.do" method="post" name="mainform"><!-- Begin Tag hidden -->
<input type="hidden" name="page" value="1" /> <!-- End Tag hidden -->
<table class="tbl_input" border="0" width="90%" cellpadding="0"
	cellspacing="0">
	<tr>
		&nbsp;
		</td>
	</tr>
	<tr>
		<td>会員名称で会員を検索します。検索条件無しの場合は全て表示されます。</td>
	</tr>
	<tr>
		<td width="100%">
		<table class="tbl_input" cellpadding="4" cellspacing="0">
			<tr>
				<td class="lbl_left">氏名:</td>
				<td align="left"><input class="txBox" type="text"
					name="full_name" value="<%=request.getAttribute("full_name")%>"
					size="20" onfocus="this.style.borderColor='#0066ff';"
					onblur="this.style.borderColor='#aaaaaa';" /></td>
				<td></td>
			</tr>
			<tr>
				<td class="lbl_left">グループ:</td>
				<td align="left" width="80px"><select name="group_id">
					<option value="0">全て</option>
					<c:if test="${listGroup != null}">
						<c:forEach items="${listGroup}" var="group">
							<c:choose>
								<c:when test="${key_search_group_id == group.groupid}">
									<option value="<c:out value="${group.groupid}"></c:out>"
										selected="selected"><c:out value="${group.groupname}"></c:out></option>
								</c:when>
								<c:otherwise>
									<option value="<c:out value="${group.groupid}"></c:out>"><c:out
										value="${group.groupname}"></c:out></option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</c:if>
				</select></td>
				<td align="left"><input class="btn btn_wider" name="btntk" type="submit"
					value="検索" /></td>
				<td align="left"><input class="btn btn_wider"	onclick="location.href = 'AddUser.do'"name="btnAdd" type="button"
					value="新規追加" /></td>

			</tr>
		</table>
		</td>
	</tr>
</table>
<!-- End vung dieu kien tim kiem -->

<!-- Begin vung hien thi danh sach user -->

<c:choose>
	<c:when test="${message != ''}">
		<tr>
			<td class="errMsg"><c:out value="${message}" /></td>
		</tr>
	</c:when>
	<c:otherwise>
		<table class="tbl_list" border="1" cellpadding="4" cellspacing="0"
			width="80%">
			<tr class="tr2">
				<!--Thông tin</th>-->
				<th align="center" width="20px">ID</th>
				<th align="left">氏名 <c:choose>
					<c:when test="${sortByFullName == 'DESC'}">
						<a href="ListUser.do?sortType=full_name&sortByFullName=ASC">▲▽</a>
					</c:when>
					<c:otherwise>
						<a href="ListUser.do?sortType=full_name&sortByFullName=DESC">△▼</a>
					</c:otherwise>
				</c:choose></th>
				<th align="left">生年月日</th>
				<th align="left">グループ</th>
				<th align="left">メールアドレス</th>
				<th align="left" width="70px">電話番号</th>
				<th align="left">日本語能力 <c:choose>
					<c:when test="${sortByCodeLevel == 'ASC'}">
						<a href="ListUser.do?sortType=code_level&sortByCodeLevel=DESC">△▼</a>
					</c:when>
					<c:otherwise>
						<a href="ListUser.do?sortType=code_level&sortByCodeLevel=ASC">▲▽</a>
					</c:otherwise>
				</c:choose></th>
				<th align="left">失効日 <c:choose>
					<c:when test="${sortByEndDate == 'ASC'}">
						<a href="ListUser.do?sortType=end_date&sortByEndDate=DESC">▲▽</a>
					</c:when>
					<c:otherwise>
						<a href="ListUser.do?sortType=end_date&sortByEndDate=ASC">△▼</a>
					</c:otherwise>
				</c:choose></th>
				<th align="left">点数</th>
			</tr>

			<c:forEach items="${listUser}" var="user">
				<fmt:formatDate var="birthday" value="${user.birthday}"
					pattern="yyyy/MM/dd" />
				<fmt:formatDate var="enddate" value="${user.enddate}"
					pattern="yyyy/MM/dd" />
				<tr>
					<!--Thông tin-->
					<td align="right"><a href="ViewEdit.do?valueId=${user.id}">${user.id}</a></td>
					<td align="left">${user.fullName}</td>
					<td align="center">${birthday}</td>
					<td align="left">${user.groupName}</td>
					<td align="left">${user.email}</td>
					<td align="left">${user.tel}</td>
					<td align="left">${user.namelevel}</td>
					<td align="center">${enddate}</td>
					<c:choose>
						<c:when test="${user.total!=0}">
							<td align="right">${user.total}</td>
						</c:when>
						<c:otherwise>
							<td align="right"></td>
						</c:otherwise>
					</c:choose>
				</tr>
			</c:forEach>
		</table>
	</c:otherwise>
</c:choose>
</form>
<!-- End vung hien thi danh sach user -->

<!-- Begin vung paging -->
<table class="lbl_paging">
	<tr>
		<c:if test="${minPageSection > 0}">
			<c:if test="${currentSection > 1}">
				<td>
					<a href="ListUser.do?page=${minPageSection-3}">
						<c:out value=" << "></c:out>
					</a>
				</td>
			</c:if>
			<c:forEach var="page" items="${getListPage}">
				<c:choose>
					<c:when test="${currentPage == page}">
						<td>${page}</td>
					</c:when>
					<c:otherwise>
						<td><a href="ListUser.do?page=${page}">${page}</a></td>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${currentSection < totalSection}">
				<td>
					<a href="ListUser.do?page=${maxPageSection+1}">
						<c:out value=" >> "></c:out>
					</a>
				</td>
			</c:if>
		</c:if>
	</tr>
</table>

<!-- End vung paging -->
<!-- Begin vung footer -->
<jsp:include page="footer.jsp" />
<!-- End vung footer -->