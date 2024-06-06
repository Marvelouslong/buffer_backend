package com.os.buffer_backend.controller;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/buffer")
@CrossOrigin(origins = {"http://127.0.0.1:5173/"})
@Slf4j
public class buffercontroller {
    @Resource
    private boolean userService;
    @PostMapping("/componets/input.vue")
    public ResultInfo getinput(@RequestBody Map<String,Object> params) {
        System.out.println(params.get("bufisize"));
        return new ResultInfo();
    }


 /*
        //System.out.println("Buffer1Size为"+Integer.valueOf(req.getParameter("buffer1Size")));
        SetParamDao setParamDao = new SetParamDaoImpl();
        setParamDao.setParam(setParam);


        Param params = setParamDao.selectParamsById(1);

        session.setAttribute("param", params);
        ArrayList<BufferData> Buffer1DataList = setParamDao.queryBufferData(1);

        session.setAttribute("buffer1List", Buffer1DataList);



        res.sendRedirect("/MyOsProject/index.jsp");*/

    @GetMapping("/total")
    public boolean getbuffertotal(long id) {
        String buffer = null;
        boolean flag = false;
        if (id <= 0) {
            
        }
        if (buffer == null) {
            
        }
        return flag;
    }

    private class ResultInfo {
    }
}
