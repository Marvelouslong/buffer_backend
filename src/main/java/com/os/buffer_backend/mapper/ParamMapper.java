package com.os.buffer_backend.mapper;

import com.os.buffer_backend.model.domain.Buffer1;
import com.os.buffer_backend.model.domain.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import java.util.List;

/**
* @author HAN
* @description 针对表【param】的数据库操作Mapper
* @createDate 2024-06-05 09:18:51
* @Entity generator.domain.Param
*/
@Mapper
public interface ParamMapper extends BaseMapper<Param> {
    @Select("select * from param where p_id=#{id}")
    Param selectParamByPId(@org.apache.ibatis.annotations.Param("id")int id);
    //void insertBuffer1(String message1,String data,Integer contentNum,Integer freeSpaceNum);
    @Select("SELECT * FROM buffer1 WHERE data = "+"?")
    Buffer1 selectByDataValue(String dataValue);
    @Update("UPDATE buffer1 SET Message = CONCAT(IFNULL(Message, ''), 'move', #{str}),`Data` = CONCAT(IFNULL(`Data`, ''), #{str}),ContentNum=ContentNum+1,FreeSpaceNum=FreeSpaceNum-1 WHERE buffer1_id = #{id};")

    //@Update("UPDATE buffer1 SET Message = CONCAT(Message, ';move ', #{str}),`Data`=CONCAT(`Data`, #{str}) WHERE buffer1_id = #{id}")
    void updateBuffer1(@org.apache.ibatis.annotations.Param("str") String str,@org.apache.ibatis.annotations.Param("id") int id);
    //判断BUFFER1是否为空
    @Select("SELECT COUNT(*) FROM buffer1")
    int isBuffer1Null();
    @Insert("INSERT INTO param (buffer1Size, buffer2Size, buffer3Size, putBuffer1Num, moveBuffer2Num, moveBuffer3Num, getBuffer2Num, getBuffer3Num, putSpeed, moveSpeed, getSpeed) VALUES (#{buffer1size}, #{buffer2size}, #{buffer3size}, #{putbuffer1num}, #{movebuffer2num}, #{movebuffer3num},#{getbuffer2num}, #{getbuffer3num}, #{putspeed}, #{movespeed}, #{getspeed})")
    void insertparam(@org.apache.ibatis.annotations.Param("buffer1size") Integer buffer1size, @org.apache.ibatis.annotations.Param("buffer2size") Integer buffer2size, @org.apache.ibatis.annotations.Param("buffer3size") Integer buffer3size, @org.apache.ibatis.annotations.Param("putbuffer1num") Integer putbuffer1num,
                     @org.apache.ibatis.annotations.Param("movebuffer2num") Integer movebuffer2num, @org.apache.ibatis.annotations.Param("movebuffer3num") Integer movebuffer3num, @org.apache.ibatis.annotations.Param("getbuffer2num") Integer getbuffer2num, @org.apache.ibatis.annotations.Param("getbuffer3num") Integer getbuffer3num,
                     @org.apache.ibatis.annotations.Param("putspeed") Integer putspeed, @org.apache.ibatis.annotations.Param("movespeed") Integer movespeed, @org.apache.ibatis.annotations.Param("getspeed") Integer getspeed);
    @Select("SELECT LAST_INSERT_ID()")
    int getParamId();
}




