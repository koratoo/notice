package org.innobl.notice.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.innobl.notice.beans.Notice;
import org.innobl.notice.dto.NoticeBoardDto;
import org.innobl.notice.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public interface NoticeMapper {

    public List<Notice> getAllNotices();

    public void writeNotice(NoticeBoardDto dto);
    public void deleteNotice(String nbno);


}
