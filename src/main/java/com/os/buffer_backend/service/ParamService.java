package com.os.buffer_backend.service;

import com.os.buffer_backend.model.domain.Buffer1;
import com.os.buffer_backend.model.domain.Param;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
* @author HAN
* @description 针对表【param】的数据库操作Service
* @createDate 2024-06-05 09:18:51
*/

@Service
public interface ParamService extends IService<Param> {
    Param getParams(Integer pId);

    Param readParmById();
    public boolean insertBuffer1s(String message,String data,Integer contentNum,Integer freeSpaceNum);
    //public boolean insertBuffer1s(Buffer1 buf1);
    public void selectBuffer1ByData();
    public void updateBuffer1Values(String str,int id);
    public boolean isOrNotBuffer1Null();

}
