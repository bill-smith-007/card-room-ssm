<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="itheima" uri="http://itheima.com/common/"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() 
	                   + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>客户管理-BootCRM</title>
	<!-- 引入css样式文件 -->
	<!-- Bootstrap Core CSS -->
	<link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet" />
	<!-- MetisMenu CSS -->
	<link href="<%=basePath%>css/metisMenu.min.css" rel="stylesheet" />
	<!-- DataTables CSS -->
	<link href="<%=basePath%>css/dataTables.bootstrap.css" rel="stylesheet" />
	<!-- Custom CSS -->
	<link href="<%=basePath%>css/sb-admin-2.css" rel="stylesheet" />
	<!-- Custom Fonts -->
	<link href="<%=basePath%>css/font-awesome.min.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/boot-crm.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="wrapper">
  <!-- 导航栏部分 -->
  <nav class="navbar navbar-default navbar-static-top" role="navigation"
		 style="margin-bottom: 0">
	<div class="navbar-header">
		<a class="navbar-brand" href="<%=basePath%>customer/list.action">BOOT客户管理系统 v2.0</a>
	</div>
	<%@ include file="nav.jsp" %>
  </nav>
    <!-- 客户列表查询部分  start-->
	<div id="page-wrapper">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">订单管理</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
		<div class="panel panel-default">
			<div class="panel-body">
				<form class="form-inline" method="get" 
				      action="${pageContext.request.contextPath }/book/list.action">
					<div class="form-group">
						<label for="staffName">用户id</label> 
						<input type="text" class="form-control" id="staffName" 
						                   value="${Q_id }" name="q_id" />
					</div>
					
					
					<button type="submit" class="btn btn-primary">查询</button>
				</form>
			</div>
		</div>
	
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">订单信息列表</div>
					<!-- /.panel-heading -->
					<table class="table table-bordered table-striped">
						<thead>
							<tr>
								<th>用户id</th>
								<th>房间id</th>
								<th>使用时长</th>
								<th>开始时间</th>
								<th>创建时间</th>
								
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${page.rows}" var="row">
								<tr>
									<td>${row.q_id}</td>
									<td>${row.r_id}</td>
									<td>${row.b_take}</td>
									<td>${row.timeStr}</td>
									<td>${row.createStr}</td>
									
									<td>
										<a href="#" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#bookEditDialog" onclick= "editBook('${row.q_id}','${row.r_id}')">修改</a>
										<a href="#" class="btn btn-danger btn-xs" onclick="deleteBook('${row.q_id}','${row.r_id}')">删除</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="col-md-12 text-right">
						<itheima:page url="${pageContext.request.contextPath }/book/list.action" />
					</div>
					<!-- /.panel-body -->
				</div>
				<!-- /.panel -->
			</div>
			<!-- /.col-lg-12 -->
		</div>
	</div>
	<!-- 订单列表查询部分  end-->
</div>
<!-- 创建订单模态框 -->

<!-- 修改订单模态框 -->
<div class="modal fade" id="bookEditDialog" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">修改订单信息</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" id="edit_book_form">
					<input type="hidden" id="edit_book_id" name="id"/>
					
					<div class="form-group">
						<label for="edit_q_id" class="col-sm-2 control-label">
						    用户id
						</label>
						<div class="col-sm-10">
							<input type="number" class="form-control" id="edit_q_id" placeholder="用户id" name="Q_id" />
						</div>
					</div>
					<div class="form-group">
						<label for="edit_r_id" style="float:left;padding:7px 15px 0 27px;">房间id</label> 
						<div class="col-sm-10">
							<input type="number" class="form-control" id="edit_r_id" placeholder="房间id" name="R_id" />
						</div>
					</div>
					<div class="form-group">
						<label for="edit_b_take" style="float:left;padding:7px 15px 0 27px;">使用时长</label> 
						<div class="col-sm-10">
							<input type="number" class="form-control" id="edit_b_take" placeholder="房间使用时长" name="B_take" />
						</div>
					</div>
					<div class="form-group">
						<label  class="col-sm-2 control-label">使用日期</label>
						<div class="col-sm-10">
							 <input type="date" id="edit_b_time" class="form-control"  name="B_time">
						</div>
					</div>
					
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<button type="button" class="btn btn-primary" onclick="updateBook()">保存修改</button>
			</div>
		</div>
	</div>
</div>
<!-- 引入js文件 -->
<!-- jQuery -->
<script src="<%=basePath%>js/jquery-1.11.3.min.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="<%=basePath%>js/bootstrap.min.js"></script>
<!-- Metis Menu Plugin JavaScript -->
<script src="<%=basePath%>js/metisMenu.min.js"></script>
<!-- DataTables JavaScript -->
<script src="<%=basePath%>js/jquery.dataTables.min.js"></script>
<script src="<%=basePath%>js/dataTables.bootstrap.min.js"></script>
<!-- Custom Theme JavaScript -->
<script src="<%=basePath%>js/sb-admin-2.js"></script>
<!-- 编写js代码 -->
<script type="text/javascript">
//清空新建订单窗口中的数据
	
	// 通过id获取修改的订单信息
	function editBook(q_id,r_id) {
	    $.ajax({
	        type:"get",
	        url:"<%=basePath%>book/getBookById.action",
	        data:{'Q_id':q_id,
				'R_id':r_id},
	        success:function(data) {
	            $("#edit_q_id").val(data.q_id);
	            $("#edit_r_id").val(data.r_id);
	            $("#edit_b_take").val(data.b_take)
	            $("#edit_b_time").val(data.timeStr)
	           
	        }
	    });
	}
    // 执行修改订单操作
	function updateBook() {
		if($("#edit_q_id").val()==""){
			alert("姓名必须输入!");
			$("#edit_q_id").focus();
			return;
		}
		if($("#edit_r_id").val()==""){
			alert("工号必须输入!");
			$("#edit_r_id").focus();
			return;
		}
		if($("#edit_b_take").val()==""){
			alert("出生年份必须输入!");
			$("#edit_b_take").focus();
			return;
		}
		if($("#edit_b_time").val()==""){
			alert("简历必须输入!");
			$("#edit_b_time").focus();
			return;
		}
		
		$.post("<%=basePath%>book/update.action",$("#edit_book_form").serialize(),function(data){
			if(data =="OK"){
				alert("订单信息更新成功！");
				window.location.reload();
			}else{
				alert("订单信息更新失败！");
				window.location.reload();
			}
		});
	}
	// 删除订单
	function deleteBook(q_id,r_id) {
	    if(confirm('确实要删除该订单吗?')) {
	$.post("<%=basePath%>book/delete.action",{'Q_id':q_id,'R_id':r_id},
	function(data){
	            if(data =="OK"){
	                alert("订单删除成功！");
	                window.location.reload();
	            }else{
	                alert("订单客户失败！");
	                window.location.reload();
	            }
	        });
	    }
	}
</script>
</body>
</html>