
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<div class="row">
		<c:if test="${not empty message}">
			<div class="col-xs-12">
				<div class="alert alert-success alert-dismissible">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${message}
				</div>
			</div>
		</c:if>
		<div class="col-md-offset-2 col-md-8">
			<div class="panel panel-primary">
				<h4>Product Management</h4>
			</div>
			<div class="panel-body">

				<!-- Form Elements -->
				<sf:form class="form-horizontal" modelAttribute="product"
					action="${contextRoot}/manage/products" method="POST"
					enctype="multipart/form-data">

					<div class="form-group">
						<label class="control-label col-md-4" for="name">Enter
							name:</label>
						<div class="col-md-8">
							<sf:input type="text" path="name" id="name"
								placeholder="Product Name" class="form-control" />
							<sf:errors path="name" cssClass="help-block" element="em" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-4" for="brand">Enter
							Brand Name:</label>
						<div class="col-md-8">
							<sf:input type="text" path="brand" id="brand"
								placeholder="Brand Name" class="form-control" />
							<sf:errors path="brand" cssClass="help-block" element="em" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-4">Description</label>
						<div class="col-md-8">
							<sf:textarea path="description" class="form-control"
								placeholder="Enter your description here!" />
							<sf:errors path="description" cssClass="help-block" element="em" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-4">Unit Price</label>
						<div class="col-md-8">
							<sf:input type="number" path="unitPrice" class="form-control"
								placeholder="Enter Unit Price" />
							<sf:errors path="unitPrice" cssClass="help-block" element="em" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-4">Quantity</label>
						<div class="col-md-8">
							<sf:input type="number" path="quantity" class="form-control"
								placeholder="Enter Quantity" />
							<sf:errors path="quantity" cssClass="help-block" element="em" />
						</div>
					</div>

					<!-- File element for image -->
					<div class="form-group">
						<label class="control-label col-md-4">Upload a file</label>
						<div class="col-md-8">
							<sf:input type="file" path="file" class="form-control" />
							<sf:errors path="file" cssClass="help-block" element="em" />
						</div>
					</div>


					<div class="form-group">
						<label class="control-label col-md-4">Category</label>
						<div class="col-md-8">
							<sf:select path="categoryId" items="${categories}"
								itemLabel="name" itemValue="id" class="form-control" />
							<c:if test="${product.id==0}">
								<div class="text-right">
									<br />
									<button type="button" data-toggle="modal"
										data-target="#myCategoryModal" class="btn btn-warning btn-xs">Add
										Category</button>
								</div>

							</c:if>

							<div class="text-right">
								<br />
								<sf:hidden path="id" />
								<sf:hidden path="code" />
								<sf:hidden path="supplierId" />
								<sf:hidden path="active" />

							</div>
						</div>

					</div>

					<div class="form-group">

						<div class="col-md-offset-4 col-md-8">
							<input type="submit" name="submit" id="submit" value="Submit"
								class="btn btn-primary">

						</div>
					</div>

				</sf:form>
			</div>
		</div>
	</div>

	<div class="row">

		<div class='col-xs-12'>
			<div class="container-fluid">
				<div class="table-responsive">


					<h3>Available Products</h3>
					<hr />

					<table id="adminProductsTable"
						class="table table-striped table-bordered">

						<thead>
							<tr>
								<th>Id</th>
								<th>&#160;</th>
								<th>Name</th>
								<th>Brand</th>
								<th>Qty. Avail</th>
								<th>Unit Price</th>
								<th>Activate</th>
								<th>Edit</th>
							</tr>
						</thead>

						<tbody>
							<tr>
								<td>4</td>
								<td><img class="adminDataTableImg"
									src="${contextRoot}/resources/images/PRD310B81A51D.jpg"
									alt="Macbook Pro" /></td>
								<td>Macbook Pro</td>
								<td>3</td>
								<td>Nrs</td>
								<td>54000</td>
								<td><label class="switch"> <input type="checkbox"
										checked="checked" value="4" /> <span class="slider round"></span>
								</label></td>
								<td><a href="${contextRoot}/manage/4/product"
									class="btn btn-warning">Edit</a></td>

							</tr>

						</tbody>

						<tfoot>
							<tr>
								<th>Id</th>
								<th>&#160;</th>
								<th>Name</th>
								<th>Brand</th>
								<th>Qty. Avail</th>
								<th>Unit Price</th>
								<th>Activate</th>
								<th>Edit</th>
							</tr>
						</tfoot>


					</table>
				</div>
			</div>

		</div>
	</div>

	<div class="modal fade" id="myCategoryModal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<!-- modal header -->
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">Add New Category</h4>
				</div>
				<!-- modal body -->
				<div class="modal-body">
					<!-- category form -->
					<sf:form id="categoryForm" modelAttribute="category"
						action="${contextRoot}/manage/category" method="POST"
						class="form-horizontal">
						<div class="form-group">
							<label for="name" class="control-label col-md-4">Category
								Name</label>
							<div class="col-md-8">
								<sf:input type="text" path="name" id="category_name"
									class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="description" class="control-label col-md-4">Category
								Description</label>
							<div class="col-md-8">
								<sf:textarea cols="10" rows="5" path="description"
									id="category_description" class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="description" class="control-label col-md-4">Category
								Description</label>
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" value="Add Category"
									class="btn btn-primary" />
							</div>
						</div>

					</sf:form>
				</div>
			</div>
		</div>
	</div>