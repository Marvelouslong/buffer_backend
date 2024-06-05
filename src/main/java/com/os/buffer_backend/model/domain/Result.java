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
    private Integer rsId;

    /**
     * 
     */
    private String runtime;

    /**
     * 
     */
    private Integer bufferdatanum;

    /**
     * 
     */
    private Integer putinbuffernum;

    /**
     * 
     */
    private Integer getoutbuffernum;

    /**
     * 
     */
    private Integer avgbuffernum;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Result other = (Result) that;
        return (this.getRsId() == null ? other.getRsId() == null : this.getRsId().equals(other.getRsId()))
            && (this.getRuntime() == null ? other.getRuntime() == null : this.getRuntime().equals(other.getRuntime()))
            && (this.getBufferdatanum() == null ? other.getBufferdatanum() == null : this.getBufferdatanum().equals(other.getBufferdatanum()))
            && (this.getPutinbuffernum() == null ? other.getPutinbuffernum() == null : this.getPutinbuffernum().equals(other.getPutinbuffernum()))
            && (this.getGetoutbuffernum() == null ? other.getGetoutbuffernum() == null : this.getGetoutbuffernum().equals(other.getGetoutbuffernum()))
            && (this.getAvgbuffernum() == null ? other.getAvgbuffernum() == null : this.getAvgbuffernum().equals(other.getAvgbuffernum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRsId() == null) ? 0 : getRsId().hashCode());
        result = prime * result + ((getRuntime() == null) ? 0 : getRuntime().hashCode());
        result = prime * result + ((getBufferdatanum() == null) ? 0 : getBufferdatanum().hashCode());
        result = prime * result + ((getPutinbuffernum() == null) ? 0 : getPutinbuffernum().hashCode());
        result = prime * result + ((getGetoutbuffernum() == null) ? 0 : getGetoutbuffernum().hashCode());
        result = prime * result + ((getAvgbuffernum() == null) ? 0 : getAvgbuffernum().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", rsId=").append(rsId);
        sb.append(", runtime=").append(runtime);
        sb.append(", bufferdatanum=").append(bufferdatanum);
        sb.append(", putinbuffernum=").append(putinbuffernum);
        sb.append(", getoutbuffernum=").append(getoutbuffernum);
        sb.append(", avgbuffernum=").append(avgbuffernum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}