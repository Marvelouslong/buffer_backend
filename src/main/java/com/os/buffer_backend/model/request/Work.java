package com.os.buffer_backend.model.request;

import lombok.Data;

@Data
public class Work {
    String bufferValue;
    String message1;
    String data1;
    Integer ContentNum;
    Integer putbuffernum;
    Integer getbuffernum;
}
