package com.os.buffer_backend.service;

import com.os.buffer_backend.model.domain.Result;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;


/**
* @author HAN
* @description 针对表【result】的数据库操作Service
* @createDate 2024-06-07 10:44:10
*/
public interface ResultService extends IService<Result> {
    void updatebuffer2result(Integer rs_id);
    void updatebuffer3result(Integer rs_id);
    public Result getBufferResult(Integer id);
    public List<Result> putResultHistory();
    List<Integer> getBufferResultNum(Integer buffer1id, Integer buffer2id, Integer buffer3id);
    public void upTimeandAverage(Integer runtime,Integer avgbufferdata,Integer id);


}
