package com.os.buffer_backend.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName buffer2
 */
@TableName(value ="buffer2")
@Data
public class Buffer2 implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer buffer2Id;

    /**
     * 
     */
    private String message;

    /**
     * 
     */
    private String data;

    /**
     * 
     */
    private Integer contentnum;

    /**
     * 
     */
    private Integer freespacenum;

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
        Buffer2 other = (Buffer2) that;
        return (this.getBuffer2Id() == null ? other.getBuffer2Id() == null : this.getBuffer2Id().equals(other.getBuffer2Id()))
            && (this.getMessage() == null ? other.getMessage() == null : this.getMessage().equals(other.getMessage()))
            && (this.getData() == null ? other.getData() == null : this.getData().equals(other.getData()))
            && (this.getContentnum() == null ? other.getContentnum() == null : this.getContentnum().equals(other.getContentnum()))
            && (this.getFreespacenum() == null ? other.getFreespacenum() == null : this.getFreespacenum().equals(other.getFreespacenum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBuffer2Id() == null) ? 0 : getBuffer2Id().hashCode());
        result = prime * result + ((getMessage() == null) ? 0 : getMessage().hashCode());
        result = prime * result + ((getData() == null) ? 0 : getData().hashCode());
        result = prime * result + ((getContentnum() == null) ? 0 : getContentnum().hashCode());
        result = prime * result + ((getFreespacenum() == null) ? 0 : getFreespacenum().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", buffer2Id=").append(buffer2Id);
        sb.append(", message=").append(message);
        sb.append(", data=").append(data);
        sb.append(", contentnum=").append(contentnum);
        sb.append(", freespacenum=").append(freespacenum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}