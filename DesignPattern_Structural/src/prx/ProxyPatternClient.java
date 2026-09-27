package prx;

public class ProxyPatternClient {  
    public static void main(String[] args)   
    {  
        OfficeInternetAccess access = new ProxyInternetAccess("Ashwani Rajput",5);  
        access.grantInternetAccess();  
    }  
} 