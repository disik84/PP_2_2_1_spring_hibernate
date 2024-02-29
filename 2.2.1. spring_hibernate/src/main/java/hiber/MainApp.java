package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        Car bmw = new Car("BMW", 5);
        userService.add(new User("User1", "Lastname1", "user1@mail.ru", bmw));
        Car mazda = new Car("Mazda", 6);
        userService.add(new User("User2", "Lastname2", "user2@mail.ru", mazda));
        Car audi = new Car("Audi", 100);
        userService.add(new User("User3", "Lastname3", "user3@mail.ru", audi));
        Car mercedes = new Car("Mercedes", 600);
        userService.add(new User("User4", "Lastname4", "user4@mail.ru", mercedes));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car " + user.getCar());
            System.out.println();
        }

        List<User> showUser = userService.showUser("Audi", 100);
        for (User user : showUser) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car " + user.getCar());
            System.out.println();
        }

        context.close();
    }
}