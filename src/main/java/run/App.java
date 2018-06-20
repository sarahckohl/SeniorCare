package run;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.seniorcare.beans.User;
import com.revature.seniorcare.service.UserService;

public class App {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		UserService service = (UserService) context.getBean("UserService", UserService.class);
		
		User temp = service.add(new User(0, "Patient", "email2", "test", "test", "test", 6820, "test",
				"test", "test", "license1"));
		
		User temp2 = service.add(new User(1, "Patient", "email1", "test", "test", "test", 6820, "test",
				"test", "test", "license2"));
		
		System.out.println(temp.toString());
		
		List<User> users = service.getAll();
		for(User u : users) {
			System.out.println(u.toString());
		}
		
		System.out.println(service.findByFirstName("testingthisname"));
	}

}
