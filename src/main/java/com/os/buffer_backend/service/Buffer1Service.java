package com.os.buffer_backend.service;

import com.os.buffer_backend.model.domain.Buffer1;
import com.baomidou.mybatisplus.extension.service.IService;
import com.os.buffer_backend.model.request.Work;

import java.util.List;

/**
* @author HAN
* @description 针对表【buffer1】的数据库操作Service
* @createDate 2024-06-05 08:50:08
*/
public interface Buffer1Service extends IService<Buffer1> {
    String removestr(Integer buffer1_id);
    List<Buffer1> putBuffer1History();
    Work getdata(Integer id,Integer rs_id);
}
