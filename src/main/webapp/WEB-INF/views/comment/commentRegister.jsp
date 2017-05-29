<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="${pageContext.request.contextPath}/resources/js/jquery-1.12.4.min.js"></script>

<script type="text/javascript">
    $(document).ready(function(){
    	$("#writeBtn").click(function(){ 
    		if($("#title").val()==""){
    			alert("제목을 입력하세요!");
    		}else if($("#content").val()==""){
    			alert("본문을 입력하세요!");
    		}else{
    			$("#write_form").submit();
    		}
    	});
    	$("#resetBtn").click(function(){    		
    		$("#write_form")[0].reset();
    	});
    });	
</script>



  <form action="${pageContext.request.contextPath}/commentRegister.do" method="post" id="write_form">
   <table id="inputForm" class="table table-hover">
    <tbody align="center">
    <tr>
     <td colspan="3">
     제목 &nbsp;&nbsp;<input type="text" id="title" name="title" size="48" >
     </td>
    </tr>
    <tr>
     <td colspan="3">작성자&nbsp;&nbsp;${sessionScope.mvo.name}</td>     
    </tr>
    <tr>
     <td colspan="4" align="center">
     &nbsp;&nbsp;
     <textarea cols="53" rows="15" id="content" name="content"></textarea>
     </td>
    </tr> 
    <tr>
     <td colspan="4" align="center" >
      <input class="comment_btn" type="button" id="writeBtn" value="등록">
      <input class="comment_btn" type="button" id="resetBtn"  value="리셋" >      
     </td>  
    </tr>
    </tbody>
   </table>
  </form>