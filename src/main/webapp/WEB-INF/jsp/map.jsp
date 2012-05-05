<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/js/jquery-1.7.2.min.js" var="jquery_url"/>
<c:url value="/css/main.css" var="css_url"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="${css_url }" media="screen" rel="stylesheet" type="text/css" />

<title>GeoChat: Location</title>

<script src="${jquery_url}" type="text/javascript"></script>
<script src="http://api-maps.yandex.ru/2.0/?load=package.full&lang=ru-RU" type="text/javascript"></script>

<!-- Yandex Map -->
<script type="text/javascript">

ymaps.ready(function () { 
  var ymap = new ymaps.Map('ymap', 
		{
	    center: [60.02, 30.37],
	    zoom: 15
	  }, 
	  {
	      balloonMaxWidth: 200
	  }
	);
  
  ymap.events.add('click', function (e) {
      if (ymap.balloon.isOpen()) {
    	  ymap.balloon.close();
      }
      
      var coords = e.get('coordPosition');
      ymap.balloon.open(coords, {
        contentHeader: 'Я здесь!!',
        contentBody: '<p>Местоположение: ' + [coords[0].toPrecision(6), coords[1].toPrecision(6)].join(', ') + '</p>',
        contentFooter: '<sup>GeoChat Locator</sup>'
      });
      $('#latitude').val(coords[0].toPrecision(6));
      $('#longitude').val(coords[1].toPrecision(6));
  });
  
});
</script>

</head>
<body>

  <h2>Location page</h2>
  <h3>Click on map to set your location</h3>
  <div id="ymap" class="map_container"></div>
  <div id="message_box" class="message_container">
    <form action="/" method="post">
		  <table>
		    <tr>
		      <td>Имя пользователя:</td>
		      <td>
		        <input type="text" value="" name="nickname" id="nickname"/>
		      </td>
		    </tr>
		    <tr>
		      <td>Сообщение:</td>
		      <td>
		        <textarea rows="8" cols="40" id="message" name="message"></textarea> 
		      </td>
		    </tr>
		    <tr>
		      <td>Широта:</td>
		      <td>
		        <input type="text" value="" name="latitude" id="latitude" readonly="readonly"/>
		      </td>
		    </tr>
		    <tr>
		      <td>Долгота:</td>
		      <td>
		        <input type="text" value="" name="longitude" id="longitude" readonly="readonly"/>
		      </td>
		    </tr>
		  </table>
    </form>
    <input type="submit"/>
  </div>

</body>
</html>