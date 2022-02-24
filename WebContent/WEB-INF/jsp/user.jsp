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
	<title>用户管理-BootCRM</title>
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
		<a class="navbar-brand" href="<%=basePath%>customer/list.action">BOOT用户管理系统 v2.0</a>
	</div>
  <%@ include file="nav.jsp" %>
   </nav> 
    <!-- 用户列表查询部分  start-->
	<div id="page-wrapper">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">用户管理</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
		<div class="panel panel-default">
			<div class="panel-body">
				<form class="form-inline" method="get" 
				      action="${pageContext.request.contextPath }/user/list.action">
					<div class="form-group">
						<label for="customerName">用户名称</label> 
						<input type="text" class="form-control" id="customerName" 
						                   value="${Q_nickname }" name="Q_nickname" />
					</div>
					<div class="form-group">
						<label for="customerFrom">用户来源</label> 
						<select	class="form-control" id="Q_root" name="Q_root">
							<option value="" ${Q_root==""?"selected":""}>--请选择--</option>
								<option value="0" ${Q_root==""?"":Q_root==0?"selected":""}>用户</option>
								<option value="1" ${Q_root==""?"":Q_root==1?"selected":""}>管理员</option>
						</select>
					</div>
					
					<button type="submit" class="btn btn-primary">查询</button>
				</form>
			</div>
		</div>
		<a href="#" class="btn btn-primary" data-toggle="modal" 
		           data-target="#newCustomerDialog" onclick="clearCustomer()">新建</a>
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">用户信息列表</div>
					<!-- /.panel-heading -->
					<table class="table table-bordered table-striped">
						<thead>
							<tr>
								<th>用户id</th>
								<th>用户名称</th>
								<th>用户密码</th>
								<th>用户所属级别</th>
								<th>用户自我介绍</th>
								<th>用户性别</th>
								<th>用户手机</th>
								<th>用户创建时间</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${page.rows}" var="row">
								<tr>
									<td>${row.id}</td>
									<td>${row.nickname}</td>
									<td>${row.password}</td>
									<td>${row.rootStr}</td>
									<td>${row.introduce}</td>
									<td>${row.sexStr}</td>
								    <td>${row.phone}</td>
								    <td>${row.dataStr}</td>
									<td>
										<a href="#" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#customerEditDialog" onclick= "editCustomer(${row.id})">修改</a>
										<a href="#" class="btn btn-danger btn-xs" onclick="deleteUser(${row.id})">删除</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="col-md-12 text-right">
						<itheima:page url="${pageContext.request.contextPath }/user/list.action" />
					</div>
					<!-- /.panel-body -->
				</div>
				<!-- /.panel -->
			</div>
			<!-- /.col-lg-12 -->
		</div>
	</div>
	<!-- 用户列表查询部分  end-->
</div>
<!-- 创建用户模态框 -->
<div class="modal fade" id="newCustomerDialog" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">新建用户信息</h4>
			</div>
			<div class="modal-body">
				<form id="new_customer_form" class="form-horizontal">
						  <div class="form-group">
						    <label  class="col-sm-2 control-label">昵称</label>
						    <div class="col-sm-10">
						      <input type="text" id="new_nickname" class="form-control" placeholder="昵称" name="Q_nickname">
						    </div>
						  </div>
						  <div class="form-group">
						    <label  class="col-sm-2 control-label">密码</label>
						    <div class="col-sm-10">
						      <input type="text" id="new_pwd" class="form-control"  placeholder="密码" name="Q_pwd">
						    </div>
						  </div>
						 <div class="form-group">
						    <label  class="col-sm-2 control-label">用户权限</label>
						    <div class="col-sm-10">
						      	<label class="radio-inline">
								  <input type="radio" name="Q_root" value="0" checked> 用户
								</label>
								<label class="radio-inline">
								  <input type="radio" name="Q_root" value="1"> 管理员
								</label>
						    </div>
						  </div>
						  <div class="form-group">
						    <label  class="col-sm-2 control-label">性别</label>
						    <div class="col-sm-10">
						      	<label class="radio-inline">
								  <input type="radio" name="Q_sex" value="0" checked> 男
								</label>
								<label class="radio-inline">
								  <input type="radio" name="Q_sex" value="1"> 女
								</label>
						    </div>
						  </div>
						  <div class="form-group">
						    <label  class="col-sm-2 control-label" >电话</label>
						    <div class="col-sm-10">
						      <input type="number" id="new_phone" class="form-control" placeholder="电话" name="Q_phone">
						    </div>
						  </div>
						  <div class="form-group">
						    <label  class="col-sm-2 control-label">介绍</label>
						    <div class="col-sm-10">
						      <textarea class="form-control" id="new_introduce" rows="3" name="Q_introduce"></textarea> 
						    </div>
						  </div>
						  <div class="form-group">
						    <label  class="col-sm-2 control-label">日期</label>
						    <div class="col-sm-10">
						      <input type="date" class="form-control" id="new_data"  name="Q_data">
						       <input type="hidden" name="id">
						    </div>
						  </div>
						</form>
				        
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<button type="button" class="btn btn-primary" onclick="createUser()">创建用户</button>
			</div>
		</div>
	</div>
