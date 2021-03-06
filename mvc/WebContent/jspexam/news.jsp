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
	#reading{
		text-align : center;
		margin : auto;
	}
	#search{
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
	NewsVO listone = (NewsVO)request.getAttribute("listone");
	System.out.println("listone:"+listone);
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
			<td class='<%= vo.getId() %>' onclick="location.href='/mvc/news?action=read&newsid=<%= vo.getId() %>'"><%= vo.getTitle() %></td>
			<td class='<%= vo.getId() %>' onclick="location.href='/mvc/news?action=listwriter&writer=<%= vo.getWriter() %>'"><%= vo.getWriter() %></td>
			<td class='<%= vo.getId() %>'><%= vo.getWritedate() %></td>
			<td class='<%= vo.getId() %>'><%= vo.getCnt() %></td>
			</tr>			
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

<%
	
	if (listone != null) {
		System.out.println("JSP 출력 :" + listone);
%>

<div id="reading">
<form method = "post" action = "/mvc/news">
<input type="hidden" name="action" value="update">
<input type="hidden" name="newsid" value="<%= listone.getId() %>">
<input id="m_writer" type="text"  name="writer" value="<%= listone.getWriter() %>">
<br>
<input id="m_title" type="text" name="title"  value="<%= listone.getTitle() %>">
<br>
<textarea id="m_content"  rows="3" cols="30" name = "content" ><%= listone.getContent() %></textarea>
<br>
<input type= "button" value ="확인"onclick="displayDiv(3)">
<input type= "submit" value ="수정">
<input type= "button" value ="삭제" onclick="location.href ='/mvc/news?action=delete&newsid=<%= listone.getId()%>'" >
</form>
</div>
<%
	}
%>

<script>
function displayDiv(type) {
	if(type == 1) {
		document.getElementById("write").style.display='block';
	}else if(type == 2) {
		document.getElementById("write").style.display='none';
	}
	else if(type == 3){
		document.getElementById("reading").style.display='none';
	}
}
</script>
<div id="write"  style="display:none">
<form method = "post" action = "/mvc/news">
<input type="hidden" name="action" value="insert">
<input type="text"  name="writer" placeholder="작성자명을 입력해주세요">
<br>
<input type="text" name="title" placeholder="제목을 입력해주세요">
<br>
<textarea rows="3" cols="30" name = "content" placeholder="내용을 입력해주세요" ></textarea>
<br>
<input type = "submit" value = "저장">
<input type = "reset" value = "재작성">
<button onclick="displayDiv(2);return false;">취소</button>
</form>
</div>


<div id="search">
<form method = "get" action ="/mvc/news">
<input type="hidden" name="action" value="search">
<select name="searchType">
<option value = "content">내용</option>
<option value = "title">제목</option>
<option value = "writer">작성자</option>
</select>
<input type = "text" name = "keyword" >
<input type = "submit" value = "뉴스검색">
</form>
</div>
</body>
</html>
