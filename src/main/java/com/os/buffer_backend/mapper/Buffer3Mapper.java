package com.os.buffer_backend.mapper;

import com.os.buffer_backend.model.domain.Buffer3;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
* @author HAN
* @description 针对表【buffer3】的数据库操作Mapper
* @createDate 2024-06-05 09:18:10
* @Entity generator.domain.Buffer3
*/
public interface Buffer3Mapper extends BaseMapper<Buffer3> {
    @Insert("INSERT INTO buffer3 (`Message`,`DATA`,`ContentNum`,`FreeSpaceNum`) VALUES (null,null,0,#{freeSpaceNum})")
    void insertBuffer3(@org.apache.ibatis.annotations.Param("freeSpaceNum") Integer freeSpaceNum);
    @Select("SELECT LAST_INSERT_ID()")
    int getBuffer3Id();
}




