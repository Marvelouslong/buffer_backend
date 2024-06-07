package com.os.buffer_backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.os.buffer_backend.mapper.Buffer1Mapper;
import com.os.buffer_backend.model.domain.Buffer1;
import com.os.buffer_backend.model.domain.Buffer2;
import com.os.buffer_backend.service.Buffer2Service;
import com.os.buffer_backend.mapper.Buffer2Mapper;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author HAN
* @description 针对表【buffer2】的数据库操作Service实现
* @createDate 2024-06-05 09:16:38
*/
@Service
public class Buffer2ServiceImpl extends ServiceImpl<Buffer2Mapper, Buffer2>
    implements Buffer2Service{
    @Autowired
    private Buffer2Mapper buffer2Mapper;
    @Override
    public void removeInstr(Integer buffer2_id,String data) {
        buffer2Mapper.updateMessage(buffer2_id,data);
        buffer2Mapper.updateNum(buffer2_id);
        buffer2Mapper.updateData(buffer2_id,data);
    }
}




