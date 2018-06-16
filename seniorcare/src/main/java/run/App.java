package run;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.seniorcare.beans.Patient;
import com.revature.seniorcare.service.PatientService;

public class App {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		PatientService service = (PatientService) context.getBean("PatientService", PatientService.class);
		List<Patient> patients = service.getAll();
		for(Patient p : patients) {
			System.out.println(p.toString());
		}
		
		System.out.println(service.findByName("testingthisname"));
	}

}
