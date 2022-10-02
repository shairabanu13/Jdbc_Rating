package SH20381390;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Scanner;
	public class JDBC_Rating {

		public static void main(String[] args) throws SQLException {
			// TODO Auto-generated method stub
			Scanner br=new Scanner(System.in);  //for input
			System.out.println("Enter Student name/Subject name");
			String name=br.nextLine();
			//Establishing Connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_rating","root","root");
			Statement st=con.createStatement();//Creating Statement
			
			/************************************************************/
		    String Query="select distinct studentName from assignments";
		    ResultSet rs= st.executeQuery(Query);
		    List Student=new ArrayList();
		    while(rs.next()) {
		    	Student.add(rs.getString(1));
		    }
		    rs.close();
		    
		    /************************************************************/
		    
		    String Query1="select distinct subject from assignments";
		    ResultSet rs1= st.executeQuery(Query1);
		    List Subject=new ArrayList();
		    while(rs1.next()) {
		    	Subject.add(rs1.getString(1));
		    }
		    rs1.close();
		    /************************************************************/
		    
		    if(Student.contains(name)) {
		    	System.out.println("Student List");
		    	String query="SELECT ((40/COUNT(points))*SUM(points))/100 FROM Assignments WHERE studentName=? AND subject='Electro Fields' AND assignment_Category='test'";
				String query1="SELECT ((20/COUNT(points))*SUM(points))/100 FROM Assignments WHERE studentName=? AND subject='Electro Fields' AND assignment_Category='quiz'";
				String query2="SELECT ((10/COUNT(points))*SUM(points))/100 FROM Assignments WHERE studentName=? AND subject='Electro Fields' AND assignment_Category='lab'";
				String query3="SELECT ((30/COUNT(points))*SUM(points))/100 FROM Assignments WHERE studentName=? AND subject='Electro Fields' AND assignment_Category='project'";
				String query4="SELECT ((40/COUNT(points))*SUM(points))/100 FROM Assignments WHERE studentName=? AND subject='Computing Techniques' AND assignment_Category='test'";
				String query5="SELECT ((20/COUNT(points))*SUM(points))/100 FROM Assignments WHERE studentName=? AND subject='Computing Techniques' AND assignment_Category='quiz'";
				String query6="SELECT ((10/COUNT(points))*SUM(points))/100 FROM Assignments WHERE studentName=? AND subject='Computing Techniques' AND assignment_Category='lab'";
				String query7="SELECT ((30/COUNT(points))*SUM(points))/100 FROM Assignments WHERE studentName=? AND subject='Computing Techniques' AND assignment_Category='project'";
				
				
				
				System.out.println("Student:"+name);
				System.out.println(" ");
				System.out.println("subject\t\t\tTestscore\t\tQuizscore\tLabScore\t\tprojectScore\t\tOverallScore");
				System.out.println(" ");
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1,name);
				ResultSet rs2=ps.executeQuery();
				rs2.next();
			    int EFTest=rs2.getInt(1);
			    rs2.close();
			    
			    PreparedStatement ps1=con.prepareStatement(query1);
				ps1.setString(1,name);
				ResultSet rs3=ps1.executeQuery();
			    rs3.next();
			    int EFQuiz=rs3.getInt(1);
			    rs3.close();
			    
			    PreparedStatement ps2=con.prepareStatement(query2);
				ps2.setString(1,name);
				ResultSet rs4=ps2.executeQuery();
			    rs4.next();
			    int EFLab=rs4.getInt(1);
			    rs4.close();
			    
			    PreparedStatement ps3=con.prepareStatement(query3);
				ps3.setString(1,name);
				ResultSet rs5=ps3.executeQuery();
			    rs5.next();
			    int EFProject=rs5.getInt(1);
			    rs5.close();
			    
			    PreparedStatement ps4=con.prepareStatement(query4);
				ps4.setString(1,name);
				ResultSet rs6=ps4.executeQuery();
			    rs6.next();
			    int CTTest=rs6.getInt(1);
			    rs6.close();
			    
			    
			    PreparedStatement ps5=con.prepareStatement(query5);
				ps5.setString(1,name);
				ResultSet rs7=ps5.executeQuery();		  
				rs7.next();
			    int CTQuiz=rs7.getInt(1);
			    rs7.close();
			    
			    
			    PreparedStatement ps6=con.prepareStatement(query6);
				ps6.setString(1,name);
				ResultSet rs8=ps6.executeQuery();
			    rs8.next();
			    int CTLab=rs8.getInt(1);
			    rs8.close();
			    
			    PreparedStatement ps7=con.prepareStatement(query7);
				ps7.setString(1,name);
				ResultSet rs9=ps7.executeQuery();
			    rs9.next();
			    int CTProject=rs9.getInt(1);
			    rs9.close();
			    
			    
			    int OverallEF=EFTest+EFQuiz+EFLab+EFProject;
			    int OverallCT=CTTest+CTQuiz+CTLab+CTProject;

			    System.out.println("Electro Fields"+"\t\t\t"+EFTest+"\t\t\t"+EFQuiz+"\t\t\t"+EFLab+"\t\t\t"+EFProject+"\t\t\t"+OverallEF);//processing results
				System.out.println("Computer Techniques"+"\t"+CTTest+"\t\t\t"+CTQuiz+"\t\t\t"+CTLab+"\t\t\t"+CTProject+"\t\t\t"+OverallCT);//processing

		    	
		    }
		    
		    
		    /******************************************************************************/
		    
		    
		    else if(name.equals(Subject.get(0))) {
		    	int EFTest=0,EFQuiz=0,EFLab=0,EFProject=0,OverallEF=0;
		    	String Stud=null;
		    	for(int i=0;i<Student.size();i++) {
		    		name=(String) Student.get(i);
		    		String query="SELECT ((40/COUNT(points))*SUM(points))/100 FROM Assignments WHERE studentName=? AND subject='Electro Fields' AND assignment_Category='test'";
					String query1="SELECT ((20/COUNT(points))*SUM(points))/100 FROM Assignments WHERE studentName=? AND subject='Electro Fields' AND assignment_Category='quiz'";
					String query2="SELECT ((10/COUNT(points))*SUM(points))/100 FROM Assignments WHERE studentName=? AND subject='Electro Fields' AND assignment_Category='lab'";
					String query3="SELECT ((30/COUNT(points))*SUM(points))/100 FROM Assignments WHERE studentName=? AND subject='Electro Fields' AND assignment_Category='project'";
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1,name);
					ResultSet rs2=ps.executeQuery();
					rs2.next();
				    EFTest=rs2.getInt(1);
				    rs2.close();
				    
				    PreparedStatement ps1=con.prepareStatement(query1);
					ps1.setString(1,name);
					ResultSet rs3=ps1.executeQuery();
				    rs3.next();
				    EFQuiz=rs3.getInt(1);
				    rs3.close();
				    
				    PreparedStatement ps2=con.prepareStatement(query2);
					ps2.setString(1,name);
					ResultSet rs4=ps2.executeQuery();
				    rs4.next();
				   EFLab=rs4.getInt(1);
				    rs4.close();
				    
				    PreparedStatement ps3=con.prepareStatement(query3);
					ps3.setString(1,name);
					ResultSet rs5=ps3.executeQuery();
				    rs5.next();
				    EFProject=rs5.getInt(1);
				    rs5.close();
				    
				    OverallEF=EFTest+EFQuiz+EFLab+EFProject;
				    
				    Stud=(String) Student.get(i);
				    System.out.println(Stud+"\t\t\t"+EFTest+"\t\t\t"+EFQuiz+"\t\t\t"+EFLab+"\t\t\t"+EFProject+"\t\t\t"+OverallEF);//processing results
		    	}
		    	 
		    }
		    
		    /******************************************************************************/
		    
		    else if(name.equals(Subject.get(1))) {
		    	for(int i=0;i<Student.size();i++) {
		    		name=(String) Student.get(i);
		    		String query4="SELECT ((40/COUNT(points))*SUM(points))/100 FROM Assignments WHERE studentName=? AND subject='Computing Techniques' AND assignment_Category='test'";
					String query5="SELECT ((20/COUNT(points))*SUM(points))/100 FROM Assignments WHERE studentName=? AND subject='Computing Techniques' AND assignment_Category='quiz'";
					String query6="SELECT ((10/COUNT(points))*SUM(points))/100 FROM Assignments WHERE studentName=? AND subject='Computing Techniques' AND assignment_Category='lab'";
					String query7="SELECT ((30/COUNT(points))*SUM(points))/100 FROM Assignments WHERE studentName=? AND subject='Computing Techniques' AND assignment_Category='project'";
					
					
					 PreparedStatement ps4=con.prepareStatement(query4);
						ps4.setString(1,name);
						ResultSet rs6=ps4.executeQuery();
					    rs6.next();
					    int CTTest=rs6.getInt(1);
					    rs6.close();
					   
					    
					    
					    PreparedStatement ps5=con.prepareStatement(query5);
						ps5.setString(1,name);
						ResultSet rs7=ps5.executeQuery();		  
						rs7.next();
					    int CTQuiz=rs7.getInt(1);
					    rs7.close();
					    
					    
					    PreparedStatement ps6=con.prepareStatement(query6);
						ps6.setString(1,name);
						ResultSet rs8=ps6.executeQuery();
					    rs8.next();
					    int CTLab=rs8.getInt(1);
					    rs8.close();
					    
					    PreparedStatement ps7=con.prepareStatement(query7);
						ps7.setString(1,name);
						ResultSet rs9=ps7.executeQuery();
					    rs9.next();
					    int CTProject=rs9.getInt(1);
					    rs9.close();
					    
					    int OverallCT=CTTest+CTQuiz+CTLab+CTProject;
					    System.out.println(Student.get(i)+"\t\t"+CTTest+"\t\t\t"+CTQuiz+"\t\t\t"+CTLab+"\t\t\t"+CTProject+"\t\t\t"+OverallCT);//processing

		    	}
		    }
		    
		    /******************************************************************************/
		    else {
		    	System.out.println("no record found");
		    }
		}


}
