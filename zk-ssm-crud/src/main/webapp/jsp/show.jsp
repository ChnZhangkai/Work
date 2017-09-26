<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.2.6.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主界面</title>

<script type="text/javascript">
	/* 返回全部 */
	/* function reSelect(){
		$.ajax({
			type:"get",
			url:"/user/select/all",
			dataType:"json",
			data:{},
			success:function(data){
				
			}
		})
		
	} */
	
	/* 姓名条件查询 */
	function selectByCondition() {
		/* alert('hello') */
		$.ajax({
			type:"post",
			url:"/user/select/all",
			dataType:"json",
			data:$('#Sform').serialize(),
			success:function(data){
				alert("传参")
			}
		})
	}
	
	function selectById(id){
		$.ajax({
			type:"get",
			url:"/user/select",
			data:{"id":id},
			success:function(){
				window.open("/user/select?id=" + id)
			}
		})
		
	}
	
	/* 根据id删除 */
	function deleteById(id) {
		$.ajax({
			type:"get",
			url:"/user/delete",
			data:{"id":id},
			success:function(data){
				
			}
			
		})
		window.location.reload();
		
	}
	
	
	
</script>

</head>
<body>
	<div style="height: 200px;">
		<h1 align="center">主界面</h1>
	</div>
	
	<div align="center">
		<a href="/user/select/all">返回全部</a>
	</div>
	
	<form id="Sform">
		<div align="center">
			姓名<input type="text" id="name" name="name">
			<button id="button" onclick="selectByCondition()">查询</button>
		</div>
	</form>
	
	
	<table border="1px" align="center" cellspacing="0" width="350px">
		<tr>
			<td>编号</td>
			<td>姓名</td>
			<td>年龄</td>
			<td>地址</td>
			<td colspan="2" align="center">操作</td>
		</tr>
		<c:forEach var="items" items="${userList}">

			<tr>
				<td id="userid">${items.id}</td>
				<td id="name">${items.name}</td>
				<td id="age">${items.age}</td>
				<td id="address">${items.address}</td>
				<td><a href="#" onclick="selectById(${items.id})"><font style="color: blue;">编辑</font></a></td>
				<td><a href="#" onclick="deleteById(${items.id})"><font style="color: red;">删除</font></a></td>
			</tr>

		</c:forEach>
	</table>
</body>
</html>