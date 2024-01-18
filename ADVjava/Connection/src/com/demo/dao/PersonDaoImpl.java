package com.demo.dao;

import java.util.List;
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.demo.beans.Person;

public class PersonDaoImpl implements PersonDao{
	
	static Connection conn;
	static PreparedStatement selperson,insperson, del, modify,selbyid,findsorted; 
	static {
		try {
			conn=DBConn.getConn();
			selperson=conn.prepareStatement("select * from user");
			insperson = conn.prepareStatement("insert into user values (?,?,?,?)");
			modify = conn.prepareStatement("update user set username=?, password=?,email=? where id=?");
			del=conn.prepareStatement("delete from user where id=?");
			selbyid=conn.prepareStatement("select * from user where id=?");
			findsorted=conn.prepareStatement("select * from user order by id");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void save(Person p) {
		try {
			insperson.setString(1,p.getUsername());
			insperson.setString(2,p.getPassword());
			insperson.setString(3,p.getEmail());
			insperson.setInt(4, p.getId());
			int n=insperson.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public void deleteId(int id) {
		try {
			del.setInt(1, id);
			int n =del.executeUpdate();
;		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modifyById(int pid) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter username: ");
		String uname=sc.nextLine();
		System.out.println("Enter Password: ");
		String pwd=sc.nextLine();
		System.out.println("Enter Email: ");
		String em=sc.nextLine();
		try {
			modify.setInt(4, pid);
			modify.setString(1, uname );
			modify.setString(2, pwd);
			modify.setString(3, em);
			int n = modify.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Person> displayAll() {
		List<Person> plist = new ArrayList<>();
		
		try {
			ResultSet rs =selperson.executeQuery();
			while(rs.next()) {
			plist.add(new Person(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return plist;
	}


	@Override
	public List<Person> findSorted() {
		List<Person> plist=new ArrayList<>();
		try {
			ResultSet rs=findsorted.executeQuery();
			while(rs.next()) {
				 plist.add(new Person(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
				
			}
			return plist;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}

	
	@Override
	public Person findById(int id) {
		try {
			selbyid.setInt(1, id);
			ResultSet rs=selbyid.executeQuery();
			if(rs.next()) {
				return new Person(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4));
			}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void closeConnection() {
		DBConn.closeConn();
		
	}
}