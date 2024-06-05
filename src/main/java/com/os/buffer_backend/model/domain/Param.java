package com.os.buffer_backend.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName param
 */
@TableName(value ="param")
@Data
public class Param implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer pId;

    /**
     * 
     */
    private Integer buffer1size;

    /**
     * 
     */
    private Integer buffer2size;

    /**
     * 
     */
    private Integer buffer3size;

    /**
     * 
     */
    private Integer putbuffer1num;

    /**
     * 
     */
    private Integer movebuffer2num;

    /**
     * 
     */
    private Integer movebuffer3num;

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
    private Integer putspeed;

    /**
     * 
     */
    private Integer movespeed;

    /**
     * 
     */
    private Integer getspeed;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pId=").append(pId);
        sb.append(", buffer1size=").append(buffer1size);
        sb.append(", buffer2size=").append(buffer2size);
        sb.append(", buffer3size=").append(buffer3size);
        sb.append(", putbuffer1num=").append(putbuffer1num);
        sb.append(", movebuffer2num=").append(movebuffer2num);
        sb.append(", movebuffer3num=").append(movebuffer3num);
        sb.append(", getbuffer2num=").append(getbuffer2num);
        sb.append(", getbuffer3num=").append(getbuffer3num);
        sb.append(", putspeed=").append(putspeed);
        sb.append(", movespeed=").append(movespeed);
        sb.append(", getspeed=").append(getspeed);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}