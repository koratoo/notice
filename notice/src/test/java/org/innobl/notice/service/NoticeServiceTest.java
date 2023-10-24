package org.innobl.notice.service;

import org.innobl.notice.beans.Notice;
import org.innobl.notice.dto.NoticeBoardDto;
import org.innobl.notice.exception.NoticeErrorMessage;
import org.innobl.notice.exception.NoticeException;
import org.innobl.notice.service.NoticeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class NoticeServiceTest {
    @Autowired
    NoticeService noticeService;

    @Test
    @DisplayName("빈 테이블에서 1건의 결과를 기대하면 실패한다.")
    void getAllNoticesTest(){
        List<Notice> noticeList = noticeService.getAllNotices();
        assertThat(noticeList.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("빈 테이블에서 예외처리 후 에러메세지가 나타난다.")
    void noDataExceptionTest(){
        NoticeException exception = assertThrows(NoticeException.class, () -> {
            noticeService.getAllNotices();
        });

        String expectedMessage = NoticeErrorMessage.NOTICE_NOT_FOUND.getMessage();
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }


    @Test
    @DisplayName("builder작동 테스트")
    void getOneNoticesTest(){
        NoticeBoardDto dto = NoticeBoardDto.builder()
                        .writer("홍길동")
                        .fixed("고정")
                        .nb_title("첫번째 공지글")
                        .build();

        assertThat(dto.getWriter()).isEqualTo("홍기동");

    }
}
