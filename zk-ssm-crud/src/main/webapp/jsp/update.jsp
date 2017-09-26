<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.2.6.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改页面</title>

<script type="text/javascript">
	function updateById() {
		var data1 = $('#Uform').serialize();
		alert("修改成功！")
		$.ajax({
			type:"post",
			url:"/user/updateUser",
			//data:{"name":name},
			data:data1,
			dataType:"json",
			success:function(data){
				
			}
		})
		window.opener.location.reload();
		window.close()
	}
</script>



</head>
<body>
	<div style="height: 200px;">
		<h1 align="center">修改界面</h1>
	</div>

	<form action="#" id="Uform">
		<table align="center">
			<tr>
				<td>编号</td>
				<td><input type="text" id="id" name="id" value="${user.id}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>姓名</td>
				<td><input type="text" id="name" name="name" value="${user.name}"></td>
			</tr>
			<tr>
				<td>年龄</td>
				<td><input type="text" id="age" name="age" value="${user.age}">
				</td>
			</tr>
			<tr>
				<td>地址</td>
				<td><input type="text" id="address" name="address" value="${user.address}"></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="button" onclick="updateById()">保存</button>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>