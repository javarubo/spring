package am.basic.web.model;

import org.springframework.http.converter.json.GsonBuilderUtils;

public class Task extends Thread {

    public void run() {

        for (int i = 0; i < 10; i++) {
            Testtt.test();


            //     System.out.println("task");


            // Thread thread1=Thread.currentThread();

        }

    }
}

