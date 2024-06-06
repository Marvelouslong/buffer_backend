package com.os.buffer_backend;

import com.os.buffer_backend.task.MyThread;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.os.buffer_backend.util.RandomData;
import org.springframework.context.annotation.ComponentScan;

import static com.os.buffer_backend.util.RandomData.generateRandomString;

@SpringBootApplication
@MapperScan("com.os.buffer_backend.mapper") // 假设你的mapper接口在com.os.buffer_backend.mapper包下
@ComponentScan("com.os.buffer_backend.service")
@ComponentScan("com.os.buffer_backend.task")
@ComponentScan("com.os.buffer_backend.model.domain")
public class BufferBackendApplication {

    /*public static void main(String[] args) {SpringApplication.run(BufferBackendApplication.class, args);}*/
    public static void main(String[] args) {
        SpringApplication.run(BufferBackendApplication.class, args);
//        MyThread myThread=new MyThread();
//        Thread thread=new Thread(myThread);
//        thread.start();
    }



}
