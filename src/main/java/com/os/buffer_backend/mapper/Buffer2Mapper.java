package com.os.buffer_backend.mapper;

import com.os.buffer_backend.model.domain.Buffer1;
import com.os.buffer_backend.model.domain.Buffer2;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
* @author HAN
* @description 针对表【buffer2】的数据库操作Mapper
* @createDate 2024-06-05 09:16:38
* @Entity generator.domain.Buffer2
*/
@Mapper
public interface Buffer2Mapper extends BaseMapper<Buffer2> {
    @Insert("INSERT INTO buffer2 (`Message`,`DATA`,`ContentNum`,`FreeSpaceNum`) VALUES (null,null,0,#{freeSpaceNum})")
    void insertBuffer2(@org.apache.ibatis.annotations.Param("freeSpaceNum") Integer freeSpaceNum);
    @Select("SELECT LAST_INSERT_ID()")
    int getBuffer2Id();
    @Update("UPDATE buffer2 SET ContentNum = ContentNum + 1, FreeSpaceNum = FreeSpaceNum - 1 WHERE buffer2_id = #{id}")
    void updateNum(@org.apache.ibatis.annotations.Param("id") Integer id);
    @Update("UPDATE buffer2 SET Message = CONCAT(IFNULL(Message, ''), ';Move', #{str}) WHERE buffer2_id = #{id}")
    void updateMessage(@Param("id") Integer buffer2_id, @Param("str") String str);
    @Update("UPDATE buffer2 SET `Data` = CONCAT(IFNULL(`Data`, ''), #{str}) WHERE buffer2_id = #{id}")
    void updateData(@Param("id") Integer buffer2_id, @Param("str") String str);
    @Select("SELECT * FROM buffer2 WHERE buffer2_id = 1")
    Buffer2 selectBuffer2ById(@Param("buffer2Id") Integer buffer2Id);
    //将要取走的数据保存到first_10_characters
    @Select("SELECT SUBSTRING(Data,1,1) AS first_10_characters FROM buffer2 WHERE buffer2_id=#{id}")
    String selectSecondBuffer(@Param("id") Integer buffer2_id);
    //删除移走的数据
    @Update("UPDATE buffer2 SET `Data`=CONCAT(SUBSTRING(Data,2)),Message = CONCAT(IFNULL(Message, ''), ';Get', #{str}),ContentNum=ContentNum-1,FreeSpaceNum=FreeSpaceNum+1 WHERE buffer2_id=#{id}")
    void deleteCharacters(@Param("str") String str,@Param("id") Integer id);
    @Select("SELECT ContentNum FROM buffer2 WHERE buffer2_id = #{id}")
    Integer getBuffer2ContentNum(@Param("id") int id);
    @Select("SELECT * FROM buffer2")
    List<Buffer2> getBuffer2History();
}




