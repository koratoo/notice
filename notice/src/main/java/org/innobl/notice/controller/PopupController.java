package org.innobl.notice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/popup")
public class PopupController {

    @GetMapping("/d-notice")
    public String showDailyNoticePopup(){
        return "/notice/popup/d-notice";
    }
}
