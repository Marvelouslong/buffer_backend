package com.os.buffer_backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.os.buffer_backend.util.RandomData;
import org.springframework.context.annotation.ComponentScan;

import static com.os.buffer_backend.util.RandomData.generateRandomString;

@SpringBootApplication
@MapperScan("com.os.buffer_backend.mapper")
@ComponentScan("com.os.buffer_backend.service")
@ComponentScan("com.os.buffer_backend.task")
@ComponentScan("com.os.buffer_backend.model.domain")
@ComponentScan("com.os.buffer_backend.controller")
@ComponentScan("com.os.buffer_backend.config")
public class BufferBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(BufferBackendApplication.class, args);
    }
}
