<#import "common/spring.ftl" as spring> 
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<title>创建文件服务器</title>
</head>
<body>
   <p1>创建文件服务器</p1>
   
    <div class="post">
        <form action="/blog-web/fileServer/start" method="post">
		<table>
			<tr>
			    <td><label>文件目录(默认"/")：</label></td>
				<td><input type="text" name="addr" /></td>
			</tr>
			<tr>
				<td><label>服务器端口号(默认9080)：</label></td>
				<td><input type="text" name="port" ></td>
			</tr>
			<tr >
				<td ><button type="submit">创建</button></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>