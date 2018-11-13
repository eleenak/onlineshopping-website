<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<spring:url var="css" value="/resources/css" />
<spring:url var="vendor" value="/resources/vendor" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Shopping-${title}</title>

<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
</script>

<!-- Bootstrap core CSS -->
<link href="${vendor}/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap Sandstone CSS -->
<link href="${css}/bootstrap-cerulean-theme.css" rel="stylesheet">

<!-- Bootstrap DataTables CSS -->
<link href="${css}/dataTables.bootstrap4.css" rel="stylesheet">

<link href="${css}/open-iconic/font/css/open-iconic-bootstrap.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/shop-homepage.css" rel="stylesheet">

</head>

<body>
	<div class="wrapper">
		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>


		<!-- Page Content -->
		<div class="content">
			<!-- loading the home content -->
			<c:if test="${userClickHome==true}">
				<%@include file="home.jsp"%>
			</c:if>

			<!-- loading the about content -->
			<c:if test="${userClickAbout==true}">
				<%@include file="about.jsp"%>
			</c:if>

			<!-- loading the contact content -->
			<c:if test="${userClickContact==true}">
				<%@include file="contact.jsp"%>
			</c:if>

			<!-- loading the list products content -->
			<c:if
				test="${userClickAllProducts==true or userClickCategoryProducts==true}">
				<%@include file="listProducts.jsp"%>
			</c:if>

			<!-- loading when user clicks show products-->
			<c:if test="${userClickShowProduct==true}">
				<%@include file="singleProduct.jsp"%>
			</c:if>
			
			<!-- loading when user clicks manage products-->
			<c:if test="${userClickManageProducts==true}">
				<%@include file="manageProducts.jsp"%>
			</c:if>
			
		</div>
		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>

		<!-- Bootstrap core JavaScript -->
		<script src="${vendor}/jquery/jquery.min.js"></script>
		<script src="${vendor}/bootstrap/js/bootstrap.bundle.min.js"></script>

		<!--DataTable Plugin-->
		<script src="${js}/jquery.dataTables.js"></script>

		<!--DataTable Bootstrap Script -->
		<script src="${js}/dataTables.bootstrap4.js"></script>
		
		<!--DataTable Bootstrap Script -->
		<script src="${js}/jquery.validate.js"></script>

		<!--DataTable Bootbox Script -->
		<script src="${js}/bootbox.min.js"></script>


		<!--  Self coded java script -->
		<script src="${js}/myapp.js"></script>
	</div>
</body>

</html>
