package org.innobl.notice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.innobl.notice.service.NoticeService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
