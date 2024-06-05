package com.os.buffer_backend.mapper;

import com.os.buffer_backend.model.domain.Buffer1;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

/**
* @author HAN
* @description 针对表【buffer1】的数据库操作Mapper
* @createDate 2024-06-05 08:50:08
* @Entity generator.domain.Buffer1
*/
@Mapper
public interface Buffer1Mapper extends BaseMapper<Buffer1> {
        @Select("SELECT SUBSTRING(data, 1, 1) AS first_character FROM buffer WHERE id = ?")
        String selectFirstBuffer(Integer buffer1_id);
        @Delete("UPDATE buffer SET data = CONCAT(SUBSTRING(data, 2)) WHERE id = ?")
        String deleteFirstBuffer(Integer buffer1_id);
}




