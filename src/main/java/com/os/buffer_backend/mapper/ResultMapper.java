package com.os.buffer_backend.mapper;

import com.os.buffer_backend.model.domain.Buffer1;
import com.os.buffer_backend.model.domain.Result;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
* @author HAN
* @description 针对表【result】的数据库操作Mapper
* @createDate 2024-06-07 10:44:10
* @Entity generator.domain.Result
*/
@Mapper
public interface ResultMapper extends BaseMapper<Result> {
    @Insert("INSERT INTO result (`Runtime`,`putBuffer1Num`,`putBuffer2Num`,`putBuffer3Num`,`getBuffer1Num`,`getBuffer2Num`,`getBuffer3Num`,`AvgBufferNum`) VALUES (0,0,0,0,0,0,0,0)")
    void init();
    @Select("SELECT LAST_INSERT_ID()")
    int getresultId();
    @Update("UPDATE result SET getBuffer1Num = getBuffer1Num + 1, putBuffer2Num = putBuffer2Num + 1 WHERE rs_id = #{id}")
    void updatebuffer2result(@org.apache.ibatis.annotations.Param("id") Integer id);
    @Update("UPDATE result SET getBuffer1Num = getBuffer1Num + 1, putBuffer3Num = putBuffer3Num + 1 WHERE rs_id = #{id}")
    void updatebuffer3result(@org.apache.ibatis.annotations.Param("id") Integer id);
    @Update("UPDATE result SET putBuffer1Num = putBuffer1Num + 1 WHERE rs_id = #{id}")
    void updatebuffer1result(@org.apache.ibatis.annotations.Param("id") Integer id);
    @Update("UPDATE result SET getBuffer2Num = getBuffer2Num + 1 WHERE rs_id = #{id}")
    void buffer2Result(@org.apache.ibatis.annotations.Param("id") Integer id);
    @Update("UPDATE result SET getBuffer3Num = getBuffer3Num + 1 WHERE rs_id = #{id}")
    void buffer3Result(@org.apache.ibatis.annotations.Param("id") Integer id);
    @Select("SELECT * FROM result WHERE rs_id = #{id}")
    Result getResult(@org.apache.ibatis.annotations.Param("id") Integer id);
    @Select("SELECT * FROM result;")
    List<Result> getResultHistory();

}




