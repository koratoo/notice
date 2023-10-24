package org.innobl.notice.service;

import org.innobl.notice.beans.Notice;
import org.innobl.notice.exception.NoticeException;
import org.innobl.notice.service.NoticeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class NoticeServiceTest {
    @Autowired
    NoticeService noticeService;

    @Test
    void getAllNoticesTest(){
        List<Notice> noticeList = noticeService.getAllNotices();
        assertThat(noticeList.size()).isEqualTo(1);

        // Test for exception case
        assertThrows(NoticeException.class, () -> {
            noticeService.getAllNotices();
        });
    }
}
