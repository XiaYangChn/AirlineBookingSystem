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
	<title>ABS_GenerateOrder</title>

	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<base href="<%=basePath%>">
	<link rel="SHORTCUT ICON" href="<%=path %>/images/airplane.icon"/>
	
	<link rel="stylesheet" href="<%=path %>/css/cube.css">
	<link rel="SHORTCUT ICON" href="<%=path %>/images/airplane.icon"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/absBase.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/generateOrder.css">
	<script type="text/javascript" src="<%=path %>/js/generateOrder.js"></script>
</head>
<body>
	<div class="abs_container clearfix g_container">
		<div class="g_order clearfix">
			<div class="g_title">
				<span>订单信息</span>
			</div>

			<div class="g_content">
				<div class="g_order_info">
					<div class="go_info_detail">
						<div class="go_info_title">
							<span>订单状态</span>
							<span>订单号</span>
							<span>预定日期</span>
							<span>预定方式</span>
							<span>支付方式</span>
						</div>
						<div class="go_info_value">
							<span class="go_info_styleBlod">已出票</span>
							<span class="go_info_styleBlod">${order.id}</span>
							<span>
								<fmt:formatDate value="${order.createDate}" type="both" pattern="yyyy-MM-dd"/>&nbsp;
								<fmt:formatDate value="${order.createTime}" type="both" pattern="HH:mm:ss"/>
							</span>
							<span>网上预定</span>
							<span>支付宝</span>
						</div>
					</div>
					<div class="go_info_total">
						<span>总金额</span>
						<em>￥</em>
						<span>
							<fmt:formatNumber type="number" groupingUsed="false" value="${order.totalFare}" />
						</span>
					</div>
				</div>
			</div>

			<div class="g_extend">
				<button class="go_extend_but" type="button">打印订单</button>
				<button class="go_extend_but go_eb_cancel" type="button">取消订单</button>
			</div>
		</div>

		<div class="g_flight clearfix">
			<div class="g_title">
				<span>航班</span>
			</div>

			<div class="g_content">
				<div class="g_flight_info">
				
					<c:set var="count" value="0"/>
						<c:forEach items="${flightInfoList}" var="flightInfo">
						<c:set var="count" value="${count + 1}"/>
					</c:forEach>
				
					<c:forEach items="${flightInfoList}" var="flightInfo" varStatus="currentStatus">
							<c:if test="${currentStatus.count == 1}">
								<div class="gf_info_title">
									<c:if test="${count <=1}">
										<span>单程</span>
									</c:if>
									<c:if test="${count > 1}">
										<span>转机</span>
									</c:if>
								</div>
								
							</c:if>
							
							<c:if test="${currentStatus.count != 1}">
								<div class="gf_info_title">
									<span></span>
								</div>
							</c:if>
						
							
		
							<div class="gf_info_value">
								<div class="gf_info_item">
									<div class="gf_info_main">
										<span>
											<fmt:formatDate value="${flightInfo.depatureDate}" type="both" pattern="yyyy-MM-dd"/>
										</span>
										<span>${flightInfo.depatureAirportCity}—${flightInfo.arrivalAirportCity}</span>
									</div>
		
									<div class="gf_info_detail">
										<div class="gf_info_airline">
											<span>${flightInfo.airlineName}</span>
											<span>${flightInfo.airlineCode}${flightInfo.number}</span>
											<span>${flightInfo.airplaneName}</span>
										</div>
										
										<div class="gf_info_time">
											<div class="gf_info_depart">
												<span class="gfi_time">
													<fmt:formatDate value="${flightInfo.depatureTime}" type="both" pattern="HH:mm"/>
												</span>
												<span>${flightInfo.depatureAirportName}</span>
											</div>
											<img src="images/result_arrow.png">
											<div class="gf_info_arrive">
												<span class="gfi_time">
													<fmt:formatDate value="${flightInfo.arrivalTime}" type="both" pattern="HH:mm"/>
												</span>
												<span>${flightInfo.arrivalAirportName}</span>
											</div>
											<div class="gf_info_costTime">
												<img src="images/g_costTime_icon.png">
												<span class="gfi_costTime"></span>
											</div>
										</div>
									</div>
								</div>
							</div>
					</c:forEach>
				</div>
			</div>

			<div class="g_extend"></div>
		</div>

		<div class="g_passenger clearfix">
			<div class="g_title">
				<span>乘机人</span>
			</div>

			<div class="g_content">
				<div class="g_passenger_info">
					<c:forEach items="${passengers}" var="passenger" varStatus="currentStatus">
						<div class="gp_info_item">
							<div class="gp_info_num">
								<span>${currentStatus.count}</span>
							</div>
	
							<div class="gp_info_title">
								<span>姓名</span>
								<span>证件信息</span>
							</div>
							<div class="gp_info_value">
								<span>${passenger.name}</span>
								<span>护照&nbsp;&nbsp;${passenger.passport}</span>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>

			<div class="g_extend"></div>
		</div>
		
		<div class="g_contact clearfix">
			<div class="g_title">
				<span>联系人</span>
			</div>

			<div class="g_content">
				<div class="g_passenger_info">
					<div class="g_contact_left">
					</div>
					<div class="gp_contact_item">
						<div class="gp_info_title">
							<span>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名</span>
							<span>联系方式</span>
						</div>
						<div class="gp_info_value">
							<span>${order.contactName}</span>
							<span>${order.contactPhone}</span>
						</div>
					</div>

				</div>
			</div>

			<div class="g_extend"></div>
		</div>
		
	</div>
</body>
</html>