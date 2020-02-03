<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import = "model.vo.NewsVO, java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head><style>
	#title{
		text-align : center;
		font-weight : bold;
		color : blue;
		font-size : 36.5pt;
	}
	td{
		border-bottom : 1px solid black;
	}
	tr:hover{
		background-color : pink;	
		font-weight : bold;
	}
	td:nth-child(3){
		width : 400px;
	}
	#writetext{
		text-align : center;
		margin : auto;
	}
	#write{
		text-align : center;
		margin : auto;
	}
	.sub{
		text-align : center;
		font-weight : bold;
		font-size : 16.5pt;
	}
</style>
<body>
<%
	ArrayList<NewsVO> list = (ArrayList<NewsVO>)request.getAttribute("list");
	if(list !=null){
%>
	<h2 id="title">뉴스 게시판</h2>
	<table style="margin:auto">
	<tr>
	<td class="sub" style="color:blue">번호</td>
	<td class="sub" style="color:red">제목</td>
	<td class="sub" style="color:purple">작성자</td>
	<td class="sub" style="color:orange">작성일</td>
	<td class="sub" style="color:green">조회수</td>
	</tr>
<%
		for(NewsVO vo : list){
%>
			<tr>
			<td class='<%= vo.getId() %>'><%= vo.getId() %></td>
			<td class='<%= vo.getId() %>'><%= vo.getTitle() %></td>
			<td class='<%= vo.getId() %>'><%= vo.getWriter() %></td>
			<td class='<%= vo.getId() %>'><%= vo.getWritedate() %></td>
			<td class='<%= vo.getId() %>'><%= vo.getCnt() %></td>
			</tr>			
			
			
<%-- 			<a href ='/mvc/news?action=delete&newsid=<%= vo.getId() %>'>
			<img src = "/mvc/images/delete.png" width = '30'></a>
			<img onclick="displayUpdateForm('<%= vo.getId() %>')" 
			       src="/mvc/images/edit.png" width = '30'> 
			       
			       
			<td class='<%= vo.getId() %>'><%= vo.getContent() %></td>
			       
			       --%>
			       
 

<%
		}
%>
	</table>
<%
	}
	if (request.getAttribute("msg") != null) {
%>
	<script>
		alert('${ msg }');
	</script>

<%
	}
%>
<div id="writetext">
<button onclick="displayDiv(1);">뉴스 작성</button>
</div>
<script>
function displayDiv(type) {
	if(type == 1) {
		document.getElementById("write").style.display='block';
	}else if(type == 2) {
		document.getElementById("write").style.display='none';
	}	
}
function displayUpdateForm(cv) {
    var doms = document.getElementsByClassName(cv)
	document.getElementById("write").style.display='block';	
	document.getElementById("m_writer").value = 
		                                  doms[0].textContent;
	document.getElementById("m_title").value = 
		                                  doms[1].textContent;
	document.getElementById("m_content").value = 
										  doms[2].textContent;
	document.getElementById("divT").textContent="뉴스정보 수정";
	document.querySelector("#write [type=submit]").value="수정";
	document.querySelector("#write [type=hidden]").value=cv;
}
</script>
<div id="write"  style="display:none">
<h2 id="divT"></h2>
<form method = "post" action = "/mvc/news">
<input type="hidden" name="action" value="insert">
<input id="m_writer" type="text"  name="gwriter" placeholder="작성자명을 입력해주세요">
<br>
<input id="m_title" type="text" name="gtitle" placeholder="제목을 입력해주세요">
<br>
<textarea id="m_content"  rows="3" cols="30" name = "gcontent" placeholder="내용을 입력해주세요" ></textarea>
<br>
<input type = "submit" value = "저장">
<input type = "reset" value = "재작성">
<button onclick="displayDiv(2);return false;">취소</button>
</form>
</div>
</body>
</html>



