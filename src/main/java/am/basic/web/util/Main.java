package am.basic.web.util;

import am.basic.web.model.User;
import am.basic.web.service.Userservice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
    /*    UserrepositoryImpl userrepository1 = new UserrepositoryImpl();
        User user = new User();

        user.setName("Ruben");
        user.setSurname("fadsfgdsag");z
        user.setUsername("fdsfsdhg");
        user.setAge("hgh");
        user.setCode("88hg8");
        user.setPassword("hgfh5252");


        Card card = new Card();
        card.setName("american_express");
        card.setNumber("02413483154");


        user.setCard(card);


        Action action = new Action();
        Action action1 = new Action();

        action.setName("dhjaskhdjksh");
        action.setDescription("sjadgjks");


        action1.setName("dsajkfuj");
        action1.setDescription("fjdsakfhkj");


        List<Action> actions = new ArrayList<>();
        actions.add(action);
        actions.add(action1);
        user.setAction(actions);
        //userrepository1.add(user);

     User fromdb= userrepository1.getbyId(9);

        System.out.println(fromdb);
*/
   /*     UserRepository userRepository=new UserrepositoryImpl();
        UserRepository userRepository1=new UserRepositoryImplJdbc();




        Userservice userservice=new UserServiceimpl(userRepository1);
        User user=userservice.getByUsername("abc");
*/


        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        System.out.println(1);

        Userservice userservice = applicationContext.getBean(Userservice.class);
        Userservice userservice1 = applicationContext.getBean(Userservice.class);


        User user = userservice.getByUsername("abc");

        System.out.println(userservice);
        System.out.println(userservice1);
        System.out.println(userservice.getUserrepositoryImpl());
        System.out.println(userservice1.getUserrepositoryImpl());




        System.out.println("This changed commit");
        System.out.println("This changed commit");
        System.out.println("This changed commit");
        System.out.println("This changed commit");



    }
}
