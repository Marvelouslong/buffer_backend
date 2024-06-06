package com.os.buffer_backend.model.request;

import lombok.Data;

import java.io.Serializable;
@Data
public class ParamRequest {
    private Integer buffer1size;

    private Integer buffer2size;

    private Integer buffer3size;

    private Integer putbuffer1num;

    private Integer movebuffer2num;

    private Integer movebuffer3num;

    private Integer getbuffer2num;

    private Integer getbuffer3num;

    private Integer putspeed;

    private Integer movespeed;

    private Integer getspeed;
}
