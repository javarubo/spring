package am.basic.web.service;


import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Mainreflection {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {

        Class clazz = Class.forName("am.basic.web.model.User");

        Object ob = clazz.newInstance();

        Field field = clazz.getDeclaredField("id");

        field.setAccessible(true);

        field.set(ob, -1);

        System.out.println(ob);

        Field[] fields = clazz.getDeclaredFields();

        for (Field fieldss : fields) {


            Annotation[] annotation = fieldss.getDeclaredAnnotations();

            for (Annotation annotations : annotation) {
                System.out.println(annotations.annotationType());

            }
            System.out.println(fieldss.getName());
            System.out.println();


        }


    }


}
