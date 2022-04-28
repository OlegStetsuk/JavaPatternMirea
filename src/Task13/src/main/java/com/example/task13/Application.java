ackage com.example.task13;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Application {

    @Value("${program.student.name}")
    String name;

    @Value("${program.student.last_name}")
    String lastName;

    @Value("${program.student.group}")
    String group;

    @PostConstruct
    public void printEnv() {
        System.out.println(name + " " + lastName + " " + group);
    }
}
