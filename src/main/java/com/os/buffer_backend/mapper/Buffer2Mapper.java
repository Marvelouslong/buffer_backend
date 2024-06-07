package com.os.buffer_backend.mapper;

import com.os.buffer_backend.model.domain.Buffer1;
import com.os.buffer_backend.model.domain.Buffer2;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
* @author HAN
* @description 针对表【buffer2】的数据库操作Mapper
* @createDate 2024-06-05 09:16:38
* @Entity generator.domain.Buffer2
*/
public interface Buffer2Mapper extends BaseMapper<Buffer2> {
    @Insert("INSERT INTO buffer2 (`Message`,`DATA`,`ContentNum`,`FreeSpaceNum`) VALUES (null,null,0,#{freeSpaceNum})")
    void insertBuffer2(@org.apache.ibatis.annotations.Param("freeSpaceNum") Integer freeSpaceNum);
    @Select("SELECT LAST_INSERT_ID()")
    int getBuffer2Id();
    @Update("UPDATE buffer2 SET ContentNum = ContentNum + 1, FreeSpaceNum = FreeSpaceNum - 1 WHERE buffer2_id = #{id}")
    void updateNum(@org.apache.ibatis.annotations.Param("id") Integer id);
    @Update("UPDATE buffer2 SET Message = CONCAT(IFNULL(Message, ''), ';RemoveIn ', #{str}) WHERE buffer2_id = #{id}")
    void updateMessage(@Param("id") Integer buffer2_id, @Param("str") String str);
    @Update("UPDATE buffer2 SET `Data` = CONCAT(IFNULL(`Data`, ''), #{str}) WHERE buffer2_id = #{id}")
    void updateData(@Param("id") Integer buffer2_id, @Param("str") String str);
}




