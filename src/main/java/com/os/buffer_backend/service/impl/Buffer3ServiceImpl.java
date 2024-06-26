package com.os.buffer_backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.os.buffer_backend.mapper.ResultMapper;
import com.os.buffer_backend.model.domain.Buffer3;
import com.os.buffer_backend.model.domain.Result;
import com.os.buffer_backend.model.request.Work;
import com.os.buffer_backend.service.Buffer3Service;
import com.os.buffer_backend.mapper.Buffer3Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    @Autowired
    private ResultMapper resultMapper;
    @Override
    public void removeInstr(Integer buffer3_id,String data) {
        buffer3Mapper.updateMessage(buffer3_id,data);
        buffer3Mapper.updateNum(buffer3_id);
        buffer3Mapper.updateData(buffer3_id,data);

    }
    @Transactional(rollbackFor = Exception.class)
    public String removeBuffer3(Integer buffer3Id) {
        Integer buf3 = buffer3Id;
        String str3 = buffer3Mapper.selectThirdBuffer(buf3);
        System.out.println("buffer3ServiceImply  remove:      " + str3);
        return str3;
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteBuffer3(String str,Integer buffer3Id) {
        Integer b3 = buffer3Id;
        String string=str;
        buffer3Mapper.deleteCharacters3(string,b3);
    }
    @Transactional(rollbackFor = Exception.class)
    public void buffer3Result(int id){
        int b3=id;
        resultMapper.buffer3Result(b3);
    }
    public List<Buffer3> putBuffer3History(){
        return buffer3Mapper.getBuffer3History();
    }
    @Override
    public Work getdata(Integer id, Integer rs_id) {
        String data=buffer3Mapper.getBuffer3Data(id);
        Integer ContentNum=buffer3Mapper.getBuffer3ContentNum(id);
        String message1=buffer3Mapper.getBuffer3Message(id);
        Work work1=new Work();
        work1.setData1(data);
        work1.setContentNum(ContentNum);
        work1.setMessage1(message1);
        Result result=new Result();
        result=resultMapper.getResult(rs_id);
        work1.setGetbuffernum(result.getGetbuffer3num());
        work1.setPutbuffernum(result.getPutbuffer3num());
        return work1;
    }
}




