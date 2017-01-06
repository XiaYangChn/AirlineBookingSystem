<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
        
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>ABS_Booking</title>

	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<base href="<%=basePath%>">
	<link rel="SHORTCUT ICON" href="<%=path %>/images/airplane.icon"/>
	
	<link rel="stylesheet" href="<%=path %>/css/cube.css">
	<link rel="SHORTCUT ICON" href="<%=path %>/images/airplane.icon"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/absBase.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/booking.css">

	<script type="text/javascript" src="js/booking.js"></script>
</head>
<body>
	<div class="abs_container clearfix b_container">

		<form action="servlet/OrderServlet" method="post" class="b_form">
			<span class="b_form_title">乘客</span>

			<div id="b_formItem_container">
				<div class="b_form_item clearfix">
					<div class="bf_item_idArea">
						<span class="bf_item_id">1</span>
					</div>
						
					<div class="bf_item_textArea">
						<div class="bf_item_text clearfix">
							<span>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</span>
							<div>
								<input type="text" name="name" onfocus="textOnFocus(this)" onblur="textOnBlur(this)">
							</div>
						</div>
						<div class="bf_item_text clearfix">
							<span>护&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;照：</span>
							<div>
								<input type="text" name="passport" onfocus="textOnFocus(this)" onblur="textOnBlur(this)">
							</div>
						</div>
						<div class="bf_item_seatType">
							<span>座位偏好：</span>

							<label class="user_unSelect">
								<input class="bf_item_radioBut" type="radio" checked="checked" name="seatType1" value="default"/>默认
							</label>
							
							<label class="user_unSelect">
								<input class="bf_item_radioBut" type="radio" name="seatType1" value="windowSeat"/>靠窗
							</label>
							
							<label class="user_unSelect">
								<input class="bf_item_radioBut" type="radio" name="seatType1" value="middleSeat"/>中间
							</label>
							
							<label class="user_unSelect">
								<input class="bf_item_radioBut" type="radio" name="seatType1" value="aisleSeat"/>靠过道
							</label>
						</div>
					</div>
					<div class="bf_item_subtotalArea">
						<div class="bf_item_delete clearfix">
							<span onclick="deleteItem(this)">删除</span>
							<img src="images/close_icon.png" onclick="deleteItem(this)">
						</div>
						<div class="bf_item_subtotal">
							<c:forEach items="${flightInfoList}" var="flightInfo">
								<span>￥
									<fmt:formatNumber type="number" groupingUsed="false" value="${flightInfo.fare}" />
								</span>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>

			<!-- other form_item -->
			

			<div>
				<button class="b_form_addItem" type="button" onclick="addItem()">+ 添加乘客</button>
			</div>

			<div class="b_form_mainPassenger">
				<span class="b_form_title">联系人</span>

				<div class="bf_passenger_info clearfix">
					<div class="bfp_info_text">
						<span>姓&nbsp;&nbsp;名：</span>
							<div>
								<input type="text" name="contact" onfocus="textOnFocus(this)" onblur="textOnBlur(this)">
							</div>
						</div>
						<div class="bfp_info_text">
							<span>手机号：</span>
							<div>
								<input type="text" name="phone" onfocus="textOnFocus(this)" onblur="textOnBlur(this)">
							</div>
						</div>
					</div>
				</div>
			
			<c:forEach items="${flightInfoList}" var="flightInfo">
				<input type="hidden" name="flightInfoID" value="${flightInfo.id}">
			</c:forEach>
				
			<div>
				<input class="b_form_submit" type="submit" name="submitButton" value="提交订单">
			</div>
		</form>

		<div class="b_order">
		
			<c:set var="totalFare" value="0"/>

			<div class="b_order_info">
				<c:forEach items="${flightInfoList}" var="flightInfo">
					<div class="bo_info_item">
						<div class="bo_info_flightArea">
							<span class="bo_info_num"></span>
								<span class="bo_info_date">
									<fmt:formatDate value="${flightInfo.depatureDate}" type="both" pattern="MM-dd"/>
								</span>
							<span class="bo_info_city">${flightInfo.depatureAirportCity}</span>
							<img class="bo_info_arrow" src="images/info_arrow_icon.png">
							<span class="bo_info_city">${flightInfo.arrivalAirportCity}</span>
						</div>
						<div class="bo_info_airlineArea">
							<span class="bo_info_airline">${flightInfo.airlineName} ${flightInfo.airlineCode}${flightInfo.number}</span>
							<span class="bo_info_plane">${flightInfo.airplaneName}</span>
						</div>
						<div class="bo_info_timeArea clearfix">
							<span class="bo_info_time">
								<fmt:formatDate value="${flightInfo.depatureTime}" type="both" pattern="HH:mm"/>
							</span>
							<img src="images/info_costTime_icon.png">
							<span class="bo_info_costTime"></span>
							<span class="bo_info_time">
								<fmt:formatDate value="${flightInfo.arrivalTime}" type="both" pattern="HH:mm"/>
							</span>
						</div>
						<div class="bo_info_airportArea">
							<span class="bo_info_airport">${flightInfo.depatureAirportName}</span>
							<img class="bo_info_timeline" src="images/info_timeline_icon.png">
							<span class="bo_info_airport">${flightInfo.arrivalAirportName}</span>
						</div>
					</div>
				</c:forEach>
			</div>

			<div class="b_order_detail">
				<c:forEach items="${flightInfoList}" var="flightInfo">
					<div class="bo_detail_item">
						<div class="bo_detail_subtotal clearfix">
							<span class="bo_detail_title">机票</span>
							<span class="bo_detail_value">￥
								<span class="bo_detail_fare">
									<fmt:formatNumber type="number" groupingUsed="false" value="${flightInfo.fare}" />
									<c:set var="totalFare" value="${totalFare + flightInfo.fare}"/>
								</span> 
								 &times;
								<span class="bo_detail_num">1</span>
							</span>
						</div>
					</div>
				</c:forEach>
			</div>
			
			<div class="b_order_cost">
				￥
				<span id="o_totalFare">
					<fmt:formatNumber type="number" groupingUsed="false" value="${totalFare}" />
				</span>
			</div>
		</div>
	</div>

	<!-- form_item template; display none -->
	<div id="b_formItem">
		<div class="b_form_item clearfix">
			<div class="bf_item_idArea">
				<span class="bf_item_id">${num}</span>
			</div>
				
			<div class="bf_item_textArea">
				<div class="bf_item_text clearfix">
					<span>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</span>
					<div>
						<input type="text" name="name" onfocus="textOnFocus(this)" onblur="textOnBlur(this)">
					</div>
				</div>
				<div class="bf_item_text clearfix">
					<span>护&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;照：</span>
					<div>
						<input type="text" name="passport" onfocus="textOnFocus(this)" onblur="textOnBlur(this)">
					</div>
				</div>
				<div class="bf_item_seatType">
					<span>座位偏好：</span>
	
					<label>
						<input class="bf_item_radioBut" type="radio" checked="checked" name="seatType1" value="default" id="b_seat_default" />默认
					</label>
					
					<label>
						<input class="bf_item_radioBut" type="radio" name="seatType1" value="windowSeat" id="b_seat_widnow" />靠窗
					</label>
					
					<label>
						<input class="bf_item_radioBut" type="radio" name="seatType1" value="middleSeat" id="b_seat_middle" />中间
					</label>
					
					<label>
						<input class="bf_item_radioBut" type="radio" name="seatType1" value="aisleSeat" id="b_seat_aisle" />靠过道
					</label>
				</div>
			</div>
			<div class="bf_item_subtotalArea">
				<div class="bf_item_delete clearfix">
					<span onclick="deleteItem(this)">删除</span>
					<img src="images/close_icon.png" onclick="deleteItem(this)">
				</div>
				<div class="bf_item_subtotal">
					<c:forEach items="${flightInfoList}" var="flightInfo">
						<span>￥
							<fmt:formatNumber type="number" groupingUsed="false" value="${flightInfo.fare}" />
						</span>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
