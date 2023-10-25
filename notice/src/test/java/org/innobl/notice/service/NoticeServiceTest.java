package org.innobl.notice.service;

import org.innobl.commons.Pagination;
import org.innobl.notice.beans.Notice;
import org.innobl.notice.dto.NoticeBoardDto;
import org.innobl.notice.exception.NoticeErrorMessage;
import org.innobl.notice.exception.NoticeException;
import org.innobl.notice.service.NoticeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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

    @AfterEach
    void clean(){
        noticeService.getAllNotices().clear();
    }

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

    @Test
    @DisplayName("데이터 9건 등록 테스트")
    void insertOneDate(){
        //given
        for(int i=1;i<10;i++) {
            NoticeBoardDto dto = NoticeBoardDto.builder()
                    .writer("홍길동"+i)
                    .fixed("고정")
                    .nb_title(i+"번째 공지글")
                    .nb_content("글 내용은 2048바이트")
                    .build();
            //when
            noticeService.writeNotice(dto);
        }

        //then
        assertThat(noticeService.getAllNotices().size()).isEqualTo(19);
    }

    @Test
    @DisplayName("2번 글을 삭제한다.")
    void delBoardNumberOne(){
        //given
        int num = 2;
        //when
        noticeService.deleteNotice(num);
        //then
        assertThat(noticeService.getAllNotices().size()).isEqualTo(2);
    }


    @Test
    @DisplayName("고정된 공지목록을 불러온다.")
    void getFixedNotices(){
        assertThat(noticeService.getFixedNotices().size()).isEqualTo(3);

    }
}
