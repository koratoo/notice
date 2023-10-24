package org.innobl.notice.beans;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Notice {
    private String nbno;
    private String nb_title;
    private String nb_content;
    private String writer;
    private String regDate;
    private String modDate;
    private String fixed;
}
