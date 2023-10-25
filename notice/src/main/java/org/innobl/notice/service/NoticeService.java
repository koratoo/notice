package org.innobl.notice.service;

import org.innobl.commons.Pagination;
import org.innobl.notice.beans.Notice;
import org.innobl.notice.dto.NoticeBoardDto;
import org.innobl.notice.exception.NoticeErrorMessage;
import org.innobl.notice.exception.NoticeException;
import org.innobl.notice.mapper.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService {

    private final NoticeMapper noticeMapper;
    @Autowired
    public NoticeService(NoticeMapper noticeMapper){
        this.noticeMapper = noticeMapper;
    }

    public List<Notice> getAllNotices() {
        List<Notice> notices = noticeMapper.getAllNotices();
        if(notices.size()==0 || notices.isEmpty()){
            throw new NoticeException(NoticeErrorMessage.NOTICE_NOT_FOUND.getMessage());
        }
        return notices;
    }

    public void writeNotice(NoticeBoardDto dto){
        noticeMapper.writeNotice(dto);
    }
    public void deleteNotice(int nbno){
        noticeMapper.deleteNotice(nbno);
    }
    public List<Notice> getFixedNotices(){return noticeMapper.getFixedNotices();}


}