</div>
<!-- 修改用户模态框 -->
<div class="modal fade" id="customerEditDialog" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">修改用户信息</h4>
			</div>
			<div class="modal-body">
				<form id="edit_customer_form" class="form-horizontal">
										  <div class="form-group">
										    <label  class="col-sm-2 control-label">昵称</label>
										    <div class="col-sm-10">
										      <input type="text" class="form-control" placeholder="昵称" id="edit_nickname" name="Q_nickname">
										    </div>
										  </div>
										  <div class="form-group">
										    <label  class="col-sm-2 control-label">密码</label>
										    <div class="col-sm-10">
										      <input type="text" class="form-control"  id="edit_pwd" placeholder="密码" name="Q_pwd">
										    </div>
										  </div>
										 <div class="form-group">
										    <label   class="col-sm-2 control-label">用户权限</label>
										    <div class="col-sm-10" id="edit_root">
										      	<label class="radio-inline">
												  <input type="radio" name="Q_root" id="edit_userRoot0" value="0" > 用户
												</label>
												<label class="radio-inline">
												  <input type="radio" name="Q_root" id="edit_userRoot1" value="1" > 管理员
												</label>
										    </div>
										  </div>
										  <div class="form-group">
										    <label  class="col-sm-2 control-label">性别</label>
										    <div class="col-sm-10" id="edit_sex">
										      	<label class="radio-inline">
												  <input type="radio" id="edit_userSex0" name="Q_sex" value="0" > 男
												</label>
												<label class="radio-inline">
												  <input type="radio" name="Q_sex" id="edit_userSex1" value="1"> 女
												</label>
										    </div>
										  </div>
										  <div class="form-group">
										    <label  class="col-sm-2 control-label" >电话</label>
										    <div class="col-sm-10">
										      <input type="number" class="form-control" placeholder="电话" id="edit_phone" name="Q_phone">
										    </div>
										  </div>
										  <div class="form-group">
										    <label  class="col-sm-2 control-label">介绍</label>
										    <div class="col-sm-10">
										      <textarea class="form-control" rows="3"  id="edit_introduce" name="Q_introduce"></textarea> 
										    </div>
										  </div>
										  <div class="form-group">
										    <label  class="col-sm-2 control-label">日期</label>
										    <div class="col-sm-10">
										      <input type="date" class="form-control" id="edit_data"  name="Q_data">
										       <input type="hidden" id="edit_id" name="id"/>
										    </div>
										  </div>
										</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<button type="button" class="btn btn-primary" onclick="updateCustomer()">保存修改</button>
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
//清空新建用户窗口中的数据
	function clearCustomer() {
	    $("#new_nickname").val("");
	    $("#new_pwd").val("")
	    $("#new_phone").val("")
	    $("#new_introduce").val("")
	    $("#new_data").val("");
	   
	}
	// 创建用户
	function createUser() {
	$.post("<%=basePath%>user/create.action",
	$("#new_customer_form").serialize(),function(data){
		
	        if(data =="OK"){
	            alert("用户创建成功！");
	            window.location.reload();
	        }else{
	            alert("用户创建失败！");
	            window.location.reload();
	        }
	    });
	}
	// 通过id获取修改的用户信息
	function editCustomer(id) {
	    $.ajax({
	        type:"get",
	        url:"<%=basePath%>user/getUserById.action",
	        data:{"id":id},
	        success:function(data) {
	            $("#edit_nickname").val(data.nickname);
	            $("#edit_pwd").val(data.password);
	            $("#edit_phone").val(data.phone)
	            $("#edit_introduce").val(data.introduce)
	            $("#edit_data").val(data.dataStr)
				
				$("#edit_userRoot"+data.root).prop("checked",true);

	            $("#edit_userSex"+data.sex).prop("checked",true);
				
	            $("#edit_id").val(data.id)
	           
	        }
	    });
	}
    // 执行修改用户操作
	function updateCustomer() {
		$.post("<%=basePath%>user/update.action",$("#edit_customer_form").serialize(),function(data){
			if(data =="OK"){
				alert("用户信息更新成功！");
				window.location.reload();
			}else{
				alert("用户信息更新失败！");
				window.location.reload();
			}
		});
	}
	// 删除用户
	function deleteUser(id) {
	    if(confirm('确实要删除该用户吗?')) {
	$.post("<%=basePath%>user/delete.action",{"id":id},
	function(data){
	            if(data =="OK"){
	                alert("用户删除成功！");
	                window.location.reload();
	            }else{
	                alert("删除用户失败！");
	                window.location.reload();
	            }
	        });
	    }
	}
</script>
</body>
</html>