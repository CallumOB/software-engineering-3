<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add a Student</title>
</head>

<body>

      <form action="FrontController" method="post">
          <table>
              <tr>
                  <td> Student Number  : </td><td> <input name="studentNumber" size=10 type="text" /> </td> 
              </tr>
              <tr>
                  <td> First Name  : </td><td> <input name="firstName" size=50 type="text" /> </td> 
              </tr>
              <tr>
                  <td> Last Name  : </td><td> <input name="lastName" size=50 type="text" /> </td> 
              </tr>
              <tr>
                  <td> Email  : </td><td> <input name="emailAddress" size=100 type="text" /> </td> 
              </tr>
              <tr>
                  <td> 
					<label for="modules">Choose a module:</label>
					<select name="modules" id="modules" multiple>
					  <option value="CMPU3038">CMPU3038 | Software Engineering III</option>
					  <option value="SENG9810">SENG9810 Software Design</option>							  
					</select>
				</td> 
              </tr>
          </table>
                
          <input type="hidden" name="action" value="AddStudent" />
          <input type="submit" value="Add Student" />
      </form>


</body>
</html>