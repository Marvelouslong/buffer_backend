package com.os.buffer_backend.task;

import com.os.buffer_backend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MoveOperation implements Runnable {
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

    public MoveOperation(ParamService paramService, Common common, Buffer1Service buffer1Service, Buffer2Service buffer2Service, Buffer3Service buffer3Service, ResultService resultService) {
        this.paramService = paramService;
        this.common = common;
        this.buffer1Service = buffer1Service;
        this.buffer2Service = buffer2Service;
        this.buffer3Service = buffer3Service;
        this.resultService = resultService;
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
            System.out.println(Thread.currentThread().getName() + " is working...");
            String threadName = Thread.currentThread().getName();
            String firstSevenName = threadName.substring(0, Math.min(threadName.length(), 7));
            synchronized (common.buffer1) {
                while (common.buffer1.isEmpty()) {
                    try {
                        common.MoveBlockedThreadNum++;
                        System.out.println("common.MoveBlockedThreadNum is" + common.MoveBlockedThreadNum);
                        common.buffer1.wait();
                        common.MoveBlockedThreadNum--;
                        System.out.println("阻塞在movebuffer1");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (firstSevenName.equals("buffer2")) {
                    synchronized (common.buffer2) {
                        while (common.buffer2.size() == common.Buffer2Size) {
                            try {
                                common.MoveBlockedThreadNum++;
                                common.buffer2.wait();
                                System.out.println("阻塞在movebuffer2");
                                common.MoveBlockedThreadNum--;
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
                        //buffer1移出
                        tmpdata = buffer1Service.removestr(common.buffer1_id);
                        common.buffer1.remove(0);
                        System.out.println("BUFFER1:" + common.buffer1);
                        //buffer2移入
                        buffer2Service.removeInstr(common.buffer2_id, tmpdata);
                        resultService.updatebuffer2result(common.rs_id);
                        common.buffer2.add(tmpdata);
                        System.out.println("BUFFER2:" + common.buffer2);//有
                        try {
                            Thread.sleep((long) common.moveSpeed * 1000);
                            common.buffer2.notify();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        try {
                            Thread.sleep((long) common.moveSpeed * 1000);
                            common.buffer1.notify();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (firstSevenName.equals("buffer3")) {
                    synchronized (common.buffer3) {
                        while (common.buffer3.size() == common.Buffer3Size) {
                            try {
                                common.MoveBlockedThreadNum++;
                                common.buffer3.wait();
                                common.MoveBlockedThreadNum--;
                        System.out.println("阻塞在movebuffer3");
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
                        //buffer1移出
                        tmpdata = buffer1Service.removestr(common.buffer1_id);
                        common.buffer1.remove(0);
                        //buffer3移入
                        buffer3Service.removeInstr(common.buffer3_id, tmpdata);
                        resultService.updatebuffer3result(common.rs_id);
                        common.buffer3.add(tmpdata);
                        System.out.println("BUFFER3:" + common.buffer3);
                        try {
                            Thread.sleep((long) common.moveSpeed * 500);
                            common.buffer3.notify();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        try {
                            Thread.sleep((long) common.moveSpeed * 1000);
                            common.buffer1.notify();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
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


