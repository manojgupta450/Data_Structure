package prx;

public class ProxyInternetAccess implements OfficeInternetAccess {  
    private String employeeName; 
    private int role;
    private RealInternetAccess  realaccess;  
        public ProxyInternetAccess(String employeeName,int role) {  
     this.employeeName = employeeName;  
     this.role=role;
 }  
 @Override  
 public void grantInternetAccess()   
 {  
     if (getRole(employeeName) > 4)   
     {  
         realaccess = new RealInternetAccess(employeeName);  
         realaccess.grantInternetAccess();  
     }   
     else   
     {  
         System.out.println("No Internet access granted. Your job level is below 5");  
     }  
 }  
 public int getRole(String emplName) {  
     // Check role from the database based on Name and designation  
     // return job level or job designation.  
     return role;  
 }  
}  
