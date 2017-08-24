<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
	<c:forEach var="message" items="${messageList}">
		<p><table><td onClick="showValue('${message.label}');"  style="padding-right: 1em;">
			<c:out value="${message.label}" />
		</td>
		<td onClick="showDelete('${message.label}');"  style="float:right"><u style="color:#EF6989"><small><span class="glyphicon glyphicon-trash"></span>Delete</small></u></td>
		<td onClick="showEdit('${message.label}');" style="float:right;padding-right: 1em;"><u style="color:blue"><small><span class="glyphicon glyphicon-pencil"></span>Edit</small></u></td>
</table></p>
	</c:forEach>
	
	
	

	
	
	
	
	
</body>
</html>