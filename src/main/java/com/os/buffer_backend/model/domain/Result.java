package com.os.buffer_backend.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName result
 */
@TableName(value ="result")
@Data
public class Result implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer rs_id;

    /**
     * 
     */
    private String runtime;

    /**
     * 
     */
    private Integer putbuffer1num;

    /**
     * 
     */
    private Integer putbuffer2num;

    /**
     * 
     */
    private Integer putbuffer3num;

    /**
     * 
     */
    private Integer getbuffer1num;

    /**
     * 
     */
    private Integer getbuffer2num;

    /**
     * 
     */
    private Integer getbuffer3num;

    /**
     * 
     */
    private Integer avgbuffernum;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}