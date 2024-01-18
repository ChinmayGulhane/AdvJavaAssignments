package com.demo.test;

import java.util.List;
import java.util.Scanner;
import com.demo.beans.Person;
import com.demo.service.PersonService;
import com.demo.service.PersonServiceImpl;


public class DBConnTestCRUD {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		PersonService pservice = new PersonServiceImpl();
		int choice=0;
		do {
		System.out.println("1. add new product\n2. Delete product\n3. modify product");
		System.out.println("4. display all\n5. display by id\n6. display in sorted order of ID\n 7. exit");
		System.out.println("Choice : ");
		choice=sc.nextInt();
		switch(choice) {
		case 1: 
			pservice.addPerson();
			
			break;
		case 2:
			System.out.println("Enter ID to Delete..");
			int id=sc.nextInt();
			pservice.delById(id);
			
			break;
		case 3:
			System.out.println("Enter id to update");
			int pid=sc.nextInt();
			pservice.update(pid);
			break;
		case 4:
			List<Person>plist =pservice.display();
			plist.forEach(System.out::println);
			break;
		case 5:
			System.out.println("enetr pid");
			id=sc.nextInt();
			Person p=pservice.getById(id);
			if(p!=null) {
				System.out.println(p);
			}
			else {
				System.out.println("not found");
			}
			break;
			
		case 6:
			plist=pservice.displaySorted();
			plist.forEach(System.out::println);
			break;
			
		case 7:
			pservice.closeMyconnection();
			sc.close();
			System.out.println("Thank you for visiting....");
			break;
		default:
			break;
			
		}
		
		
		
		}
		while(choice!=7);
	}

}
