
<%@page import="com.pojo.Booking"%>
<%@page import="com.pojo.Addevent"%>
<%@include file="UserHeader.jsp"%>
<%@page import="com.pojo.Registration"%>
<%@page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.model.BLManager" %>



<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
	<div class="row">
		<ol class="breadcrumb">
			<li><a href="#"><svg class="glyph stroked home">
							<use xlink:href="#stroked-home"></use></svg></a></li>
			<li class="active">Home</li>
		</ol>
	</div>
	<!--/.row-->
	<br>
	<div class="row"></div>
	<!--/.row-->
<%
   String email=(String)session.getAttribute("email");
   BLManager bl=new BLManager();
   List<Booking> ae=bl.serachbookinglistuser(email);
   session.setAttribute("list1",ae);
%>

	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">View User Request</div>
				<div class="panel-body">
					<table data-toggle="table" data-url="tables/data1.json"
						data-show-refresh="true" data-show-toggle="true"
						data-show-columns="true" data-search="true"
						data-select-item-name="toolbar1" data-pagination="true"
						data-sort-name="name" data-sort-order="desc">
						<thead>
							<tr>
								<th data-field="state" data-checkbox="true">Sr.No</th>
							
								<th data-field="id1" data-sortable="true">Event Image</th>
								<th data-field="id2" data-sortable="true">Event Name</th>
								<th data-field="id3" data-sortable="true">User Name</th>
								<th data-field="id4" data-sortable="true">Book Time</th>
								<th data-field="id5" data-sortable="true">Booking Date</th>
								
								
							</tr>
							
							
						</thead>
						<c:forEach items="${sessionScope.list1}" var="l">
						<tr>
						<td data-field="id" data-sortable="true"><c:out value="${l.bid} " /></td>
						<td data-field="id1" data-sortable="true"><img alt="" src="eimage/${l.addevent.eventimage}" width="80" height="80">  </td>
						<td data-field="id2" data-sortable="true"><c:out value="${l.addevent.eventtype} " /></td>
						<td data-field="id3" data-sortable="true"><c:out value="${l.registration.fname} " /></td>
						<td data-field="id4" data-sortable="true"><c:out value="${l.bookingtime} " /></td>	
						<td data-field="id5" data-sortable="true"><c:out value="${l.bookingdate} " /></td>
						
						</tr>
							
						
					</c:forEach>
						
						
					</table>
				</div>
			</div>
		</div>
	</div>
	<!--/.row-->
	<div class="row">
		<div class="col-md-6">
			<div class="panel panel-default"></div>
		</div>
		<div class="col-md-6">
			<div class="panel panel-default">



				<script>
					$(function() {
						$('#hover, #striped, #condensed')
								.click(
										function() {
											var classes = 'table';

											if ($('#hover').prop('checked')) {
												classes += ' table-hover';
											}
											if ($('#condensed').prop('checked')) {
												classes += ' table-condensed';
											}
											$('#table-style')
													.bootstrapTable('destroy')
													.bootstrapTable(
															{
																classes : classes,
																striped : $(
																		'#striped')
																		.prop(
																				'checked')
															});
										});
					});

					function rowStyle(row, index) {
						var classes = [ 'active', 'success', 'info', 'warning',
								'danger' ];

						if (index % 2 === 0 && index / 2 < classes.length) {
							return {
								classes : classes[index / 2]
							};
						}
						return {};
					}
				</script>
			</div>
		</div>
	</div>
	<!--/.row-->


</div>
<!--/.main-->
</body>
</html>
