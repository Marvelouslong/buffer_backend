package com.os.buffer_backend.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName buffer1
 */
@TableName(value ="buffer1")
@Data
public class Buffer1 implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer buffer1_id;

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
        Buffer1 other = (Buffer1) that;
        return (this.getBuffer1_id() == null ? other.getBuffer1_id() == null : this.getBuffer1_id().equals(other.getBuffer1_id()))
            && (this.getMessage() == null ? other.getMessage() == null : this.getMessage().equals(other.getMessage()))
            && (this.getData() == null ? other.getData() == null : this.getData().equals(other.getData()))
            && (this.getContentnum() == null ? other.getContentnum() == null : this.getContentnum().equals(other.getContentnum()))
            && (this.getFreespacenum() == null ? other.getFreespacenum() == null : this.getFreespacenum().equals(other.getFreespacenum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBuffer1_id() == null) ? 0 : getBuffer1_id().hashCode());
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
        sb.append(", buffer1Id=").append(buffer1_id);
        sb.append(", message=").append(message);
        sb.append(", data=").append(data);
        sb.append(", contentnum=").append(contentnum);
        sb.append(", freespacenum=").append(freespacenum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}