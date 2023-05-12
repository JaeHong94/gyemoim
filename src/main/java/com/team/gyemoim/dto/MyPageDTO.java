package com.team.gyemoim.dto;

import lombok.Data;

@Data
public class MyPageDTO {
  private Integer uno; // 회원번호
  private String email; //이메일
  private String name; //이름
  private String phone; //전화번호
  private String bankName; //은행명
  private String bankAccountNumber; //계좌번호
  private double creditRating; //신용등급
  private String enrollDate; //회원가입일

}
