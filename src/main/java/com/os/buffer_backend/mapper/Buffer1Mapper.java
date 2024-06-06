package com.os.buffer_backend.mapper;

import com.os.buffer_backend.model.domain.Buffer1;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
* @author HAN
* @description 针对表【buffer1】的数据库操作Mapper
* @createDate 2024-06-05 08:50:08
* @Entity generator.domain.Buffer1
*/
@Mapper
@Repository
public interface Buffer1Mapper extends BaseMapper<Buffer1> {
        @Select("SELECT SUBSTRING(Data, 1, 10) AS first_10_characters FROM buffer1 WHERE buffer1_id=#{id}")
        String selectFirstBuffer(@Param("id") Integer buffer1_id);
        @Update("UPDATE buffer1 SET Data = CONCAT(SUBSTRING(Data, 11)) WHERE buffer1_id = #{id}")
        void deleteCharacters(@Param("id") Integer buffer1_id);
        @Update("UPDATE buffer1 SET ContentNum = ContentNum + 1, FreeSpaceNum = FreeSpaceNum - 1 WHERE buffer1_id = #{id}")
        void updateNum(@Param("id") Integer buffer1_id);
        @Update("UPDATE buffer1 SET Message = CONCAT(Message, ';Remove ', #{str}) WHERE buffer1_id = #{id}")
        void updateMessage(@Param("id") Integer buffer1_id, @Param("str") String str);
        @Select("SELECT * FROM buffer1 WHERE buffer1_id=#{id}")
        Buffer1 getbuffer1(@Param("id") Integer buffer1_id);
        @Insert("INSERT INTO buffer1 (`Message`,`DATA`,`ContentNum`,`FreeSpaceNum`) VALUES (null,null,0,#{freeSpaceNum})")
        void insertBuffer1(@org.apache.ibatis.annotations.Param("freeSpaceNum") Integer freeSpaceNum);
        @Select("SELECT LAST_INSERT_ID()")
        int getBuffer1Id();
}




