<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE  html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/custom.css">
<title>JSP AJAX 회원가입</title>
<script src="https://code.jquery.com/jquery-3.1.1.min.js" ></script>
<script src="js/bootstrap.js"></script>
</head>
<body>
	<div class="container">
		<form method="post" action="./userRegister">
			<table class="table talbe-bordered table-hover"
				style="text-align: center; border: 1px solid #ddddd">
				<thead>
					<tr>
						<th colspan="3"><h4>회원 등록 양식</h4></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width: 110px;"><h5>아이디</h5></td>
						<td><input class="form-control" type="text" id="userID"
							name="userID" maxlength="20"></td>
						<td style="width: 110px;"><button class="btn btn-primary"
								onclick="registerCheckFuntion()">중복체크</button></td>
					</tr>
					<tr>
						<td style="width: 110px;"><h5>비밀번호</h5></td>
						<td colspan="2"><input class="form-control" type="password"
							id="userPassword1" name="userPassword1" maxlength="20"></td>
					</tr>
					<tr>
						<td style="width: 110px;"><h5>비밀번호확인</h5></td>
						<td colspan="2"><input class="form-control" type="password"
							id="userPassword2" name="userPassword2" maxlength="20"></td>
					</tr>
					<tr>
						<td style="width: 110px;"><h5>이름</h5></td>
						<td colspan="2"><input class="form-control" type="text"
							id="userName" name="userName" maxlength="20"></td>
					</tr>
					<tr>
						<td style="width: 110px;"><h5>나이</h5></td>
						<td colspan="2"><input class="form-control" type="text"
							id="userAge" name="userAge" maxlength="20"></td>
					</tr>
					<tr>
						<td style="width: 110px;"><h5>성별</h5></td>
						<td colspan="2">
							<div class=" form-group"
								style="text-align: center; margin: 0 auto;">
								<div class="btn-group" data-toggle="buttons">
									<label class="btn btn-primary active"> <input
										type="radio" name="userGender" autocomplete="off" value="남자"
										checked>남자
									</label> <label class="btn btn-primary "> <input type="radio"
										name="userGender" autocomplete="off" value="여자">여자
									</label>
								</div>
							</div>
						</td>
					</tr>
					<tr>
						<td style="width: 110px;"><h5>이메일</h5></td>
						<td colspan="2"><input class="form-control" type="text"
							id="email" name="userEmail" maxlength="20"></td>
					</tr>
					<tr>
						<td style="text-align: left" colspan="3"><input
							class="btn btn-primary pull-right" type="submit" value="회원가입"></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	<%
		String messageContent = null;
	   if(session.getAttribute("messageContent") != null){
		   messageContent = (String) session.getAttribute("messageContent");
	   }
		String messageType = null;
	   if(session.getAttribute("messageType") != null){
		   messageType = (String) session.getAttribute("messageType");
	   }
		if(messageContent  != null){
		%>

	<div class="modal fade" id="messageMedal" tabindex="-1" role="dialog"	aria-hidden="true">
		<div class="vertical-alignment-helper">
		<div class="  vertical-align-center">
			<div class="modal-content"
				<%if(messageType.equals("오류메세지")) out.println("panel-warning"); else out.println("panel-success");%>>
				<div class="modal-header">
					 <button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">
						<%=messageType %>
					</h4>
				</div>
				<div class="modal-body">
					<%=messageContent %>
				</div>
				<div class="modal-footer">
					 <button type="button" class="btn btn-default" data-dismiss="modal">확인</button>
				</div>
			</div>
		</div>
		</div>
	</div>
   <script>
   		$('#messageMedal').modal('show');
   </script>
	<%
	   session.removeAttribute("messageContent");
	   session.removeAttribute("messageType");
		}
		%>


</body>
</html>