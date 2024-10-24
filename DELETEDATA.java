#DELETEDATA
response.setContentType("text/html;charset=UTF-8"); 
 try (PrintWriter out = response.getWriter()) {
    out.println("<!DOCTYPE html>");
 out.println("<html>"); 
 out.println("<head>"); 
 out.println("<title>Servlet DeleteData</title>"); 
 out.println("</head>"); 
 out.println("<body>"); 
 try{ 
 Class.forName("com.mysql.jdbc.Driver"); 
 Connection 
con=DriverManager.getConnection("jdbc:mysql://localhost/College", 
"root", ""); 
 Statement st=con.createStatement(); 
 String r; 
 r=request.getParameter("txtRlno"); 
 String qry="Delete from student where rlno="+r; 
 int rows = st.executeUpdate(qry); 
 out.println(rows+ "<b> Record(s) Deletede</b>"); 
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
