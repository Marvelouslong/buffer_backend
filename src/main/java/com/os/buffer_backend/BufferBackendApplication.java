package com.os.buffer_backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.os.BufferBackend.Mapper")
public class BufferBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BufferBackendApplication.class, args);
    }

}
