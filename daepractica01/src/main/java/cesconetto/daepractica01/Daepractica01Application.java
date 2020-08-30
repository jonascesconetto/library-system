package cesconetto.daepractica01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "cesconetto.daepractica01" })
public class Daepractica01Application {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(Daepractica01Application.class, args);

		// Client -> Pensar em algo como RMI para mobile e rest para WEB
		//ClientMain clientMain = new ClientMain(ctx);
		//clientMain.menu();
	}

//	@Bean
//	public CommandLineRunner comandLineRunner(ApplicationContext ctx){
//		return args ->{
//
//			String[] beansName = ctx.getBeanDefinitionNames();
//
//			System.out.println("\n##############################################");
//			System.out.println("Listing the " + beansName.length + " beans load by Spring Boot");
//
//			Arrays.stream(beansName).sorted().forEach(System.out::println);
//
//			System.out.println("\n####### FIM ##################################");
//		};
//	}
}
