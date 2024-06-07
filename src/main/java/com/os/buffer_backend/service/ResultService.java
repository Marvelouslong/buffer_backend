package com.os.buffer_backend.service;

import com.os.buffer_backend.model.domain.Result;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author HAN
* @description 针对表【result】的数据库操作Service
* @createDate 2024-06-07 10:44:10
*/
public interface ResultService extends IService<Result> {
    void updatebuffer2result(Integer rs_id);
    void updatebuffer3result(Integer rs_id);
}
