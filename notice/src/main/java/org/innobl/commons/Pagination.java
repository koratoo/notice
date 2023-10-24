package org.innobl.commons;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class Pagination {
    private int limit;
    private int offset;

    @Builder
    public Pagination(int limit, int offset) {
        this.limit = limit;
        this.offset = offset;
    }
}
