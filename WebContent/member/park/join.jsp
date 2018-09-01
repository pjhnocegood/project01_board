<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%-- SpringFramework에서 제공하는 입력 관련 태그를 이용하여 값 입력 --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="robots" content="index, follow">
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>

<!-- Page scripts -->
<style type="text/css">
.error{
   color: deeppink;
   font-size: 12px !important;
   margin-left: 3px;
}


.result {
   /*            
         width: 1100px;*/
   /* height: 500px;*/
   margin: 50px;
   margin: 0 auto;
   margin-top: 50px;
   margin-bottom: 50px;
}

.bodycnt {
   /*        float: left;
        margin-left: 20px;*/
   margin: 0 auto;
   border: 1px solid black;
   padding: 25px;
   margin-bottom: 20px;
}

.bodycnt div {
   width: 90%;
   margin: 0 auto;
   margin-top: 30px;
   margin-bottom: 30px;
}

.bodycnt h2 {
   width: 90%;
   margin: 0 auto;
}

.now {
   color: cornflowerblue;
}

.text {
   font-size: 13px;
   color: #262626;
}

.bold {
   font-weight: bold;
   font-size: 15px;
}

.penaltyTable {
   width: 90%;
   border: 1px solid #DEDEDE;
   margin: 50px 0px;
   border-top: 2px solid #DEDEDE;
   color: #3B3B3B;
   font-size: 12px;
   margin: 0 auto;
   margin-top: 30px;
   margin-bottom: 30px;
}

.penaltyTable th {
   background-color: #FAFAFA;
   height: 35px;
   font-size: 16px;
   text-align: center;
}

.penaltyTable td {
   height: 50px;
   padding-left: 10px;
}

.marginBottom {
   margin: 5px;
   margin-bottom: 10px;
   margin-left: 20x;
}

.box {
   height: 100px;
}

.box img {
   margin-right: 20px;
}

.padleft {
   padding-left: 0;
}

.wp-source-code{
   font-size: 12px;
   color: #262626;
}
pre {
   font-size: 12px;
   color: #262626;
}
.checkbox{
   font-size: 12px;
}
</style>   
</head>
<body>



   <!-- MAIN WRAPPER -->
   <div class="body-wrap">

     

      <%-- 폼 -  포스트 방식으로 값을 넘겨줌 --%>


      <div class="result container">
         <section class="slice bg-white">
         <div class="wp-section">
            <div class="container">
               <div class="row">
                  <div class="col-md-8 col-md-offset-2 col-sm-6 col-sm-offset-3">
                     <div class="wp-block default user-form no-margin">
                        <div class="form-header">
                           <h2>Create your own account</h2>
                        </div>
                        <div class="form-body">
                        
   <%-- SpringFramework의 form 태그 라이브러리에 form 태그를 이용하여 입력값 전달 --%>
   <%-- modelAttribute 속성(필수) : Command 인스턴스명을 속성값으로 설정 --%>
   <%-- => 입력값의 유효성 검사가 실패된 경우 입력태그의 기존 입력값을 초기값으로 출력 --%>
      
