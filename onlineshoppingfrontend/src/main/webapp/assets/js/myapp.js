$(function() {
	// solving the active menu problem
	switch (menu) {
	case 'Home':
		$('#home').addClass('active');
		break;
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	default:
		if (menu == "Home")
			break;
		$('#listProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;
	}

	// code for jquery data table
	// create dataset

	var $table = $('#productListTable');

	// execute the below code where we have this table

	if ($table.length) {
		// console.log('inside the table');
		var jsonUrl = '';
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/products';
		}

		$table.DataTable({
			lengthMenu : [ [ 3, 5, 10, -1 ],
					[ '3 records', '5 records', '10 records', 'ALL' ] ],
			pageLength : 5,
			ajax : {
				url : jsonUrl,
				dataSrc : ''
			},
			columns : [
				{
					data:'code',
					bSortable:false,
					mRender:function(data,type,row){
						return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" width="100" height="100"/>';
					}
				},
				{
					data : 'name'
				},
				{
					data : 'brand'
				},
				{
					data : 'unitPrice',
					mRender:function(data,type,row){
						return 'NRs: '+data
					}
					
				},
				{
					data : 'quantity'
				},
				{
					data:'id',
					bSortable:false,
					mRender:function(data,type,row){
						var str='';
						str+= '<a href="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-primary"><span class="oi oi-eye"></span></a> &#160;';
						str+= '<a href="'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-success"><span class="oi oi-cart"></span></a>';
						return str;
					}
				}
			]
		});
	}

});