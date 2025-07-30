package ATM;
import java.util.*;
public class AtmOperations 
{
    public static void main(String[] args) 
    {
        //System.out.println("Performing the Creation Account");       
     //   AccountOperations c = new AccountOperations();
        UserOperations uo = new UserOperations();
        ConsoleColors c = new ConsoleColors();
      //  AdminOperations ao = new AdminOperations();
        Scanner sc = new Scanner(System.in);//sc.nextInt();
        boolean flag= true;
        while (flag)
        {
        	System.out.println(c.BLUE +"Welcome to ATM machine"+ c.RESET);
        	System.out.println(c.BLUE +"Choose the Operation you want to perform"+ c.RESET);
        	System.out.println(c.BLUE +"1.User Account"+ c.RESET);
        	System.out.println(c.BLUE +"2.Admin Account"+ c.RESET);
        	int option = sc.nextInt();
        	switch(option)
        	{
        	case 1 -> uo.uoperations();
        	case 2 -> uo.aoperations();
        	//case 3 -> c.viewAccountAsAdmin();
        	default -> System.out.println(c.YELLOW+"Invalid options please choose a correct option"+ c.RESET);
        	}
        	System.out.println(c.BLUE+"For continuing services press 'y' if not 'n'"+ c.RESET);
        	char ch = sc.next().charAt(0);
        	if (ch!='y'&&  ch!='Y') 
        	{
        		flag=false;
        		System.out.println(c.BLUE+"Thank you for using our services"+ c.RESET);
        	}
        	
        	
        }
        
    }
}
