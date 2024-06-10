package com.os.buffer_backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.os.buffer_backend.model.domain.Result;
import com.os.buffer_backend.service.ResultService;
import com.os.buffer_backend.mapper.ResultMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.os.buffer_backend.mapper.Buffer1Mapper;
import com.os.buffer_backend.mapper.Buffer2Mapper;
import com.os.buffer_backend.mapper.Buffer3Mapper;

import java.util.List;
import java.util.ArrayList;
/**
* @author HAN
* @description 针对表【result】的数据库操作Service实现
* @createDate 2024-06-07 10:44:10
*/
@Service
public class ResultServiceImpl extends ServiceImpl<ResultMapper, Result>
    implements ResultService{
    @Autowired
    private ResultMapper resultMapper;
    @Autowired
    private Buffer1Mapper buffer1Mapper;
    @Autowired
    private Buffer2Mapper buffer2Mapper;
    @Autowired
    private Buffer3Mapper buffer3Mapper;

    @Override
    public void updatebuffer2result(Integer rs_id) {
        resultMapper.updatebuffer2result(rs_id);
    }

    @Override
    public void updatebuffer3result(Integer rs_id) {
        resultMapper.updatebuffer3result(rs_id);
    }
    public Result getBufferResult(Integer id){
        Result res=resultMapper.getResult(id);
        return res;
    }
    public List<Result> putResultHistory(){
        return resultMapper.getResultHistory();
    }
    public List<Integer> getBufferResultNum(Integer buffer1id, Integer buffer2id, Integer buffer3id) {
        List<Integer> resultData = new ArrayList<>();
        resultData.add(buffer1Mapper.getBuffer1ContentNum(buffer1id));
        System.out.println("map:"+buffer1Mapper.getBuffer1ContentNum(buffer1id)+buffer1id);

        resultData.add(buffer2Mapper.getBuffer2ContentNum(buffer2id));
        resultData.add(buffer3Mapper.getBuffer3ContentNum(buffer3id));
        return resultData;
    }
    public void upTimeandAverage(Integer runtime,Integer avgbufferdata,Integer id){
        resultMapper.upTimeandAverage(runtime,avgbufferdata,id);

    }


}




