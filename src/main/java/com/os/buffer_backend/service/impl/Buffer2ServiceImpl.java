package com.os.buffer_backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.os.buffer_backend.mapper.ResultMapper;
import com.os.buffer_backend.model.domain.Buffer2;
import com.os.buffer_backend.service.Buffer2Service;
import com.os.buffer_backend.mapper.Buffer2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    @Autowired
    private ResultMapper resultMapper;
    @Override
    public void removeInstr(Integer buffer2_id,String data) {
        buffer2Mapper.updateMessage(buffer2_id,data);
        buffer2Mapper.updateNum(buffer2_id);
        buffer2Mapper.updateData(buffer2_id,data);
    }
    @Transactional(rollbackFor = Exception.class)
    public Buffer2 getBuffer2ById(Integer buffer2Id) {
        Buffer2 bu = buffer2Mapper.selectBuffer2ById(buffer2Id);
        if (bu != null) {
            System.out.println("buffer2ServiceImpl:      " + bu); // 这将打印整个 Buffer2 对象的 toString() 方法的结果
            return bu;
        }
        return null; // 如果没有找到对应的 Buffer2 对象，则返回 null
    }

    @Transactional(rollbackFor = Exception.class)
    public String removeBuffer2(Integer buffer2Id) {
        Integer b2 = buffer2Id;
        String rbu = buffer2Mapper.selectSecondBuffer(b2);
        System.out.println("buffer2ServiceImply  remove:      " + rbu);
        return rbu;
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteBuffer2(String str,Integer buffer2Id) {
        Integer b2 = buffer2Id;
        String string=str;
        buffer2Mapper.deleteCharacters(str,b2);
    }
    @Transactional(rollbackFor = Exception.class)
    public Integer GetBuffer2ConNum(int id){
        int id1=id;
        Integer contentNum1=buffer2Mapper.getBuffer2ContentNum(id1);
        System.out.println("contentNum:  "+contentNum1);
        return contentNum1;
    }
    @Transactional(rollbackFor = Exception.class)
    public void buffer2Result(int id){
        int b2=id;
        resultMapper.buffer2Result(b2);
    }
    public List<Buffer2> putBuffer2History(){
        return buffer2Mapper.getBuffer2History();
    }
}




