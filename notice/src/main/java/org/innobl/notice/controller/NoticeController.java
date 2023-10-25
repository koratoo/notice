package org.innobl.notice.controller;

import lombok.RequiredArgsConstructor;
import org.innobl.notice.dto.NoticeBoardDto;
import org.innobl.notice.service.NoticeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    @GetMapping("/main")
    public String getNoticePage(Model model){
        model.addAttribute("fixedNotice",noticeService.getFixedNotices());
        model.addAttribute("nfixedNotice",noticeService.getNoneFixedNotices());
        return "/notice/main";
    }

    @PostMapping("/write")
    public String writeNotice(NoticeBoardDto dto){
        return "redirect:/main";
    }
}
