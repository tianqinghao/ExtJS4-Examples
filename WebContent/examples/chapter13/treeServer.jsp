<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String orgId = request.getParameter("orgId");
	String result="";
	if("-1".equals(orgId)){
		result = "[{name:'总公司',count:100,id:100}]";
	}else if("100".equals(orgId)){
		result = "[{name:'分公司一',count:20,id:110,leaf:true},{name:'分公司二',count:80,id:120}]";
	}else if("120".equals(orgId)){
		result = "[{name:'部门一',count:30,id:121,leaf:true},{name:'部门二',count:50,id:122,leaf:true}]";
	}
	response.getWriter().write(result);
%>