package com.os.buffer_backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.os.buffer_backend.mapper.Buffer1Mapper;
import com.os.buffer_backend.model.domain.Buffer1;
import com.os.buffer_backend.model.domain.Buffer2;
import com.os.buffer_backend.service.Buffer2Service;
import com.os.buffer_backend.mapper.Buffer2Mapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
* @author HAN
* @description 针对表【buffer2】的数据库操作Service实现
* @createDate 2024-06-05 09:16:38
*/
@Service
public class Buffer2ServiceImpl extends ServiceImpl<Buffer2Mapper, Buffer2>
    implements Buffer2Service{
    @Resource
    private Buffer2Mapper buffer2Mapper;
    @Override
    public String removeIn10str(Integer buffer2_id) {
        return null;
    }

    @Override
    public Buffer2 getbuffer2(Integer buffer2_id) {
        Buffer2 buffer2 = buffer2Mapper.getbuffer2(buffer2_id);
        return buffer2;
    }
}




