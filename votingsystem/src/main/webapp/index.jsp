<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Restaurant</title>
</head>
<body>
<h2>Simple page</h2>
<form method="post" action="users">
    <b>Select the user:&nbsp;</b>
    <select name="userId">
        <option value="100000">Administrator</option>
        <option value="100002">customer1</option>
        <option value="100003">customer2</option>
        <option value="100004">customer3</option>
    </select>
    <button type="submit">Select</button>
</form>
</body>
</html>
