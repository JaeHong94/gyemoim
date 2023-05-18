package com.team.gyemoim.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse{
    private boolean success; // 요청 성공 여부
    private String message; // 응답 메세지
    private String accessToken;
    private String refreshToken;
}
