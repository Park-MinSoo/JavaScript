<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import = "model.vo.NewsVO, java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head><style>
	td{
		border-bottom : 2px dotted green;
	}
	tr:hover{
		background-color : pink;	
		font-weight : bold;
	}
	td:nth-child(2){
		width : 400px;
	}
</style>
<body>
<%
	ArrayList<NewsVO> list = (ArrayList<NewsVO>)request.getAttribute("list");
	NewsVO listview = (NewsVO)request.getAttribute("listview");
	System.out.println("listview는?"+listview);
	
	
	if(list !=null){
%> 
	<h2>뉴스게시판</h2><hr>
	<table>
		<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>조회수</th>
		</tr> <%
		for(NewsVO vo : list){%>
			<tr>					
			<td><%= vo.getId() %></td>		
			<td onClick="location.href='/mvc/news?action=read&newsid=<%=vo.getId()%>'"> <%= vo.getTitle() %></td>
			<td onClick="location.href='/mvc/news?action=listwriter&newswriter=<%=vo.getWriter()%>'"><%= vo.getWriter() %></td>
			<td><%= vo.getWritedate() %></td>
			<td><%= vo.getCnt() %></td>
			</tr><%
		} 		
		
		
	
%>
	</table>
	<hr>
	
	<div>
	<form method ="get" action ="/mvc/news">	
	<select name="searchType">
	  <option value="title">제목</option>
	  <option value="writer">작성자</option>	 
	</select>
	<input type="text"  name="key">	
	<input type ="submit" value="뉴스검색">
	</form>
	</div>	
<%}	
%>	
<%
	if (request.getAttribute("msg") != null) {
%>
	<script>
		alert('${ msg }');
	</script>
<%}
	
	%>

<button onclick="displayDiv(1);">뉴스 작성</button>
<div id="write"  style="display:none">
<form method = "post" action = "/mvc/news">
<input type="hidden" name="action" value="insert">
<input placeholder="작성자명을 입력해주세요" type="text"  name="writer">
<br>
<input placeholder="제목을 입력해주세요" type="text"  name="title"
>
<br>
<textarea placeholder="내용을 입력해주세요" rows="3" cols="30" name ="content" ></textarea>
<br>
<input type = "submit" value = "등록">
<input type = "reset" value = "재작성">
<input type ="button" value="취소"  onclick="displayDiv(2)">
</form>
</div>

<% 
if(listview !=null){
%>
<div id="update">
<form method = "post" action = "/mvc/news">
<input type="hidden" name="newid" value="${listview.id}">
<input id="m_writer"  type="text"  name="writer" value="${listview.writer}">
<br>
<input id="m_title" type="text"  name="title"  value="${listview.title}">
<br>
<textarea id="m_content" rows="3" cols="30" name ="content" >${listview.content}</textarea>
<br>
<input type = "button" value = "확인 " onclick="displayDiv(3)">
<input type = "submit" value = "수정" onclick="displayUpdateForm(${listview.id})" >
<input type ="button" value="삭제" onclick="location.href='/mvc/news?action=delete&newsid=${listview.id}'">
</form>	
</div>	
<%		
	}		
%>
<script>
function displayDiv(dis) { 
		if(dis==1){
		document.getElementById("write").style.display='block';		
		}
		else if(dis==2){
		document.getElementById("write").style.display='none';			
		}
		else if(dis==3){
		document.getElementById("update").style.display='none';
		}
	
}
function displayUpdateForm(cv) {
    var doms = document.getElementsByClassName(cv)
	document.getElementById("update").style.display='block';	
	document.getElementById("m_writer").value = doms[0].textContent;
	document.getElementById("m_title").value = doms[1].textContent;
	document.getElementById("m_content").value = doms[2].textContent;

}
</script>
</body>
</html>





