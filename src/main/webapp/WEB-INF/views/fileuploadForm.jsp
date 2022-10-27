<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"></head>
<body>
	<div>
		<form name="frm" action="/test/fileupload" method="get"
			enctype="multipart/form-data">
			<input type="file" name="uploadFile" /><br /> <input type="file"
				name="uploadFile" /><br /> <input type="file" name="uploadFile" /><br />
			<input type="button" value="업로드" onclick="frm.submit();" /><br />
		</form>

	</div>

</body>
</html>