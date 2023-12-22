package umc.spring.apiPayload.code;
//BaseCode와 BaseErrorCode의 역할은
//이를 구체화 하는 Status에서 두 개의 메소드를 반드시 Override할 것을 강제한다.
public interface BaseCode {

    public ReasonDTO getReason();

    public ReasonDTO getReasonHttpStatus();
}