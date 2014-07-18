<#import "common/spring.ftl" as spring> 
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>文件上传</title>
		<#include "common/header.ftl">
	</head>
	
	<body>
		<div id="wrapper">
			<#include "common/body.ftl">
			<div class="post">
				    <form action="/blog-web/fileUpload" method="post" enctype="multipart/form-data">
					    <table>
					    	<tr>
					    		<input type="file" name="myfile" /><br/>  
            					<input type="submit" value="上传文件 "/>  
					    	</tr>
					    </table>
					</form>
			</div>
		</div>
	</body>

</html>