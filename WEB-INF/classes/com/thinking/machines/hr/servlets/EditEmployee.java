package com.thinking.machines.hr.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.math.*;
import com.thinking.machines.hr.dl.*;
public class EditEmployee extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
String employeeId=request.getParameter("employeeId");
EmployeeDTO employee=null;
EmployeeDAO employeeDAO=new EmployeeDAO();
try
{
employee=employeeDAO.getByEmployeeId(employeeId);
}
catch(DAOException daoException)
{
sendBackView(response);
}
try
{
response.setContentType("text/html");
PrintWriter pw;
pw=response.getWriter();
pw.println("<!DOCTYPE html>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<title> HR Application </title>");
pw.println("<script>");
pw.println("function validateForm(frm)");
pw.println("{");
pw.println("var firstInvalidComponent=null;");
pw.println("var valid=true;");
pw.println("var name=frm.name.value.trim();");
pw.println("var nameErrorSection=document.getElementById('nameErrorSection');");
pw.println("nameErrorSection.innerHTML='';");
pw.println("if(name.length==0)");
pw.println("{");
pw.println("nameErrorSection.innerHTML='Name required';");
pw.println("frm.name.focus();");
pw.println("valid=false;");
pw.println("firstInvalidComponent=frm.name;");
pw.println("}");
pw.println("");
pw.println("var designationCode=frm.designationCode.value.trim();");
pw.println("var designationCodeErrorSection=document.getElementById('designationCodeErrorSection');");
pw.println("designationCodeErrorSection.innerHTML='';");
pw.println("if(designationCode==-1)");
pw.println("{");
pw.println("designationCodeErrorSection.innerHTML='Select Designation';");
pw.println("valid=false;");
pw.println("if(firstInvalidComponent==null) firstInvalidComponent=frm.designationCode;");
pw.println("}");
pw.println("");
pw.println("var dateOfBirth=frm.dateOfBirth.value;");
pw.println("var dateOfBirthErrorSection=document.getElementById('dateOfBirthErrorSection');");
pw.println("dateOfBirthErrorSection.innerHTML='';");
pw.println("if(dateOfBirth.length==0)");
pw.println("{");
pw.println("dateOfBirthErrorSection.innerHTML='Select Date Of Birth';");
pw.println("if(firstInvalidComponent==null)firstInvalidComponent=frm.dateOfBirth;");
pw.println("}");
pw.println("");
pw.println("var gender=frm.gender.value.trim();");
pw.println("var genderErrorSection=document.getElementById('genderErrorSection');");
pw.println("genderErrorSection.innerHTML='';");
pw.println("if(frm.gender[0].checked==false && frm.gender[1].checked==false)");
pw.println("{");
pw.println("genderErrorSection.innerHTML='Select Gender';");
pw.println("valid=false;");
pw.println("}");
pw.println("");
pw.println("var basicSalary=frm.basicSalary.value.trim();");
pw.println("var basicSalaryErrorSection=document.getElementById('basicSalaryErrorSection');");
pw.println("basicSalaryErrorSection.innerHTML='';");
pw.println("if(basicSalary.length==0)");
pw.println("{");
pw.println("basicSalaryErrorSection.innerHTML='Basic Salary Required';");
pw.println("valid=false;");
pw.println("if(firstInvalidComponent==null)firstInvalidComponent=frm.basicSalary;");
pw.println("}");
pw.println("else");
pw.println("{");
pw.println("var v='0123456789.';");
pw.println("var e=0;");
pw.println("var isBasicSalaryValid=true;");
pw.println("while(e<basicSalary.length)");
pw.println("{");
pw.println("if(v.indexOf(basicSalary.charAt(e))==-1)");
pw.println("{");
pw.println("alert();");
pw.println("basicSalaryErrorSection.innerHTML='Invalid basic salary';");
pw.println("valid=false;");
pw.println("if(firstInvalidComponent==null)firstInvalidComponent=frm.basicSalary;");
pw.println("isBasicSalaryValid=false;");
pw.println("break;");
pw.println("}");
pw.println("e++;");
pw.println("}");
pw.println("if(isBasicSalaryValid)");
pw.println("{");
pw.println("var dot=basicSalary.indexOf('.');");
pw.println("if(dot!=-1)");
pw.println("{");
pw.println("var numberOfFractions=basicSalary.length-(dot+1);");
pw.println("if(numberOfFractions>2)");
pw.println("{");
pw.println("basicSalaryErrorSection.innerHTML='Invalid basic salary';");
pw.println("valid=false;");
pw.println("if(firstInvalidComponent==null)firstInvalidComponent=frm.basicSalary;");
pw.println("}");
pw.println("}");
pw.println("}");
pw.println("}");
pw.println("");
pw.println("");
pw.println("var panNumber=frm.panNumber.value.trim();");
pw.println("var panNumberErrorSection=document.getElementById('panNumberErrorSection');");
pw.println("panNumberErrorSection.innerHTML='';");
pw.println("if(panNumber.length==0)");
pw.println("{");
pw.println("panNumberErrorSection.innerHTML='PAN Number required';");
pw.println("valid=false;");
pw.println("if(firstInvalidComponent==null) firstInvalidComponent=frm.panNumber;");
pw.println("}");
pw.println("");
pw.println("var aadharCardNumber=frm.aadharCardNumber.value.trim();");
pw.println("var aadharCardNumberErrorSection=document.getElementById('aadharCardNumberErrorSection');");
pw.println("aadharCardNumberErrorSection.innerHTML='';");
pw.println("if(aadharCardNumber.length==0)");
pw.println("{");
pw.println("aadharCardNumberErrorSection.innerHTML='Aadhar Card Number required';");
pw.println("valid=false;");
pw.println("if(firstInvalidComponent==null) firstInvalidComponent=frm.aadharCardNumber;");
pw.println("}");
pw.println("");
pw.println("");
pw.println("");
pw.println("if(!valid) firstInvalidComponent.focus();");
pw.println("return valid;");
pw.println("}");
pw.println("function cancelUpdate()");
pw.println("{");
pw.println("document.getElementById('cancelUpdateForm').submit();");
pw.println("}");
pw.println("</script>");
pw.println("</head>");
pw.println("<body>");
pw.println("<!--  Main Container starts here  -->");
pw.println("<div style='width:90hw;height:auto;border:1px solid black'>");
pw.println("<!--  header starts here  -->");
pw.println("<div style='margin:5px;width:90hw;height:auto;border:1px solid black'>");
pw.println("<img src='/styleone/images/logo.png' style='float:left'><div style='margin-top:9px;margin-bottom:9px;font-size:20pt'>Thinking Machines</div> ");
pw.println("</div><!-- header ends here  -->");
pw.println("<!--  content section starts here  -->");
pw.println("<div style='width:90hw;height:70vh;margin:5px;border:1px solid white'>");
pw.println("<!-- left panel starts here -->");
pw.println("<div style='height:65vh;margin:5px;float:left;padding:5px;border:1px solid black'>");
pw.println("<a href='/st1/employeesView'>Employees</a><br>");
pw.println("<a href='/styleone/designationsView'>Designations</a><br><br>");
pw.println("<a href='/styleone/index.html'>Home</a>");
pw.println("</div>");
pw.println("<!-- left panel ends here -->");
pw.println("<!-- right panel starts here -->");
pw.println("<div style='height:65vh;margin-left:105px;margin-right:5px;margin-bottom-5px;margin-top:5px;padding:5px;border:1px solid black'>");
pw.println("<h2>Employee(Edit Module)</h2>");
pw.println("<form method='post' action='/styleone/updateEmployee' onSubmit='return validateForm(this)'>");
pw.println("<input type='hidden' name='employeeId' id='employeeId' value='"+employeeId+"'>");
pw.println("<table>");
pw.println("<tr>");
pw.println("<td>Name</td>");
String name=employee.getName();
pw.println("<td><input type='text' id='name' name='name' maxlength='50' size='51' value='"+name+"'>");
pw.println("<span id='nameErrorSection' style='color:red'></span><br></td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>Designation</td>");
int designationCode=employee.getDesignationCode();
pw.println("<td><select id='designationCode' name='designationCode'>");
pw.println("<option value='-1'>&lt;Select Designation&gt;</option>");
DesignationDAO designationDAO=new DesignationDAO();
List<DesignationDTO>designations=designationDAO.getAll();
int code;
String title;
for(DesignationDTO designation:designations)
{
code=designation.getCode();
title=designation.getTitle();
if(code!=designationCode)
{
pw.println("<option value='"+code+"'>"+title+"</option>");
}
else
{
pw.println("<option selected value='"+code+"'>"+title+"</option>");
}
}
pw.println("</select>");
pw.println("<span id='designationCodeErrorSection' style='color:red'></span>");
pw.println("</td>");
pw.println("</tr>");
pw.println("");
pw.println("<tr>");
pw.println("<td>Date Of Birth</td>");
SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
java.util.Date dateOfBirth=employee.getDateOfBirth();
pw.println("<td><input type='date' id='dateOfBirth' name='dateOfBirth' value='"+simpleDateFormat.format(dateOfBirth)+"'>");
pw.println("<span id='dateOfBirthErrorSection' style='color:red'></span>");
pw.println("</td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>Gender</td>");
String gender=employee.getGender();
pw.println("<td>");
if(gender.equals("M")==false)
{
pw.println("<input type='radio' id='Male' name='gender' value='M'>Male");
}
else
{
pw.println("<input checked type='radio' id='Male' name='gender' value='M'>Male");
}
pw.println("&nbsp;&nbsp;&nbsp;&nbsp;");
if(gender.equals("F")==false)
{
pw.println("<input type='radio' id='Female' name='gender' value='F'>Female");
}
else
{
pw.println("<input checked type='radio' id='Female' name='gender' value='F'>Female");
}
pw.println("<span id='genderErrorSection' style='color:red'></span>");
pw.println("</td>");
pw.println("</tr>");
pw.println("<tr>");
boolean isIndian=employee.getIsIndian();
pw.println("<td>Indian ?</td>");
pw.println("<td>");
if(isIndian)
{
pw.println("<input checked  type='checkbox' name='isIndian' id='isIndian' value='Y'></td>");
}
else
{
pw.println("<input type='checkbox' name='isIndian' id='isIndian' value='Y'></td>");
}
pw.println("</tr>");
pw.println("<tr>");
BigDecimal basicSalary=employee.getBasicSalary();
pw.println("<td>Basic Salary</td>");
pw.println("<td>");
pw.println("<input type='text' style='text-align:right' name='basicSalary' id='basicSalary' value='"+basicSalary.toPlainString()+"'>");
pw.println("<span id='basicSalaryErrorSection' style='color:red'></span>");
pw.println("</td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<tr>");
String panNumber=employee.getPANNumber();
pw.println("<td>PAN Number</td>");
pw.println("<td>");
pw.println("<input type='text' name='panNumber' id='panNumber'maxlength='15' size='16' value='"+panNumber+"'>");
pw.println("<span id='panNumberErrorSection' style='color:red'></span>");
pw.println("</td>");
pw.println("</tr>");
pw.println("<tr>");
String aadharCardNumber=employee.getAadharCardNumber();
pw.println("<td>AadharCard Number</td>");
pw.println("<td>");
pw.println("<input type='text' name='aadharCardNumber' id='aadharCardNumber'maxlength='15' size='16' value='"+aadharCardNumber+"'>");
pw.println("<span id='aadharCardNumberErrorSection' style='color:red'></span>");
pw.println("</td>");
pw.println("</tr>");
pw.println("<td colspan='2'><button type='submit'>Update</button>");
pw.println("&nbsp;<button type='Button' onClick='cancelUpdate()'>Cancel</button>");
pw.println("</tr>");
pw.println("</table>");
pw.println("</form>");
pw.println("</div>");
pw.println("<!-- right panel ends here -->");
pw.println("</div>");
pw.println("<!-- content section ends here  -->");
pw.println("<!-- footer starts here -->");
pw.println("<div style='width:90hw;height:auto;margin:5px;text-align:center;border:1px solid white'>");
pw.println("&copy;Thinking Machines 2020");
pw.println("</div>");
pw.println("<!-- footer ends here -->");
pw.println("</div> <!--  Main Container ends here  -->");
pw.println("<form id='cancelUpdateForm' action='/styleone/employeesView'>");
pw.println("</form>");
pw.println("</body>");
pw.println("</html>");
}
catch(Exception exception)
{
System.out.println(exception);
}
}
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
doGet(request,response);
}
private void sendBackView(HttpServletResponse response)
{

try
{
PrintWriter pw=response.getWriter();
response.setContentType("text/html");
List<EmployeeDTO>employees=new EmployeeDAO().getAll();
pw.println("<!DOCTYPE HTML>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<title>StyleOne</title>");
pw.println("<script>");
pw.println("function Employee()");
pw.println("{");
pw.println("this.employeeId=\"\";");
pw.println("this.name=\"\";");
pw.println("this.designationCode=0;");
pw.println("this.designation=\"\";");
pw.println("this.dateOfBirth=\"\";");
pw.println("this.gender=\"\";");
pw.println("this.basicSalary=0;");
pw.println("this.isIndian=true;");
pw.println("this.panNumber=\"\";");
pw.println("this.aadharCardNumber=\"\";");
pw.println("}");
pw.println("var selectedRow=null;");
pw.println("var employees=[];");
int i=0;
SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
for(EmployeeDTO employee:employees)
{
pw.println("var employee=new Employee();");
pw.println("employee.employeeId=\""+employee.getEmployeeId()+"\";");
pw.println("employee.name=\""+employee.getName()+"\";");
pw.println("employee.designationCode="+employee.getDesignationCode()+";");
pw.println("employee.designation=\""+employee.getDesignation()+"\";");
pw.println("employee.dateOfBirth=\""+simpleDateFormat.format(employee.getDateOfBirth())+"\";");
pw.println("employee.gender=\""+employee.getGender()+"\";");
pw.println("employee.isIndian=\""+employee.getIsIndian()+"\";");
pw.println("employee.basicSalary="+employee.getBasicSalary().toPlainString()+";");
pw.println("employee.panNumber=\""+employee.getPANNumber()+"\";");
pw.println("employee.aadharCardNumber=\""+employee.getAadharCardNumber()+"\";");
pw.println("employees["+i+"]=employee;");
i++;
}
pw.println("function selectEmployee(row,employeeId)");
pw.println("{");
pw.println("if(row==selectedRow) return;");
pw.println("if(selectedRow!=null)");
pw.println("{");
pw.println("selectedRow.style.background=\"white\";");
pw.println("selectedRow.style.color=\"black\";");
pw.println("}");
pw.println("row.style.background=\"gray\";");
pw.println("row.style.color=\"white\";");
pw.println("selectedRow=row;");
pw.println("var i;");
pw.println("for(i=0;i<employees.length;i++)");
pw.println("{");
pw.println("if(employees[i].employeeId==employeeId)");
pw.println("{");
pw.println("break;");
pw.println("}");
pw.println("}");
pw.println("var emp=employees[i];");
pw.println("document.getElementById(\"detailsPanel_employeeId\").innerHTML=emp.employeeId;");
pw.println("document.getElementById(\"detailsPanel_name\").innerHTML=emp.name;");
pw.println("document.getElementById(\"detailsPanel_designation\").innerHTML=emp.designation;");
pw.println("document.getElementById(\"detailsPanel_dateOfBirth\").innerHTML=emp.dateOfBirth;");
pw.println("document.getElementById(\"detailsPanel_gender\").innerHTML=emp.gender;");
pw.println("if(emp.isIndian)");
pw.println("{");
pw.println("document.getElementById(\"detailsPanel_isIndian\").innerHTML=\"Yes\";");
pw.println("}");
pw.println("else");
pw.println("{");
pw.println("document.getElementById(\"detailsPanel_isIndian\").innerHTML=\"No\";");
pw.println("}");
pw.println("document.getElementById(\"detailsPanel_basicSalary\").innerHTML=emp.basicSalary;");
pw.println("document.getElementById(\"detailsPanel_panNumber\").innerHTML=emp.panNumber;");
pw.println("document.getElementById(\"detailsPanel_aadharCardNumber\").innerHTML=emp.aadharCardNumber;");
pw.println("}");
pw.println("</script>");
pw.println("</head>");
pw.println("<body>");
pw.println("<!-- container starts here -->");
pw.println("<div style='width:90hw;height:auto;border:2px solid black'>");
pw.println("<!-- header starts here -->");
pw.println("<div style='margin:5px;border:2px solid black;width:90hw;height:50px'>");
pw.println("<a href='/st1/index.html'><img src='/st1/images/logo.png' style='float:left'></a><div style='margin:5px;margin-left:60px;font-size:20pt'>Thinking Machines</div>");
pw.println("</div>");
pw.println("<!-- header ends here -->");
pw.println("<!-- content-section starts here -->");
pw.println("<div style='margin:5px;border:2px solid white;width:90hw;height:70vh'>");
pw.println("<!-- left panel starts here -->");
pw.println("<div style='margin:5px;height:65vh;padding:5px;border:2px solid black;float:left'>");
pw.println("<a href='/st1/designationsView'>Designations</a><br>");
pw.println("<b>Employees</b><br><br>");
pw.println("<a href='/st1/index.html'>Home</a>");
pw.println("</div>");
pw.println("<!-- left panel ends here -->");
pw.println("<!-- right panel starts here -->");
pw.println("<div style='margin:5px;border:2px solid black;height:65vh;margin-left:105px;padding:5px'>");
pw.println("<h2>Employees</h2>");
pw.println("<div style='margin:5px;border:2px solid black;height:30vh;margin-left:5px;padding:5px;overflow:scroll'>");
pw.println("<table border='1'>");
pw.println("<thead>");
pw.println("<tr>");
pw.println("<th colspan='6' style='text-align:right;padding:2px'>");
pw.println("<a href='/st1/getEmployeeAddForm'>Add Employee</a>");
pw.println("</th>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<th style='width:70px;text-align:center'>S.No</th>");
pw.println("<th style='width:100px;text-align:center'>Id</th>");
pw.println("<th style='width:120px;text-align:center'>Name</th>");
pw.println("<th style='width:100px;text-align:center'>Designation</th>");
pw.println("<th style='width:70px;text-align:center'>Edit</th>");
pw.println("<th style='width:70px;text-align:center'>Delete</th>");
pw.println("</tr>");
pw.println("</thead>");
pw.println("<tbody>");
int sno=0;
for(EmployeeDTO employee:employees)
{
sno++;
pw.println("<tr style='cursor:pointer' onClick='selectEmployee(this,\""+employee.getEmployeeId()+"\")'>");
pw.println("<td style='text-align:right'>"+sno+".</td>");
pw.println("<td style='text-align:left'>"+employee.getEmployeeId()+"</td>");
pw.println("<td style='text-align:left'>"+employee.getName()+"</td>");
pw.println("<td style='text-align:left'>"+employee.getDesignation()+"</td>");
pw.println("<td style='text-align:center'><a href='/st1/editEmployee?employeeId="+employee.getEmployeeId()+"'>Edit</a></td>");
pw.println("<td style='text-align:center'><a href='/st1/confirmDeleteEmployee?employeeId="+employee.getEmployeeId()+"'>Delete</a></td>");
pw.println("</tr>");
}

pw.println("</tbody>");
pw.println("</table>");
pw.println("");
pw.println("</div>");
pw.println("");
pw.println("");
pw.println("<div style='margin:5px;border:2px solid black;height:20vh;margin-left:5px;padding:5px;overflow:scroll'>");
pw.println("<label style='background:gray;color:white;padding-left:5px;padding-right:5px'>Details</label><br>");
pw.println("<table border='0' width=\"100%\">");
pw.println("<tr>");
pw.println("<td>Employee Id : <span id='detailsPanel_employeeId' style='margin-right:30px'></span></td>");
pw.println("<td>Name : <span id='detailsPanel_name' style='margin-right:30px'></td>");
pw.println("<td>Designation : <span id='detailsPanel_designation' style='margin-right:30px'></td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>Date Of Birth : <span id='detailsPanel_dateOfBirth' style='margin-right:30px'></td>");
pw.println("<td>Gender : <span id='detailsPanel_gender' style='margin-right:30px'></td>");
pw.println("<td>Is Indian : <span id='detailsPanel_isIndian' style='margin-right:30px'></td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>Basic Salary: <span id='detailsPanel_basicSalary' style='margin-right:30px'></td>");
pw.println("<td>PAN Number : <span id='detailsPanel_panNumber' style='margin-right:30px'></td>");
pw.println("<td>Aadhar Card Number : <span id='detailsPanel_aadharCardNumber' style='margin-right:30px'></td>");
pw.println("</tr>");
pw.println("</table>");
pw.println("</div>");
pw.println("</div>");
pw.println("<!-- right panel ends here -->");
pw.println("</div>");
pw.println("<!-- content-section ends here -->");
pw.println("<!-- footer starts here -->");
pw.println("<div style='width:90hw;height:auto;margin:5px;border:2px solid white;text-align:center'>");
pw.println("&copy;Thinking Machines 2020");
pw.println("</div>");
pw.println("<!-- footer ends here -->");
pw.println("</div>");
pw.println("<!-- container ends here -->");
pw.println("</body>");
pw.println("</html>");



}catch(Exception e)
{
System.out.println(e.getMessage());
}
}
}