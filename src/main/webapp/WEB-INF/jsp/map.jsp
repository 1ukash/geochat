<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/js/jquery-1.7.2.min.js" var="jquery_url"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>GeoChat: Location</title>
<script src="http://api-maps.yandex.ru/2.0/?load=package.full&lang=ru-RU" type="text/javascript"></script>
<script src="${jquery_url}" type="text/javascript"></script>

<!-- Yandex Map -->
<script type="text/javascript">
  var ymap = new ymaps.Map('ymap', {
    // центр и коэффициент масштабирования однозначно
    // определяют область картографирования
    center: [55.76, 37.64],
    zoom: 7
  });
</script>

</head>
<body>

  <h2>Location page</h2>
  
  <div id="ymap" style="width: 600px; height: 300px; border: 1px solid gray"/>

</body>
</html>