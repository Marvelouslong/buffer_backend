package com.os.buffer_backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.os.buffer_backend.mapper.Buffer2Mapper;
import com.os.buffer_backend.model.domain.Buffer3;
import com.os.buffer_backend.service.Buffer3Service;
import com.os.buffer_backend.mapper.Buffer3Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author HAN
* @description 针对表【buffer3】的数据库操作Service实现
* @createDate 2024-06-05 09:18:10
*/
@Service
public class Buffer3ServiceImpl extends ServiceImpl<Buffer3Mapper, Buffer3>
    implements Buffer3Service{
    @Autowired
    private Buffer3Mapper buffer3Mapper;
    @Override
    public void removeInstr(Integer buffer3_id,String data) {
        buffer3Mapper.updateMessage(buffer3_id,data);
        buffer3Mapper.updateNum(buffer3_id);
        buffer3Mapper.updateData(buffer3_id,data);

    }
}




