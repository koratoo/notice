package org.innobl.notice.exception;

public enum NoticeErrorMessage {
    NOTICE_NOT_FOUND("The requested notice was not found."),
    NOTICE_TITLE_MISSING("The notice does not have a title.");

    private final String message;

    NoticeErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
