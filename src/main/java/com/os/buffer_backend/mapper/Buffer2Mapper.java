package com.os.buffer_backend.mapper;

import com.os.buffer_backend.model.domain.Buffer1;
import com.os.buffer_backend.model.domain.Buffer2;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
* @author HAN
* @description 针对表【buffer2】的数据库操作Mapper
* @createDate 2024-06-05 09:16:38
* @Entity generator.domain.Buffer2
*/
public interface Buffer2Mapper extends BaseMapper<Buffer2> {
    @Select("SELECT * FROM buffer2 WHERE buffer2_id=#{id}")
    Buffer2 getbuffer2(@Param("id") Integer buffer2_id);
    @Insert("INSERT INTO buffer2 (`Message`,`DATA`,`ContentNum`,`FreeSpaceNum`) VALUES (null,null,0,#{freeSpaceNum})")
    void insertBuffer2(@org.apache.ibatis.annotations.Param("freeSpaceNum") Integer freeSpaceNum);
    @Select("SELECT LAST_INSERT_ID()")
    int getBuffer2Id();
}




