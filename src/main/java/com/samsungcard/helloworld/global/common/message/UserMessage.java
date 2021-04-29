package com.samsungcard.helloworld.global.common.message;

public enum UserMessage {
    // 공통 적인 오류 코드들
    INVALID_INPUT(400, "C001", "%s(은/는) 유효하지 않은 입력값 입니다."),
    REQUIRED(400, "C001", "%s(은/는) 필수 입력값 입니다."),
    NOT_ALLOWED(405, "C002", "%s(은/는) 유효하지 않은 입력값 입니다."),
    NOT_FOUND(400, "C003", "%s(을/를) 찾을 수 없습니다."),
    INTERNAL_SERVER_ERROR(500, "C004", "서버에서 예기치 못한 오류가 발생 하였습니다."),
    INVALID_TYPE(400, "C005", "유효하지 않은 타입입니다."),
    ACCESS_DENIED(403, "C006", "접근할 수 없습니다."),
    ALREADY_EXIST(409, "C007", "이미 존재하는 데이터 입니다."),

    // 업무 오류 코드들
    EMAIL_DUPLICATION(400, "M001", "중복된 이메일입니다."),
    LOGIN_INPUT_INVALID(400, "M002", "로그인 정보가 올바르지 않습니다."),

    // 성공 코드들
    CREATED(201, "S001", "%s(을/를) 성공적으로 생성 했습니다."),
    MODIFIED(200, "S002", "%s(을/를) 성공적으로 수정 했습니다."),
    REMOVED(204, "S003", "%s(을/를) 성공적으로 삭제 했습니다."),
    FOUND(200, "S004", "%s(을/를) 성공적으로 조회 했습니다."),

    ;

    private final String code;
    private final String message;
    private final int status;

    UserMessage(final int status, final String code, final String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }

    public String get() {
        return this.message;
    }

    public String get(Object... o) {
        return String.format(this.message, o);
    }

    public String with(Object... o) {
        return get(o);
    }

    public String getCode() {
        return code;
    }

    public int getStatus() {
        return status;
    }
}
