<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<fmt:requestEncoding value="UTF-8"/>
<c:choose>
	<c:when test="${ pageContext.request.method == 'GET' }">
		<h2>검색하려는 지역을 입력하세요</h2>
		<hr>
		<form method="post" action="/mvc/jspexam/latlng.jsp">
			지역이름 : <input type="text" name="address"><br>
			<input type="submit" value="입력완료">
		</form>	
	</c:when>
	<c:otherwise>
	     <h2>${param.address}지역의 정보</h2>
	     <hr>
	     <c:catch  var="ex">
	     	<c:import var="xmldata" url="https://maps.googleapis.com/maps/api/geocode/xml">
	     	<c:param name="address" value="${ param.address }"></c:param>
	    	<c:param name="language" value="ko"></c:param>
	     	<c:param name="key" value="AIzaSyD8k2DWC_7yFHCrH6LDR3RfITsmWMEqC8c"></c:param>	     	
	     	</c:import>
	        <x:parse xml="${xmldata }" varDom="xdata" />
	        <x:if select="$xdata//status = \"OK\"">
	        <ul>
	        	<x:forEach select="$xdata//result">
	        			<li>장소 : <x:out select="formatted_address"/></li>
	        			</x:forEach>
	        			<x:forEach select="$xdata//result/geometry/location">
     					<li>위도 : <x:out select="lat"/></li>
     					<li>경도 : <x:out select="lng"/></li>
	        	</x:forEach>
	        </ul>	
	        </x:if> 
	         <x:if select="$xdata//status = \"REQUEST_DENIED\"">
	        	<h2>서비스 사용허가를 받지 못했습니다.</h2>
	        	서버로 부터 전달된 오류 메세지 : <x:out select="error_message"/>
	        </x:if>
	     </c:catch>	
	     	     <c:if test="${ !empty ex }">
	     	<h3>오류 발생 : ${ex}</h3>	     
	     </c:if>
	</c:otherwise>
</c:choose>
</body>
</html>
