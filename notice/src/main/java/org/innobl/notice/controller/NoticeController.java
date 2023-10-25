package org.innobl.notice.controller;

import lombok.RequiredArgsConstructor;
import org.innobl.notice.dto.NoticeBoardDto;
import org.innobl.notice.service.NoticeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/detail/{nbno}")
    public String showNoticeDetailPage(Model model, @PathVariable("nbno") int nbno){
        if(noticeService.getNotice(nbno).getFixed().equals("100")){
            model.addAttribute("showButton","true");
        }
        model.addAttribute("notice",noticeService.getNotice(nbno));
        return "/notice/detail";
    }
}
