package org.innobl.notice.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class NoticeBoardDto {
    private String nb_title;
    private String nb_content;
    private String writer;
    private String fixed;

    @Builder
    public NoticeBoardDto(String nb_title, String nb_content, String writer, String fixed) {
        this.nb_title = nb_title;
        this.nb_content = nb_content;
        this.writer = writer;
        this.fixed = fixed;
    }
}
