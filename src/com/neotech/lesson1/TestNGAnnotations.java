package com.neotech.lesson1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotations {

	@BeforeClass
	public void boforeClass() {
		System.out.println("This method runs before class!");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("This method runs after class!");
	}

	@BeforeMethod
	public void boforeMethod() {
		System.out.println("This method runs before Method!");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("This method runs after Method!");
	}

	@Test
	public void tese1() {
		System.out.println("This is test1!");
	}
	
	@Test
	public void tese2()
	{
		System.out.println("This is test2!");
	}
	
	@Test
	public void tese3()
	{
		System.out.println("This is test3!");
	}

}
