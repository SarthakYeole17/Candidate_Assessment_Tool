<%@page import="java.sql.*" %>
<%@page import="com.company.services.*" %>
<%@page import="java.sql.PreparedStatement"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>View Job</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Visitors Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- bootstrap-css -->
<link rel="stylesheet" href="css/bootstrap.min.css" >
<!-- //bootstrap-css -->
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/style-responsive.css" rel="stylesheet"/>
<!-- font CSS -->
<link href='//fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
<!-- font-awesome icons -->
<link rel="stylesheet" href="css/font.css" type="text/css"/>
<link href="css/font-awesome.css" rel="stylesheet"> 
<!-- //font-awesome icons -->
<script src="js/jquery2.0.3.min.js"></script>
</head>
<body>
<section id="container">
<!--header start-->
<header class="header fixed-top clearfix">
<!--logo start-->
<div class="brand">

    <a href="viewjob.jsp" class="logo">
        JOBS
    </a>
    <div class="sidebar-toggle-box">
        <div class="fa fa-bars"></div>
    </div>
</div>
<!--logo end-->

<div class="nav notify-row" id="top_menu">
    <!--  notification start -->
   
        <!-- settings end -->
        <!-- inbox dropdown start-->
        
                
                
                
                
                
        <!-- inbox dropdown end -->
        <!-- notification dropdown start-->
        
        <!-- notification dropdown end -->
    </ul>
    <!--  notification end -->
</div>
<div class="top-nav clearfix">
    <!--search & user info start-->
    <ul class="nav pull-right top-menu">
        <li>
            <input type="text" class="form-control search" placeholder=" Search">
        </li>
        <!-- user login dropdown start-->
        <li class="dropdown">
           
        </li>
        <!-- user login dropdown end -->
       
    </ul>
    <!--search & user info end-->
</div>
</header>
<!--header end-->
<!--sidebar start-->
<aside>
    <div id="sidebar" class="nav-collapse">
        <!-- sidebar menu start-->
        <div class="leftside-navigation">
            <ul class="sidebar-menu" id="nav-accordion">
                <li>
                    <a href="index.html">
                        <i class=""></i>
                        <span>&nbsp;</span>
                    </a>
                </li>
                
               
                <li>
                    <a href="avdJobHr.html">
                        <i class="fa fa-bullhorn"></i>
                        <span>Back Menu </span>
                    </a>
                </li>
                
               
               
                
                
                
               
            </ul>            </div>
        <!-- sidebar menu end-->
    </div>
</aside>
<!--sidebar end-->
<!--main content start-->
<section id="main-content">
	<section class="wrapper">
		<div class="table-agile-info">
 <div class="panel panel-default">
    <div class="panel-heading">
     <header class="panel-heading" style="color:blue; font-size:25px">
                            <strong>Shortlisted Candidate </strong>
                        </header>
    </div>
    <div>
      <table class="table" ui-jq="footable" ui-options='{
        "paging": {
          "enabled": true
        },
        "filtering": {
          "enabled": true
        },
        "sorting": {
          "enabled": true
        }}'>
        <thead>
          <tr>
            <th data-breakpoints="xs">Job Id</th>
            <th>Title</th>
            <th>Email</th>
            <th>Candidate Id</th>            
          </tr>
        </thead>
        
        <%
        int jid = Integer.parseInt(request.getParameter("jid"));
        
        try
        {
        	Connection con= ConnectDB.getConnect();
        	PreparedStatement ps1 = con.prepareStatement("select * from job,candidate where job.qualities = candidate.qualities");
        	ResultSet rs = ps1.executeQuery();
        	while(rs.next())
        	{
        		PreparedStatement psduplicate = con.prepareStatement("select * from assignjobs");
            	ResultSet rsduplicate = psduplicate.executeQuery();
        		
            	boolean repeated = true;
        		if(rsduplicate.next())
        		{
        			int check_jid = rsduplicate.getInt("jid");
        			String check_title = rsduplicate.getString("title");
        			String check_email = rsduplicate.getString("email");
        			int check_cid = rsduplicate.getInt("cid");
        			
        			if(check_jid == rs.getInt("jid") && check_cid == rs.getInt("cid") && check_title.equals(rs.getString("title")) && check_email.equals(rs.getString("email"))  )
        			{
        				repeated = false;
        			}
        		}
        		
        		
        		
        		if(repeated)
        		{
	        		PreparedStatement psassign = con.prepareStatement("insert into assignjobs values(?,?,?,?)");
	        		psassign.setInt(1, rs.getInt("jid"));
	        		psassign.setString(2, rs.getString("title"));
	        		psassign.setString(3, rs.getString("email"));
	        		psassign.setInt(4, rs.getInt("cid"));
	        		psassign.executeUpdate();
        		}
        	}
        	
        	PreparedStatement ps2 = con.prepareStatement("select * from assignjobs where jid = ?");
        	ps2.setInt(1,jid);
        	ResultSet rs2 = ps2.executeQuery();
        	while(rs2.next())
        	{
		%>
        		<tbody>
		          <tr data-expanded="true">
		            <td><%= rs2.getInt(1) %></td>
		            <td><%= rs2.getString(2) %></td>
		            <td><%= rs2.getString(3) %></td>
		            <td><%= rs2.getInt(4) %></td>
		          </tr>
		        </tbody>
        	<%	
        	}
        	
        	
        	
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        %>
        
      </table>
    </div>
  </div>
</div>
</section>
 
</section>

<!--main content end-->
</section>
<script src="js/bootstrap.js"></script>
<script src="js/jquery.dcjqaccordion.2.7.js"></script>
<script src="js/scripts.js"></script>
<script src="js/jquery.slimscroll.js"></script>
<script src="js/jquery.nicescroll.js"></script>
<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="js/flot-chart/excanvas.min.js"></script><![endif]-->
<script src="js/jquery.scrollTo.js"></script>
</body>
</html>