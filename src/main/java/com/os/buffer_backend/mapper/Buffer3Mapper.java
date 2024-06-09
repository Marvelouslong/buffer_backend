package com.os.buffer_backend.mapper;

import com.os.buffer_backend.model.domain.Buffer1;
import com.os.buffer_backend.model.domain.Buffer2;
import com.os.buffer_backend.model.domain.Buffer3;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.springframework.jmx.export.annotation.ManagedNotification;

import java.util.List;

/**
* @author HAN
* @description 针对表【buffer3】的数据库操作Mapper
* @createDate 2024-06-05 09:18:10
* @Entity generator.domain.Buffer3
*/
@Mapper
public interface Buffer3Mapper extends BaseMapper<Buffer3> {
    @Insert("INSERT INTO buffer3 (`Message`,`DATA`,`ContentNum`,`FreeSpaceNum`) VALUES (null,null,0,#{freeSpaceNum})")
    void insertBuffer3(@org.apache.ibatis.annotations.Param("freeSpaceNum") Integer freeSpaceNum);
    @Select("SELECT LAST_INSERT_ID()")
    int getBuffer3Id();
    @Update("UPDATE buffer3 SET ContentNum = ContentNum + 1, FreeSpaceNum = FreeSpaceNum - 1 WHERE buffer3_id = #{id}")
    void updateNum(@org.apache.ibatis.annotations.Param("id") Integer id);
    @Update("UPDATE buffer3 SET Message = CONCAT(IFNULL(Message, ''), ';Move', #{str}) WHERE buffer3_id = #{id}")
    void updateMessage(@Param("id") Integer buffer3_id, @Param("str") String str);
    @Update("UPDATE buffer3 SET `Data` = CONCAT(IFNULL(`Data`, ''), #{str}) WHERE buffer3_id = #{id}")
    void updateData(@Param("id") Integer buffer3_id, @Param("str") String str);
    @Select("SELECT SUBSTRING(Data,1,1) AS first_10_characters FROM buffer3 WHERE buffer3_id=#{id}")
    String selectThirdBuffer(@Param("id") Integer buffer3_id);
    //删除移走的数据
    @Update("UPDATE buffer3 SET `Data`=CONCAT(SUBSTRING(Data,2)),Message = CONCAT(IFNULL(Message, ''), ';Get', #{str}),ContentNum=ContentNum-1,FreeSpaceNum=FreeSpaceNum+1 WHERE buffer3_id=#{id}")
    void deleteCharacters3(@Param("str") String str,@Param("id") Integer id);
    @Select("SELECT * FROM buffer3")
    List<Buffer3> getBuffer3History();
    @Select("SELECT `Data` FROM buffer3 WHERE buffer3_id=#{id}")
    String getBuffer3Data(@org.apache.ibatis.annotations.Param("id") Integer id);
    @Select("SELECT ContentNum FROM buffer3 WHERE buffer3_id=#{id}")
    Integer getBuffer3ContentNum(@org.apache.ibatis.annotations.Param("id") Integer id);
}




