package com.test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class E implements U, V{

	public static void main(String[] args) {
		U u=new E();
		//u.methodA();

	}

	@Override
	public void methodA() throws FileNotFoundException  {
		System.out.println("dcnscnsdkj");
	}

}

interface V{
	abstract public void methodA() throws IOException;
}
interface U{
	abstract public void methodA() throws FileNotFoundException;
}