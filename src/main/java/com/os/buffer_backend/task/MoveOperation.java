package com.os.buffer_backend.task;

import com.os.buffer_backend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MoveOperation implements Runnable{
    private boolean flag = true;
    private Common common;
    private String tmpdata;
    @Autowired
    private ParamService paramService;
    @Autowired
    private Buffer1Service buffer1Service;
    @Autowired
    private Buffer2Service buffer2Service;
    @Autowired
    private Buffer3Service buffer3Service;
    @Autowired
    private ResultService resultService;
    public MoveOperation(ParamService paramService,Common common,Buffer1Service buffer1Service,Buffer2Service buffer2Service,Buffer3Service buffer3Service,ResultService resultService) {
        this.paramService=paramService;
        this.common = common;
        this.buffer1Service=buffer1Service;
        this.buffer2Service=buffer2Service;
        this.buffer3Service=buffer3Service;
        this.resultService=resultService;
    }
    @Override
    public void run() {
        //while (Common.flag) {
        System.out.println(Thread.currentThread().getName() + " is working...");
        String threadName = Thread.currentThread().getName();
        String firstSevenName = threadName.substring(0, Math.min(threadName.length(), 7));
        synchronized (Common.buffer1) {
            while (Common.buffer1.size() == 0) {
                try {
                    Common.MoveBlockedThreadNum++;
                    Common.buffer1.wait();
                    Common.MoveBlockedThreadNum--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep((long) (Math.random() * 100 * (50-Common.moveSpeed)));
                Common.buffer1.notify();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            if(firstSevenName.equals("buffer2")) {
                synchronized (Common.buffer2) {
                    while (Common.buffer2.size() == Common.Buffer2Size) {
                        try {
                            Common.MoveBlockedThreadNum++;
                            Common.buffer2.wait();

                            Common.MoveBlockedThreadNum--;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //buffer1移出
                    tmpdata = buffer1Service.removestr(common.buffer1_id);
                    common.buffer1.remove(0);
                    System.out.println("BUFFER1:"+common.buffer1);
                    //buffer2移入
                    buffer2Service.removeInstr(common.buffer2_id,tmpdata);
                    resultService.updatebuffer2result(common.rs_id);
                    common.buffer2.add(tmpdata);
                    System.out.println("BUFFER2:"+common.buffer2);//有
                    try {

                        Thread.sleep((long) (Math.random() * 100 * (50-Common.moveSpeed)));
                        Common.buffer2.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }else if(firstSevenName.equals("buffer3")) {
                synchronized (Common.buffer3) {
                    while (Common.buffer3.size() == Common.Buffer3Size) {
                        try {
                            Common.MoveBlockedThreadNum++;
                            Common.buffer3.wait();
                            Common.MoveBlockedThreadNum--;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //buffer1移出
                    tmpdata = buffer1Service.removestr(common.buffer1_id);
                    common.buffer1.remove(0);
                    //buffer3移入
                    buffer3Service.removeInstr(common.buffer3_id,tmpdata);
                    resultService.updatebuffer3result(common.rs_id);
                    Common.buffer3.add(tmpdata);
                    System.out.println("BUFFER3:"+common.buffer3);
                    try {
                        Thread.sleep((long) (Math.random() * 100 * (50-Common.moveSpeed)));
                        Common.buffer3.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
            while (Common.pause) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
//}
