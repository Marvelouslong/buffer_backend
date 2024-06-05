package com.os.buffer_backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.os.buffer_backend.model.domain.Param;
import com.os.buffer_backend.service.ParamService;
import com.os.buffer_backend.mapper.ParamMapper;
import org.springframework.stereotype.Service;

/**
* @author HAN
* @description 针对表【param】的数据库操作Service实现
* @createDate 2024-06-05 09:18:51
*/
@Service
public class ParamServiceImpl extends ServiceImpl<ParamMapper, Param>
    implements ParamService{
    public Param getParams(Integer pId){
        Param param=new Param();

        return param;
    }
}




