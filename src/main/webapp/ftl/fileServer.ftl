<#import "common/spring.ftl" as spring> 
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta http-equiv="Refresh" content="5; URL=http://${localIp}:${port}"/>
	<title>转到文件服务器</title>
	<script language="javascript" type="text/javascript">
	    var i = 6;
	    function countTime(){
		    i--;
		    if(i==-1)
		      return null;
		    document.getElementById("time").innerHTML = i;
		    setTimeout("countTime();",1000);
		}
	</script>
</head>
<body onload="countTime()">
   <p><p2 id="time" style="font-family: 'Times New Roman',font-size:10, font-weight: bold" >5</p2>秒后转到文件服务器... http://${localIp}:${port}</p>
   <p>点击<a href="http://${localIp}:${port}">这里</a>直接跳转</P>
</body>
</html>