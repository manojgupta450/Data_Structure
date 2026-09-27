package observerPattern;

//https://www.youtube.com/watch?v=wiQdrH2YpT4
public class ObserverDemo {
	public static void main(String[] args) {
		StockUpdate su = new StockUpdate();
		MobileDisplay md = new MobileDisplay();
		StockDispalyBoard sd = new StockDispalyBoard();
		su.registerObserver(md);
		su.registerObserver(sd);
		
		su.setIbm(25);
		su.setMicrosoft(30);
		
		su.setIbm(35);
		su.setMicrosoft(34);
		
		
	}
}
