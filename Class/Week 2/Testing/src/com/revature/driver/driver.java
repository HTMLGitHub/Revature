/**
 * 
 */
package com.revature.driver;
import com.revature.testing.Employee;
import com.revature.testing.User;
/**
 * @author bak12
 *
 */
public class driver
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		//Employee e = new User();
		User u = new Employee("Matthew", 36, "mlee", "mlee");
		
		System.out.println(u);
	}

}