<form method="post" class="sky-form"  id="member_form" >
         <!-- <input type="hidden" name="mbState" value="1"> -->
                           <%--  <form id="frmRegister" class="sky-form" id="post"> --%>
                              <fieldset class="no-padding">
                                 
                                 <div class="row">
                                    <div class="col-xs-6">
                                       <div class="form-group">
                                          <label class="label">ID</label> <label class="input">
                                             <i class="icon-append fa fa-user"></i>
                                             <%-- SpringFramework의 form 태그 라이브러리에 input 태그를 이용하여 텍스트 입력 --%>
                                             <%-- path 속성 : input 태그의 name 속성과 id 속성의 역활을 수행 --%>
                                             <%-- => value 속성의 역활 수행 : Command 인스턴스가 전달될 경우 필드값을 입력값으로 출력 --%>
                                          
                                    <%--    <form:input path="mbId" />
                                          <!--    form:errors는 message를 출력 -->
                                       <form:errors path="mbId"/> --%>
                                       <input type="text" name="member_id" id="member_id" value="">
                                       <span id="idMsg" class="error"></span>
                                       <span style="color: red;"></span> 
                                       
                                             
                                              <%-- <i style="color: red;">${message}</i> --%>
                                             <b class="tooltip tooltip-bottom-right">Needed to
                                                verify your name</b>
                                          </label>
                                       </div>
                                    </div>
                                    <div class="col-xs-6">
                                       <div class="form-group">
                                          <div class="form-group">
                                             <label class="label">E-mail</label> <label class="input">
                                                <i class="icon-append fa fa-envelope-o"></i>
                                             <%-- <form:input path="mbEmail"/> 
                                              <form:errors path="mbEmail"/> --%>
                                              
             <input type="text" name="member_email" id="member_email" value="">
            <span id="emailMsg" class="error"></span>
                                             </label>
                                          </div>
                                       </div>
                                    </div>


                                 </div>


                                 <hr class="col-md-pull-11">
                                 <div class="row">
                                    <div class="col-md-6">
                                       <div class="form-group">
                                          <label class="label">Password</label> <label class="input">
                                             <i class="icon-append fa fa-lock"></i>
                                             <%-- <form:password path="mbPasswd"/> 
                                             <form:errors path="mbPasswd"/> --%>
                  <input type="password" name="member_pass" id="member_pass" value="">
                  <span id="passwdMsg" class="error"></span>
                                             <b class="tooltip tooltip-bottom-right">Needed to verify
                                                your password</b>
                                          </label>
                                       </div>
                                    </div>
                                    <div class="col-md-6">
                                       <div class="form-group">
                                          <label class="label">Password Confirm</label> <label
                                             class="input"> <i class="icon-append fa fa-lock"></i>
                                          <input type="password" name="member_pass2" id="mbPasswd2" value="">
                                          <span id="member_pass2" class="error"></span>
                                             
                                             <b class="tooltip tooltip-bottom-right">Needed to
                                                verify your password</b>
                                          </label>
                                       </div>
                                    </div>
                                 </div>
                                 
                                 <hr>
                                 <section>
                                 <div class="row">
                                    <section class="col-xs-6"> <label class="label">Name</label>
                                    <label class="input"> <i
                                       class="icon-append fa fa-user"></i> 
                                       <%-- <form:input path="mbName" />
                                       <form:errors path="mbName"/> --%>
            <input type="text" name="member_name" id="member_name" value="">
            <span id="nameMsg" class="error"></span>
                                    </label> </section>


                                                <section class="col-xs-6">
                                                    <label class="label">Phone</label>
                                                    <label class="input">
                                                        <i class="icon-append fa fa-phone"></i>
                                                        
                                                 
            <input type="text" name="member_phon" id="member_phon" value="">
          
                                                    </label>
                                                </section>
                                                <section class="col-xs-6">
                                                    <label class="label">Birth</label>
                                                    <label class="input">
                                                        <i class="icon-append fa fa-phone"></i>
                                                        
                                                 
            <input type="date" name="member_birth" id="member_birth" value="">
          
                                                    </label>
                                                </section>
                                 </div>

                                 <hr class="col-md-pull-11">


                                 <div class="row">
                                    <div class="col-xs-9">
                                       <label class="label">성별</label>
                                       <div class="col-xs-8 col-md-offset-0 padleft">
                                      	 <input type="radio" name="member_sex" value="남자" /> 남자
										  <input type="radio" name="member_sex" value="여자" checked="checked" /> 여자
                                       </div>
                                    </div>
                                 </div>


                                

                                 </section>
                              </fieldset>

                              <fieldset>

                                 <div class="row">
                                    <label class="label" style="margin-left: 17px;">Post</label>
                                     <section class="col-xs-3"> <label for="file"
                                       class="input"> <input  name="member_post" id="member_post"
                                       placeholder="Post" value=""><span id="zipMsg" class="error"></span>
                                    </label> </section> 


						 <label class="label" style="margin-left: 17px;">Address</label>
                                     <section class="col-xs-3"> <label for="file"
                                       class="input"> <input  name="member_address" id="member_address"
                                       placeholder="Address" value=""><span id="zipMsg" class="error"></span>
                                    </label> </section>

                                 </div>
                                
                                 <span id="addrMsg" class="error"></span>
                                 <%-- <form:errors path="mbAddr2"/> --%>
                                 
                                 
                                 <hr class="col-md-pull-11">
                                 <section>
                                 <div class="row">


                                    <div class="col-md-12" style="margin-top: 3%;">
                                       <div class="form-group">
                                       
                                          <label for="exampleFormControlTextarea1">Trive
                                             이용약관</label>   

                                          <!-- Source code -->
                                          <div class="wp-source-code">
                                             <pre class="prettyprint pre-scrollable" id="pre-1">

</pre>
                                          </div>

                                       </div>

                                       <label class="checkbox" > <input type="checkbox" name="agree" id="agree"
                                          > <i></i>회원가입에 동의합니다. (필수)
                                       </label>
                                       <span id="agree2Msg" class="error"></span>
                                       <%-- <form:errors path="agree2"/> --%>
                                    </div>
                                    <br> <br> <br>
                                    <div class="col-md-12" align="right" style="margin-top: 3%">
                                       <input type="button" class="btn btn-lg btn-base col-md-12"
                                          value="회원가입" onclick="member_insert()" >
                                    </div>


                                 </div>
                                 </section>
                              </fieldset>
                              
                           <%-- </form> --%> 
                     </form>
                        
                        
                        
                        </div>
                        <!-- <div class="form-footer">
                           <p>
                              Already have an account? <a href="login">Click
                                 here to sign in.</a>
                           </p>
                        </div> -->
                     </div>
                  </div>
               </div>
            </div>
         </div>
         </section>

      </div>


      <!-- FOOTER -->
   </div>
   <script type="text/javascript">
 	function member_insert(){
 		
 		
 		 if($('#agree').is(":checked")==false){
 			 alert('인증이 되지 않았습니다.')
 			 
 			 return false;
 		 }else  if($('#member_id').val()==""){
 			 alert('ID를 입력해주세요.')
 			 return false;
 		 }else  if($('#member_email').val()==""){
 			 alert('Email을 입력해주세요.')
 			 return false;
 		 }else if($('#member_pass').val()==""){
 			 alert('비번을 입력해주세요.')
 			 return false;
 		 }else if($('#member_name').val()==""){
 			 alert('이름을 입력해주세요.')
 			 return false;
 		 }else if($('#member_phon').val()==""){
 			 alert('핸드폰번호를 입력해주세요.')
 			 return false;
 		 }else if($('#member_sex').val()==""){
 			 alert('성별을 입력해주세요.')
 			 return false;
 		 }else if($('#member_address').val()==""){
 			 alert('주소를 입력해주세요.')
 			 return false;
 		 }
 		
 		 
 		$.ajax(
				{
					url : "./insert.do",
	                data: $('#member_form').serializeArray(),
					type: 'Post',
					dataType : 'text',
					success : function(result) {
						
						
					
						
						
					alert('통신성공');
						
						
					},
					error : function() {
						alert('통신실패');
					}
				})
 	}
   

   </script>   
   
   






