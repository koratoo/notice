package org.innobl.notice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.innobl.notice.beans.Notice;
import org.innobl.notice.service.NoticeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/nb")
@RequiredArgsConstructor
public class NoticeRestController {
    private final NoticeService noticeService;

    @PutMapping("/edit/{nbno}")
    public void editFixedNotice(@PathVariable("nbno")int nbno){
        log.info("nbno :{}",nbno);
        noticeService.editFixedNotice(nbno);
    }

    //기간 조건 -> 추후 이름, 제목에 따른 검색 조건 추가
    @GetMapping("/search/{from}/{to}")
    public ResponseEntity<List<Notice>> getSearchResult(@PathVariable("from") String from, @PathVariable("to")String to){


        return new ResponseEntity<>(noticeService.getNoticeByDate(from,to),HttpStatus.OK);
    }


}
