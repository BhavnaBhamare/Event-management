<%@ include file="AdminHeader.jsp"%>

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
	<!--/.row-->



	<div class="row">
		<div class="col-md-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<b>Add Event</b>
				</div>
				<div class="panel-body">
					<form class="form-horizontal" action="AddEventServlet"
						method="post" enctype="multipart/form-data">
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
							<!-- Name input-->
							<div class="form-group">
								<label class="col-md-3 control-label" for="name">Event
									Name</label>
								<div class="col-md-6">
									<input id="name" name="ename" type="text"
										placeholder="function/private" class="form-control">
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-3 control-label" for="name">Cost</label>
								<div class="col-md-6">
									<input id="name" name="cost" type="text" placeholder="20,000/-"
										class="form-control">
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-3 control-label" for="name">Facility</label>
								<div class="col-md-6">
									<input id="name" name="facility" type="text"
										placeholder="Facility" class="form-control">
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-3 control-label" for="name">Event
									Image</label>
								<div class="col-md-6">
									<input id="name" name="eimage" type="file" class="form-control">
								</div>
							</div>

							<!-- Form actions -->
							<div class="col-sm-04"></div>
							<div class="col-sm-04">
								<div class="form-group">
									<div class="col-md-6 widget-right">
										<button type="submit"
											class="btn btn-default btn-md pull-right">Add Event</button>
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