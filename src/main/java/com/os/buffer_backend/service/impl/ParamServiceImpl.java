package com.os.buffer_backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.os.buffer_backend.mapper.*;
import com.os.buffer_backend.model.domain.Buffer1;
import com.os.buffer_backend.model.domain.Param;
import com.os.buffer_backend.service.Buffer1Service;
import com.os.buffer_backend.service.Buffer2Service;
import com.os.buffer_backend.service.Buffer3Service;
import com.os.buffer_backend.service.ParamService;
import com.os.buffer_backend.task.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* @author HAN
* @description 针对表【param】的数据库操作Service实现
* @createDate 2024-06-05 09:18:51
*/
@Service
public class ParamServiceImpl extends ServiceImpl<ParamMapper, Param>
    implements ParamService{
    @Autowired
    private ParamMapper paramMapper;
    @Autowired
    private Buffer1Mapper buffer1Mapper;
    @Autowired
    private Buffer2Mapper buffer2Mapper;
    @Autowired
    private Buffer3Mapper buffer3Mapper;
    @Autowired
    private ResultMapper resultMapper;
    @Transactional(rollbackFor = Exception.class)
    public Param readParmById(){
        //Integer paramId=1;
        //System.out.println(paramId);
        //Param p=
        Common common=new Common();
        Param pm = paramMapper.selectParamByPId(common.p_id);
        if (pm != null) {
            return pm;
        }
        return null;
    }
    @Transactional(rollbackFor = Exception.class)
    public boolean insertBuffer1s(Buffer1 buffer1){
        if(buffer1!=null){
            System.out.println("INSERT............");
            String message=buffer1.getMessage();
            String data=buffer1.getData();
            Integer contentNum=buffer1.getContentnum();
            Integer freeSpaceNum=buffer1.getFreespacenum();
            System.out.println(message);
            return true;
        }
        return false;
    }

    @Transactional(rollbackFor = Exception.class)
    public void selectBuffer1ByData(){
        Buffer1 bf=paramMapper.selectByDataValue("2");
        System.out.println(bf);
    }
    @Transactional(rollbackFor = Exception.class)
    public void updateBuffer1Values(String str,int id){
        paramMapper.updateBuffer1(str,id);
        System.out.println("更新中！");
    }
    //判断表Buffer1是否为空
    @Transactional(rollbackFor = Exception.class)
    public boolean isOrNotBuffer1Null(){
        if(paramMapper.isBuffer1Null()>0){
            return true;
        }
        return false;
    }
    @Override
    public void register(Integer buffer1size, Integer buffer2size, Integer buffer3size, Integer putbuffer1num, Integer movebuffer2num, Integer movebuffer3num, Integer getbuffer2num, Integer getbuffer3num, Integer putspeed, Integer movespeed, Integer getspeed) {
        Param param=new Param();
        paramMapper.insertparam(buffer1size,buffer2size,buffer3size,putbuffer1num,movebuffer2num,movebuffer3num,
                getbuffer2num,getbuffer3num,putspeed,movespeed,getspeed);
        Integer p_id=paramMapper.getParamId();
        buffer1Mapper.insertBuffer1(buffer1size);
        Integer buffer1_id=buffer1Mapper.getBuffer1Id();
        buffer2Mapper.insertBuffer2(buffer2size);
        Integer buffer2_id=buffer2Mapper.getBuffer2Id();
        buffer3Mapper.insertBuffer3(buffer3size);
        Integer buffer3_id=buffer3Mapper.getBuffer3Id();
        resultMapper.init();
        Integer rs_id=resultMapper.getresultId();
        Common common=new Common(p_id,buffer1_id,buffer2_id,buffer3_id,rs_id);
    }
    public void updateResult1(int id){
        int id1=id;
        resultMapper.updatebuffer1result(id1);
    }

}




