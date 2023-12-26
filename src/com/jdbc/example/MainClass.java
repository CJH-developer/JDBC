package com.jdbc.example;

import java.util.Scanner;

public class MainClass {
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		Scanner sc = new Scanner(System.in);
		SelectEx se = new SelectEx();
		
		System.out.println("부서아이디");
		int id = sc.nextInt();
		
//		System.out.println("부사명");
//		String name = sc.next();
//		
//		System.out.println("매니저 아아디");
//		String mId = sc.next();
		
		//se.insertOne(id, name, mId);
		//se.updateOne(id, name, mId);
		
		se.deleteOne(id);
	}
}
