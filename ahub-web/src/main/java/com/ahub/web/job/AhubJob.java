package com.ahub.web.job;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author chengtianping
 * @description
 * @date 2018/8/8
 */
@Component
public class AhubJob {

    private static final Logger logger = Logger.getLogger(AhubJob.class);

    /**
     * 钉钉账号同步
     */
    @Scheduled(cron ="0 0 0 * * ?")
    public void taskSync(){
        logger.info("taskSync start .....");
    }
}
