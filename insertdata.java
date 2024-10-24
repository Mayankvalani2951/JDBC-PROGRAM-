#insertdata.java
response.setContentType("text/html;charset=UTF-8"); 
 try (PrintWriter out = response.getWriter()) { 
 out.println("<!DOCTYPE html>"); 
 out.println("<html>"); 
 out.println("<head>"); 
 out.println("<title>Servlet InsertData</title>"); 
 out.println("</head>"); 
 out.println("<body>"); 
 try{ 
 Class.forName("com.mysql.jdbc.Driver"); 
 Connection 
con=DriverManager.getConnection("jdbc:mysql://localhost/College", 
"root", ""); 
 Statement st=con.createStatement(); 
 String r,s,c; 
 r=request.getParameter("txtRlno"); 
 s=request.getParameter("txtName"); 
 c=request.getParameter("txtCity"); 
 String qry="Insert into student 
values("+r+",'"+s+"','"+c+"')"; 
 //out.print(qry); 
 int rows = st.executeUpdate(qry); 
 out.println(rows+ "<b> Record(s) Inserted</b><br>"); 
 st.close(); 
 con.close(); 
 }catch(Exception e){ 
 e.printStackTrace(); 
 } 
 RequestDispatcher rd = 
request.getRequestDispatcher("ViewData"); 
 rd.forward(request,response); 
 out.println("</body>"); 
 out.println("</html>"); 
 } 
 