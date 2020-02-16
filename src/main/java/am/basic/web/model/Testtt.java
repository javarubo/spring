package am.basic.web.model;

import lombok.SneakyThrows;

public class Testtt {
    @SneakyThrows
    public static synchronized void test(){
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName());
    }
}
