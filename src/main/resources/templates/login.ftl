<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<#if user?exists>
    <#list user as u>
  用户名：${u.userName}
    </#list>
</#if>
</body>
</html>