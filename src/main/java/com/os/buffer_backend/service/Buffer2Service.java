package com.os.buffer_backend.service;

import com.os.buffer_backend.model.domain.Buffer2;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author HAN
* @description 针对表【buffer2】的数据库操作Service
* @createDate 2024-06-05 09:16:38
*/
public interface Buffer2Service extends IService<Buffer2> {
    void removeInstr(Integer buffer2_id,String data);
    public Buffer2 getBuffer2ById(Integer buffer2Id);
    public String removeBuffer2(Integer buffer2Id);
    /*public void deleteBuffer2(Integer buffer2Id);*/
    public void deleteBuffer2(String str,Integer buffer2Id);
    public Integer GetBuffer2ConNum(int id);
    public void buffer2Result(int id);
    public List<Buffer2> putBuffer2History();
}
