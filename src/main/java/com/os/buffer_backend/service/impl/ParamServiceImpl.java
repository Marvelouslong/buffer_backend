package com.os.buffer_backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.os.buffer_backend.model.domain.Buffer1;
import com.os.buffer_backend.model.domain.Param;
import com.os.buffer_backend.service.ParamService;
import com.os.buffer_backend.mapper.ParamMapper;
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
    public Param getParams(Integer pId){
        Param param=new Param();

        return param;
    }

    @Transactional(rollbackFor = Exception.class)
    public Param readParmById(){
        //Integer paramId=1;
        //System.out.println(paramId);
        //Param p=
        Param pm = paramMapper.selectParamByPId();
        if (pm != null) {
            System.out.println("从数据库里取Param:  "+pm);
            return pm;
        }
        return null;
    }
    @Transactional(rollbackFor = Exception.class)
    public boolean insertBuffer1s(String message,String data,Integer contentNum,Integer freeSpaceNum){
        if(message!=null&data!=null&contentNum!=null&freeSpaceNum!=null){
            System.out.println("insert:  "+message+data+contentNum+freeSpaceNum);
            paramMapper.insertBuffer1(message,data,contentNum,freeSpaceNum);
            return true;
        }
        /*String message=buf1.getMessage();
        String data=buf1.getData();
        Integer contentNum=buf1.getContentnum();
        Integer freeSpaceNum=buf1.getFreespacenum();*/
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
    public boolean isOrNotBuffer1Null(){
        if(paramMapper.isBuffer1Null()){
            return true;
        }
        return false;
    }

}




