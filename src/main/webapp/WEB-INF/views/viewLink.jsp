<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<a href="/test/test1">/test/test1(get)</a><br /> 
		<a href="/test/test2">/test/test2(get)</a><br />
		
		<form name="frm1" action="/test/test1" method="post">
		<input type="button" value="/test/test1(post)" onclick="this.form.submit();" />
		</form>

		<form name="frm2" action="/test/test2" method="post">
		<input type="button" value="/test/test2(post)" onclick="this.form.submit();" />
		</form>

	</div>

</body>
</html>