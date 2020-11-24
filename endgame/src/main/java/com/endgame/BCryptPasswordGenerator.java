package com.endgame;

import java.util.Scanner;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordGenerator {
	
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		System.out.print("Password: ");
		String password = input.nextLine();
		
		password = passwordEncoder.encode(password);
		
		System.out.println("BCrypted Password: ");
		System.out.println(password);
	}

}
