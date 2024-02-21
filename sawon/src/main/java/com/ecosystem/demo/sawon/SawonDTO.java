package com.ecosystem.demo.sawon;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class SawonDTO {
    private String sawonName;
    private String sawonId;
    private String phoneNum;
    private String emailAddress; 
    private String departmentName;
    private String birthDt;
    private String positionName;
    private String homeAddress;
    private String enterDt;
    private String retiredDt;
    private String insSawonId;
    private LocalDateTime insDtm; 
    private String updSawonId;
    private LocalDateTime updDtm; 
}
