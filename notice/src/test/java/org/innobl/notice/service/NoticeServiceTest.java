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
    @DisplayName("데이터 등록 테스트")
    void insertOneDate(){
        //given
            NoticeBoardDto dto = NoticeBoardDto.builder()
                    .writer("파르헤시아")
                    .nb_title("산문에 대하여")
                    .nb_content("운문에 대립되는 글의 양식으로 일정한 운율이나 정형성을 지니지 않은 문장.대체로 일상적인 표현 방식이나 언어 용법으로 짜여져 있는 글, 이것이 바로 산문에 대한 통념이다. 산문의 기본 의미와 형태 그리고 여러 가지 특질들을 정확하게 알려면, 운문과 대비시켜보는 작업이 필요하다. 실제로 산문은 운문과는 차별성을 내보이는 가운데서도 동질성 또한 분명하게 드러내고 있다. ")
                    .build();
            //when
            noticeService.writeNotice(dto);


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

    @Test
    @DisplayName("공지글에 아무것도 입력을 안할 경우 기본설정 값을 보여준다.")
    void doNullHandling(){
        //given
        NoticeBoardDto dto = NoticeBoardDto.builder()
                .writer("정철")
                .nb_content("조선 중기의 문인 정철이 남긴 가사. 이상과 현실의 대립에서 현실적 가치를 택해 관찰사를 하겠다는 뜻이다. 주 내용은 만물을 관찰하며 임금을 찬양하고 임금에 충성하는 뉘앙스가 대부분. 하지만 이걸 공부하는 데에는 적지 않은 노력이 필요한 점은 상당수가 인정한다.")
                .build();
        //when
        noticeService.writeNotice(dto);

        //then
        assertThat(noticeService.getNoneFixedNotices().get(1).getNb_title()).isEqualTo("제목을 입력해주세요.");
    }
}
