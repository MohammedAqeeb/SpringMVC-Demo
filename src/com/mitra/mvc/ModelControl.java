package com.mitra.mvc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.mitra.mvc.JDBCHelper;

public class ModelControl {
	
	public String Register(RegBean bean)
	{
		System.out.println("In Model---> register()");
		
		String msg=bean.validate();	
		if(msg.equals("SUCCESS"))
		{
			System.out.println("in model within Register()");
			
			
			Connection con=null;
			PreparedStatement ps_sql=null,p_ins=null;
			ResultSet rs=null;
			
			try {
				
				con=JDBCHelper.getConnection();
				if(con==null)
					return "Connection to Database Error";
				else
				{
					ps_sql=con.prepareStatement("select * from register where email=? and password=?");
					ps_sql.setString(1,bean.getEmail());
					ps_sql.setString(2,bean.getPass());
					ps_sql.execute();
					
					rs=ps_sql.getResultSet();
					
					if(rs.next())
						return "E-Mail already exists";
					else
					{
						p_ins=con.prepareStatement("insert into register(name,email,password) values (?,?,?)");
						p_ins.setString(1,bean.getUname());
						p_ins.setString(2,bean.getEmail());
						p_ins.setString(3,bean.getPass());
						p_ins.execute();
						
						return "SUCCESS";
					}
					   
				}
					
				
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				return "Unable to connect to database..."+e.getMessage();	
			}
		}
		else
		{
			System.out.println("Model->register(), registration has failed! msg = "+msg);
		
			return msg;
		}
		
	}
	public String authenticate(LoginBean bean)
	{
		String msg=bean.validate();
		
		if(msg.equals(Constants.SUCCESS))
		{
			Connection con=null;
			PreparedStatement ps_sql=null;
			ResultSet rs=null;
			
			try {
				con=JDBCHelper.getConnection();
				if(con==null)
					return "Cant Connect to the Database";
				
				else
				{
					ps_sql=con.prepareStatement("Select * from register where email=? and pass=?");
					ps_sql.setString(1,bean.getEmail());
					ps_sql.setString(2,bean.getPass());
					ps_sql.execute();
					
					rs=ps_sql.getResultSet();
					
					if(rs.next())
						return Constants.SUCCESS;
					else
						return "Email and Password Does't Exist";
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				System.out.println("Cant connect to Database"+e.getMessage());
			}
		}
		else
		{
			System.out.println("Model->register(), registration has failed! msg = "+msg);
		
			
		}
		return msg;
		
	}
}
	
				
	

