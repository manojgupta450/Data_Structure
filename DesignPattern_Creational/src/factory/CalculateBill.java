package factory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculateBill {
	
	public static void main(String args[]) throws IOException {
		PlanFactory factory=new PlanFactory();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Select Plan Name: ");
		String planName = br.readLine();
		Plan plan = factory.getPlan(planName);
		System.out.println("Select Units");
		int units = Integer.parseInt(br.readLine());
		plan.getRate();
		plan.calculateBill(units);
		
	}

}
