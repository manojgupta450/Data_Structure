package observerPattern;

import java.util.Calendar;

public class StockDispalyBoard implements Observer,Display{

	
	public void update(Observable observable, Object arg) {
		 StockUpdate su = (StockUpdate)observable;
		 String message = "The stock details of ibm :"+su.getIbm()+" and microsoft :"+su.getMicrosoft()+" at "+Calendar.getInstance().getTime();
		 this.display(message);
	}


	public void display(String msg) {
	System.out.println("StockDispalyBoard");
	System.out.println(msg);
		
	}
	
}
