<%@ include file="UserHeader.jsp"%>

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
<%
   String eid=request.getParameter("eid");
   session.setAttribute("eid",eid);
%>

	<div class="row">
		<div class="col-md-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<b>Add Event</b>
				</div>
				<div class="panel-body">
					<form class="form-horizontal" action="BookNowServlet"
						method="post">
						<fieldset>

							<!-- Name input-->
						<div class="form-group">
								<label class="col-md-3 control-label" for="name">Booking
									Date</label>
								<div class="col-md-4">
									<input id="name" name="bdate" type="date"
										 class="form-control">
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-3 control-label" for="name">Booking Time</label>
								<div class="col-md-4">
									<input id="name" name="btime" type="text" placeholder="11.30PM"
										class="form-control">
								</div>
							</div>
							
							<div class="col-sm-04">
								<div class="form-group">
									<div class="col-md-4 widget-right">
										<button type="submit"
											class="btn btn-default btn-md pull-right">Confirm Booking</button>
									</div>
								</div>
							</div>

						</fieldset>
					</form>
				</div>
			</div>
		</div>



	</div>
	<!--/.row-->
</div>
<!--/.main-->