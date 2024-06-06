package com.os.buffer_backend.service;

import com.os.buffer_backend.model.domain.Buffer1;
import com.os.buffer_backend.model.domain.Buffer2;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author HAN
* @description 针对表【buffer2】的数据库操作Service
* @createDate 2024-06-05 09:16:38
*/
public interface Buffer2Service extends IService<Buffer2> {
    String removeIn10str(Integer buffer2_id);
    Buffer2 getbuffer2(Integer buffer2_id);
}
