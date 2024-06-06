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
    @Select("select * from param where p_id=1")
    Param selectParamByPId();
    //@Insert("INSERT INTO buffer1 (`Message`,`DATA`,`ContentNum`,`FreeSpaceNum`) VALUES (?,?,?,?);")
    @Insert("INSERT INTO buffer1 (`Message`,`DATA`,`ContentNum`,`FreeSpaceNum`) VALUES (#{message},#{data},#{contentNum},#{freeSpaceNum})")
    void insertBuffer1(@org.apache.ibatis.annotations.Param("message") String message, @org.apache.ibatis.annotations.Param("data") String data, @org.apache.ibatis.annotations.Param("contentNum") Integer contentNum, @org.apache.ibatis.annotations.Param("freeSpaceNum") Integer freeSpaceNum);

    //void insertBuffer1(String message1,String data,Integer contentNum,Integer freeSpaceNum);
    @Select("SELECT * FROM buffer1 WHERE data = "+"?")
    Buffer1 selectByDataValue(String dataValue);
    //更新
    @Update("UPDATE buffer1 SET Message = CONCAT(Message, ';Remove ', #{str}) WHERE buffer1_id = #{id}")
    void updateBuffer1(String str,int id);
    //判断BUFFER1是否为空
    @Select("SELECT COUNT(*) FROM buffer1")
    int isBuffer1Null();
    //得到BUFFER1的id
    @Select("SELECT LAST_INSERT_ID()")
    public int getBuffer1Id();

}




