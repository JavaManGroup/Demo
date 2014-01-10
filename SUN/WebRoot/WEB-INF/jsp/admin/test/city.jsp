<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
[
<c:forEach var="c" items="${allCity}">
	["${c.cityId}", "${c.cityName}"],
</c:forEach>
	[" ", " "]
]