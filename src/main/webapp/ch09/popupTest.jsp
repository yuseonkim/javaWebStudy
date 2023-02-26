<%--
  Created by IntelliJ IDEA.
  User: yuling
  Date: 2023/02/25
  Time: 2:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>자바스크립트에서 쿠키 사용</title>
    <script type="text/javascript">
      window.onload =pageLoad;
      function pageLoad(){
          notShowPop = getCookieValue();
          if(notShowPop != "true"){
              window.open("popUp.html","pop","width=400,height=500,history=no,resizeable=no,scrollbars=yes,memubar=no");
          }
      }
      function getCookieValue(){
          var result = "false";
          if(document.cookie != ""){
              cookie.document.split(";");
              for(var i=0;i<cookie.length;i++){
                  element=cookie[i].split("=");
                  value=element[0];
                  value = value.replace(/^\s*/,'');
                  if(value == "notShowPop"){
                      result = element[1];
                  }
              }
              return result;
          }
      }
      function deleteCookie(){
          document.cookie = "notShowPop="+"false"+";path=/; expires=-1";
      }
    </script>
</head>
<body>
<form>
    <input type="button" value="쿠키삭제" onClick="deleteCookie()">
</form>

</body>
</html>
