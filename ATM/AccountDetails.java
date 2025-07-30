package ATM;

public class AccountDetails 
{
	 ConsoleColors c = new ConsoleColors();
	private int uid;
	private String username;
    private String location;
    private double accountNumber;
    private int pin;
    private double balance;
    
    public AccountDetails()
    {}
   // public Account(int )
    //setBalance(balance);
    public AccountDetails(int uid,String username,String location,double accountNumber)
    {
    	this.username=username;
    	this.location=location;
    	this.accountNumber=accountNumber;
    	//setPin(pin);
    	
    	this.uid=uid;
    }
    
   
    public String getUsername() 
    {
    	return username;
    }
    
    public double getBalance() 
    {
    	return balance;
    }
    public int getUid()
    {
    	return uid;
    }
    public String getLocation()
    {
    	return location;
    }
    public double getAccountNumber()
    {
    	return accountNumber;
    }
    public int getPin()
    {
    	return pin;
    }
    
    public void setPin(int pin)
    {
    	if (pin>999) this.pin=pin;
    	else System.out.println(c.YELLOW+"Enter PIN with more than 4 digits"+c.RESET);
    }
    public void setBalance(double balance) 
    {
    	if((balance>=0) && (balance%100==0)) this.balance=balance;
    	else System.out.println(c.YELLOW+"enter valid amount greater than 100"+c.RESET);	
    }
    public String toString() {
		return c.GREEN+"User id is: "+getUid()+"\n"+"User Name is: "+getUsername()+"\n"+"Location is: "+getLocation()+"\n"+"Account Number is "+getAccountNumber()+ "\n"+"Account Balance is "+getBalance()+c.RESET;
    
}
}
