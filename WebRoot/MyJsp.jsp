<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Testing websockets</title>
</head>
<body>
  <div>
    <input type="submit" value="Start" onclick="start()" />
    <input type="submit" value="Send" onclick="sendMessage()" />
  </div>
  <div id="messages"></div>
  T：<div id="tmp"></div>
  H：<div id="hum"></div>
  <script type="text/javascript">
    /*var webSocket =
      new WebSocket('ws://localhost:8080/SH/websocketS');*/
 	var webSocket= new WebSocket('ws://cquptsmarthome.xicp.net:7799/ZH/websocketS');
    webSocket.onerror = function(event) {
      onError(event)
    };
 
    webSocket.onopen = function(event) {
      onOpen(event)
    };
 
    webSocket.onmessage = function(event) {
      onMessage(event)
    };
 
    function onMessage(event) {
      document.getElementById('tmp').innerHTML = event.data;
    }
 
    function onOpen(event) {
      document.getElementById('messages').innerHTML
        = 'Connection established';
    }
 
    function onError(event) {
      alert(event.data);
    }
 
    function start() {
      webSocket.send('hello');
      return false;
    }
    function sendMessage(){
    	webSocket.send('openlight');
    }
  </script>
</body>
</html>
