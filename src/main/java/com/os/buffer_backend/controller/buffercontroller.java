package com.os.buffer_backend.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;

@RestController
@RequestMapping("/buffer")
@CrossOrigin(origins = {"http://127.0.0.1:5173/"})
@Slf4j
public class buffercontroller {
    @Resource
    private boolean userService;
    @PostMapping("/getbuffer")
    public boolean GetBuffer(HttpServletRequest request) {
        boolean flag=false;
        return flag;
    }
    @GetMapping("/get")
    public boolean getbufferId(long id) {
        String buffer = null;
        boolean flag = false;
        if (id <= 0) {
            
        }
        if (buffer == null) {
            
        }
        return flag;
    }
}
