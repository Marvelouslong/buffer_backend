package com.os.buffer_backend.service;

import com.os.buffer_backend.model.domain.Buffer3;
import com.baomidou.mybatisplus.extension.service.IService;
import com.os.buffer_backend.model.request.Work;

import java.util.List;

/**
* @author HAN
* @description 针对表【buffer3】的数据库操作Service
* @createDate 2024-06-05 09:18:10
*/
public interface Buffer3Service extends IService<Buffer3> {
    void removeInstr(Integer buffer2_id,String data);
    public String removeBuffer3(Integer buffer3Id);
    public void deleteBuffer3(String str,Integer buffer3Id);
    public void  buffer3Result(int id);
    public List<Buffer3> putBuffer3History();
    Work getdata(Integer id, Integer rs_id);
}
