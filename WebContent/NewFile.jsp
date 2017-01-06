<%@ page pageEncoding="utf-8"%>  
<!DOCTYPE html>  
<html>  
<head>  
<meta charset="utf-8">  
<title>上传图片</title>  
</head>  
<body>  
<form action="/mybatiseproject/user/upLoadUserPortrait" method="post" enctype="multipart/form-data">  
<input type="text" name="id"/>
<input type="file" name="portrait" /> <input type="submit" value="Submit" /></form>  
</body>  
</html> 