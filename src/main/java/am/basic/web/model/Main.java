package am.basic.web.model;

import lombok.SneakyThrows;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {


        Thread thread = new Task();
        thread.start();

        for (int i = 0; i < 10; i++) {
            Testtt.test();

        }


        // thread.join();

        System.out.println("end of main");


    }


}
