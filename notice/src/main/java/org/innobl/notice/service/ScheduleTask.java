package org.innobl.notice.service;

import lombok.extern.log4j.Log4j2;
import org.innobl.notice.mapper.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class ScheduleTask {

    @Autowired
    private NoticeMapper noticeMapper;

    @Scheduled(fixedDelay = 60 * 1000)
    public void updateFixedColumn(){
        log.info("schedule 실행");
        noticeMapper.updateFixed();
    }
}
