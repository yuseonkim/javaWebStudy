<%--
  Created by IntelliJ IDEA.
  User: yuling
  Date: 2023/02/25
  Time: 2:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
      function setPopUpStart(obj){
          if(obj.checked == true){
              var expireDate= new Date();
              expireDate.setMonth(expireDate.getMonth() + 1);
              document.cookie = "notShowPop=" +"true" + ";path=/; expires="+expireDate.toGMTString();
              window.close();
          }
      }
    </script>
</head>
<body>
알림 팝업창 입니다.
<br><br><br><br><br><br><br>
<form>
    <input type="checkbox" onClick="setPopUpStart(this)"> 오늘 더이상 팝업 안띄우기
</form>

</body>
</html>
