<%@ include file="UserHeader.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
	<div class="row">
		<ol class="breadcrumb">
			<li><a href="#"><svg class="glyph stroked home">
						<use xlink:href="#stroked-home"></use></svg></a></li>
			<li class="active">Home</li>
		</ol>
	</div>
	<!--/.row-->

	<div class="row" style="padding-top: 20px;">
		<div class="col-lg-12">
			<!-- <h1 class="page-header">Widgets</h1> -->
		</div>
	</div>


	<div class="row">
		<div class="col-md-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<b>Add Event</b>
				</div>
				<div class="panel-body">
					<form class="form-horizontal" action="SearchEventServlet"
						method="post">
						<fieldset>

							<!-- Name input-->
							<div class="form-group">
								<label class="col-md-3 control-label" for="name">Choose Event
									Type</label>
								<div class="col-md-4">
									<select name="etype" class="form-control">
										<option>Hall Booking</option>
										<option>BirthDay</option>
										<option>Marriage</option>
										<option>Party</option>
									</select>
								</div>
							</div>
							
							<div class="col-sm-04">
								<div class="form-group">
									<div class="col-md-6 widget-right">
										<button type="submit"
											class="btn btn-default btn-md pull-right">Search Event</button>
									</div>
								</div>
							</div>

						</fieldset>
					</form>
				</div>
			</div>
		</div>

<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">View Event Here</div>
				<div class="panel-body">
					<table data-toggle="table" data-url="tables/data1.json"
						data-show-refresh="true" data-show-toggle="true"
						data-show-columns="true" data-search="true"
						data-select-item-name="toolbar1" data-pagination="true"
						data-sort-name="name" data-sort-order="desc">
						<thead>
							<tr>
								<th data-field="state" data-checkbox="true">Sr.No</th>
							
								<th data-field="id7" data-sortable="true">Event Image</th>
								<th data-field="id2" data-sortable="true">Event type</th>
								<th data-field="id3" data-sortable="true">Cost</th>
								<th data-field="id4" data-sortable="true">Facility</th>
								<th data-field="id5" data-sortable="true">Book Now</th>
								
								
								
							</tr>
							
							
						</thead>
						<c:forEach items="${sessionScope.ename}" var="l">
						<tr>
						<td data-field="id" data-sortable="true"><c:out value="${l.eid} " /></td>
						<td data-field="id7" data-sortable="true"><img alt="" src="eimage/${l.eventimage}" width="80" height="80">  </td>
						<td data-field="id2" data-sortable="true"><c:out value="${l.eventtype} " /></td>
						<td data-field="id3" data-sortable="true"><c:out value="${l.cost} " /></td>	
						<td data-field="id4" data-sortable="true"><c:out value="${l.facility} " /></td>
						<td data-field="id5" data-sortable="true"><a href="BookNow.jsp?eid=${l.eid}" style="color: #30a5ff;" >Book Now</a></td>
						
						
						</tr>
							
						
					</c:forEach>
						
						
					</table>
				</div>
			</div>
		</div>
	</div>

	</div>
	<!--/.row-->
</div>
<!--/.main-->