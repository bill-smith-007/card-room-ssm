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
				<h1 class="page-header">员工管理</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
		<div class="panel panel-default">
			<div class="panel-body">
				<form class="form-inline" method="get" 
				      action="${pageContext.request.contextPath }/staff/list.action">
					<div class="form-group">
						<label for="staffName">员工姓名</label> 
						<input type="text" class="form-control" id="staffName" 
						                   value="${name }" name="name" />
					</div>
					<div class="form-group">
						<label for="staffcode">员工工号</label> 
						<input type="text" class="form-control" id="staffcode" 
						                   value="${code }" name="code" />
					</div>
					<div class="form-group">
						<label for="custIndustry">员工部门</label> 
						<input type="text" class="form-control" id="staffcode" 
						                   value="${depart }" name="depart" />
					</div>
					
					<button type="submit" class="btn btn-primary">查询</button>
				</form>
			</div>
		</div>
		<a href="#" class="btn btn-primary" data-toggle="modal" 
		           data-target="#newsStaffDialog" onclick="clearStaff()">新建</a>
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">员工信息列表</div>
					<!-- /.panel-heading -->
					<table class="table table-bordered table-striped">
						<thead>
							<tr>
								<th>姓名</th>
								<th>工号</th>
								<th>性别</th>
								<th>出生年份</th>
								<th>简历</th>
								<th>入职日期</th>
								<th>部门</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${page.rows}" var="row">
								<tr>
									<td>${row.name}</td>
									<td>${row.code}</td>
									<td>${row.genderStr}</td>
									<td>${row.birthyear}</td>
									<td>${row.resume}</td>
									<td>${row.enrolldateStr}</td>
								    <td>${row.depart}</td>
									<td>
										<a href="#" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#staffEditDialog" onclick= "editStaff(${row.id})">修改</a>
										<a href="#" class="btn btn-danger btn-xs" onclick="deleteStaff(${row.id})">删除</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="col-md-12 text-right">
						<itheima:page url="${pageContext.request.contextPath }/staff/list.action" />
					</div>
					<!-- /.panel-body -->
				</div>
				<!-- /.panel -->
			</div>
			<!-- /.col-lg-12 -->
		</div>
	</div>
	<!-- 员工列表查询部分  end-->
</div>
<!-- 创建员工模态框 -->
<div class="modal fade" id="newsStaffDialog" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">新建员工信息</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" id="new_staff_form">
					<div class="form-group">
						<label for="new_staffName" class="col-sm-2 control-label">
						    员工姓名
						</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="new_staffName" placeholder="员工姓名" name="name" />
						</div>
					</div>
					<div class="form-group">
						<label for="new_staffCode" style="float:left;padding:7px 15px 0 27px;">员工工号</label> 
						<div class="col-sm-10">
							<input type="text" class="form-control" id="new_staffCode" placeholder="员工工号" name="code" />
						</div>
					</div>
					<div class="form-group">
						<label style="float:left;padding:7px 15px 0 27px;">员工性别</label>
						<div class="col-sm-10"> 
							<label class="radio-inline">
								  <input type="radio" id="new_staffGender0" name="gender" value="0" checked> 男
							</label>
							<label class="radio-inline">
								  <input type="radio" id="new_staffGender1" name="gender" value="1"> 女
							</label>
						</div>
					</div>
					<div class="form-group">
						<label  style="float:left;padding:7px 15px 0 27px;">出生年份</label>
						<div class="col-sm-10">
							<input type="number" class="form-control" id="new_staffBirthyear" placeholder="出生年份" name="birthyear">
						</div>
					</div>
					<div class="form-group">
						<label for="new_linkMan" class="col-sm-2 control-label">员工简历</label>
						<div class="col-sm-10">
							<textarea class="form-control" rows="3" id="new_staffResume" name="resume"></textarea> 
						</div>
					</div>
					<div class="form-group">
						<label  class="col-sm-2 control-label">入职日期</label>
						<div class="col-sm-10">
							 <input type="date" class="form-control" id="new_staffEnrolldate" name="enrolldateStr">
						</div>
					</div>
					<div class="form-group">
						<label  class="col-sm-2 control-label">所属部门</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="new_staffDepart" placeholder="所属部门" name="depart" />
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<button type="button" class="btn btn-primary" onclick="createStaff()">创建员工</button>
			</div>
		</div>
	</div>
