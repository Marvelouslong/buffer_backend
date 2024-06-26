package com.os.buffer_backend.task;

import com.os.buffer_backend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @auther fyf
 * @date 2018/12/18 - 15:21
 */
@Component
public class GetBuffer implements Runnable {

    private boolean flag = true;
    private Common common;
    String c;
    @Autowired
    private ParamService paramService;
    @Autowired
    private Buffer1Service buffer1Service;
    @Autowired
    private Buffer2Service buffer2Service;
    @Autowired
    private Buffer3Service buffer3Service;

    public GetBuffer() {
    }

    public GetBuffer(ParamService paramService, Common common, Buffer1Service buffer1Service, Buffer2Service buffer2Service, Buffer3Service buffer3Service) {
        this.paramService = paramService;
        this.buffer1Service = buffer1Service;
        this.buffer2Service = buffer2Service;
        this.buffer3Service = buffer3Service;
        this.common = common;
    }

    @Override
    public void run() {
        while (Common.flag) {
            while (common.pause) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "is working");
            String threadName = Thread.currentThread().getName();
            String firstSevenName = threadName.substring(0, Math.min(threadName.length(), 7));
            if (firstSevenName.equals("buffer2")) {
                int id = common.buffer2_id;
                synchronized (common.buffer2) {// 确保对缓冲区的同步访问
                    while (common.buffer2.size() == 0) {//buffer2为空
                        try {
                            common.GetBlockedThreadNum++;
                            common.buffer2.wait();
                            common.GetBlockedThreadNum--;
                            System.out.println("阻塞在getbuffer2");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (common.flag==false)break;
                    while (common.pause) {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    String bu2 = buffer2Service.removeBuffer2(id);
                    buffer2Service.deleteBuffer2(bu2, id);
                    buffer2Service.buffer2Result(common.rs_id);
                    System.out.println("(移动前)buffer2缓冲区:" + common.buffer2);
                    common.buffer2.remove(0);
                    System.out.println("(移动后)buffer2缓冲区:" + common.buffer2);
                    try {
                        Thread.sleep((long) common.getSpeed * 1000);
                        common.buffer2.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            } else if (firstSevenName.equals("buffer3")) {
                int id = common.buffer3_id;
                synchronized (common.buffer3) {// 确保对缓冲区的同步访问
                    while (common.buffer3.size() == 0) {//buffer2为空
                        try {
                            common.GetBlockedThreadNum++;
                            common.buffer3.wait();
                            common.GetBlockedThreadNum--;
                            System.out.println("阻塞在getbuffer3");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (common.flag==false)break;
                    while (common.pause) {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    String bu3 = buffer3Service.removeBuffer3(id);
                    System.out.println("bu:  " + bu3);
                    buffer3Service.deleteBuffer3(bu3, id);
                    buffer3Service.buffer3Result(common.rs_id);
                    System.out.println("(移动前)buffer3缓冲区:" + common.buffer3);

                    common.buffer3.remove(0);
                    System.out.println("(移动后)buffer3缓冲区:" + common.buffer3);
                    try {
                        Thread.sleep((long)  common.getSpeed * 1000);
                        common.buffer3.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
            if (common.flag==false)break;
            while (common.pause) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }
    }
}
   