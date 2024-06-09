package com.os.buffer_backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.os.buffer_backend.mapper.ResultMapper;
import com.os.buffer_backend.model.domain.Buffer1;
import com.os.buffer_backend.model.domain.Result;
import com.os.buffer_backend.model.request.Work;
import com.os.buffer_backend.service.Buffer1Service;
import com.os.buffer_backend.mapper.Buffer1Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @author HAN
* @description 针对表【buffer1】的数据库操作Service实现
* @createDate 2024-06-05 08:50:08
*/
@Service
public class Buffer1ServiceImpl extends ServiceImpl<Buffer1Mapper, Buffer1>
    implements Buffer1Service{
    @Autowired
    private Buffer1Mapper buffer1Mapper;
    @Autowired
    private ResultMapper resultMapper;
    @Transactional(rollbackFor = Exception.class)
    public String removestr(Integer buffer1_id){
        String firstBuffer = buffer1Mapper.selectFirstBuffer(buffer1_id);

        if (firstBuffer != null) {
            buffer1Mapper.deleteCharacters(buffer1_id);
            buffer1Mapper.updateNum(buffer1_id);
            buffer1Mapper.updateMessage(buffer1_id,firstBuffer);
            return firstBuffer;
        }
        return null;
    }
    public List<Buffer1> putBuffer1History(){
        return buffer1Mapper.getBuffer1History();
    }

    @Override
    public Work getdata(Integer id,Integer rs_id) {
        String data=buffer1Mapper.getBuffer1Data(id);
        Integer ContentNum=buffer1Mapper.getBuffer1ContentNum(id);
        Work work1=new Work();
        work1.setData1(data);
        work1.setContentNum(ContentNum);
        Result result=new Result();
        result=resultMapper.getResult(rs_id);
        work1.setGetbuffernum(result.getGetbuffer1num());
        work1.setPutbuffernum(result.getPutbuffer1num());
        return work1;
    }

}