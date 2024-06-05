package com.os.buffer_backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.os.buffer_backend.model.domain.Result;
import com.os.buffer_backend.service.ResultService;
import com.os.buffer_backend.mapper.ResultMapper;
import org.springframework.stereotype.Service;

/**
* @author HAN
* @description 针对表【result】的数据库操作Service实现
* @createDate 2024-06-05 09:18:58
*/
@Service
public class ResultServiceImpl extends ServiceImpl<ResultMapper, Result>
    implements ResultService{

}