</div>
<!-- 修改员工模态框 -->
<div class="modal fade" id="staffEditDialog" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">修改员工信息</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" id="edit_staff_form">
					<input type="hidden" id="edit_staff_id" name="id"/>
					
					<div class="form-group">
						<label for="edit_staffName" class="col-sm-2 control-label">
						    员工姓名
						</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="edit_staffName" placeholder="员工姓名" name="name" />
						</div>
					</div>
					<div class="form-group">
						<label for="edit_staffCode" style="float:left;padding:7px 15px 0 27px;">员工工号</label> 
						<div class="col-sm-10">
							<input type="text" class="form-control" id="edit_staffCode" placeholder="员工工号" name="code" />
						</div>
					</div>
					<div class="form-group">
						<label  style="float:left;padding:7px 15px 0 27px;">员工性别</label>
						<div class="col-sm-10"> 
							<label class="radio-inline">
								  <input type="radio" id="edit_staffGender0" name="gender" value="0" checked> 男
							</label>
							<label class="radio-inline">
								  <input type="radio" id="edit_staffGender1" name="gender" value="1"> 女
							</label>
						</div>
					</div>
					<div class="form-group">
						<label  style="float:left;padding:7px 15px 0 27px;">出生年份</label>
						<div class="col-sm-10">
							<input type="number" id="edit_staffBirthyear"  class="form-control" placeholder="出生年份" name="birthyear">
						</div>
					</div>
					<div class="form-group">
						<label for="new_linkMan" class="col-sm-2 control-label">员工简历</label>
						<div class="col-sm-10">
							<textarea class="form-control" id="edit_staffResume" rows="3" name="resume"></textarea> 
						</div>
					</div>
					<div class="form-group">
						<label  class="col-sm-2 control-label">入职日期</label>
						<div class="col-sm-10">
							 <input type="date" id="edit_staffEnrolldate" class="form-control"  name="enrolldateStr">
						</div>
					</div>
					<div class="form-group">
						<label  class="col-sm-2 control-label">所属部门</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="edit_staffDepart" placeholder="所属部门" name="depart" />
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<button type="button" class="btn btn-primary" onclick="updateStaff()">保存修改</button>
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
//清空新建员工窗口中的数据
	function clearStaff() {
	    $("#new_staffName").val("");
	    $("#new_staffCode").val("");
	    $("#new_staffBirthyear").val("");
	    $("#new_staffResume").val("");
	    $("#new_staffEnrolldate").val("");
	    $("#new_staffDepart").val("");
	    $("#new_staffGender0").prop("checked",true);
	}
	// 创建员工
	function createStaff() {
		if($("#new_staffName").val()==""){
			alert("姓名必须输入!");
			$("#new_staffName").focus();
			return;
		}
		if($("#new_staffCode").val()==""){
			alert("工号必须输入!");
			$("#new_staffCode").focus();
			return;
		}
		if($("#new_staffBirthyear").val()==""){
			alert("出生年份必须输入!");
			$("#new_staffBirthyear").focus();
			return;
		}
		if($("#new_staffResume").val()==""){
			alert("简历必须输入!");
			$("#new_staffResume").focus();
			return;
		}
		if($("#new_staffEnrolldate").val()==""){
			alert("入职日期必须输入!");
			$("#new_staffEnrolldate").focus();
			return;
		}
		if($("#new_staffDepart").val()==""){
			alert("部门必须输入!");
			$("#new_staffDepart").focus();
			return;
		}
		
	$.post("<%=basePath%>staff/create.action",
					$("#new_staff_form").serialize(),function(data){
	        if(data =="OK"){
	            alert("员工创建成功！");
	            window.location.reload();
	        }else{
	            alert("员工创建失败！");
	            window.location.reload();
	        }
	    });
	}
	// 通过id获取修改的员工信息
	function editStaff(id) {
	    $.ajax({
	        type:"get",
	        url:"<%=basePath%>staff/getStaffById.action",
	        data:{"id":id},
	        success:function(data) {
	            $("#edit_staff_id").val(data.id);
	            $("#edit_staffName").val(data.name);
	            $("#edit_staffCode").val(data.code)
	            $("#edit_staffBirthyear").val(data.birthyear)
	            $("#edit_staffResume").val(data.resume)
	            $("#edit_staffEnrolldate").val(data.enrolldateStr);
	            $("#edit_staffDepart").val(data.depart);
	            $("#edit_staffGender"+data.gender).prop("checked",true);
	        }
	    });
	}
    // 执行修改员工操作
	function updateStaff() {
		if($("#edit_staffName").val()==""){
			alert("姓名必须输入!");
			$("#edit_staffName").focus();
			return;
		}
		if($("#edit_staffCode").val()==""){
			alert("工号必须输入!");
			$("#edit_staffCode").focus();
			return;
		}
		if($("#edit_staffBirthyear").val()==""){
			alert("出生年份必须输入!");
			$("#edit_staffBirthyear").focus();
			return;
		}
		if($("#edit_staffResume").val()==""){
			alert("简历必须输入!");
			$("#edit_staffResume").focus();
			return;
		}
		if($("#edit_staffEnrolldate").val()==""){
			alert("入职日期必须输入!");
			$("#edit_staffEnrolldate").focus();
			return;
		}
		if($("#edit_staffDepart").val()==""){
			alert("部门必须输入!");
			$("#edit_staffDepart").focus();
			return;
		}
		$.post("<%=basePath%>staff/update.action",$("#edit_staff_form").serialize(),function(data){
			if(data =="OK"){
				alert("员工信息更新成功！");
				window.location.reload();
			}else{
				alert("员工信息更新失败！");
				window.location.reload();
			}
		});
	}
	// 删除员工
	function deleteStaff(id) {
	    if(confirm('确实要删除该员工吗?')) {
	$.post("<%=basePath%>staff/delete.action",{"id":id},
	function(data){
	            if(data =="OK"){
	                alert("员工删除成功！");
	                window.location.reload();
	            }else{
	                alert("员工客户失败！");
	                window.location.reload();
	            }
	        });
	    }
	}
</script>
</body>
</html>