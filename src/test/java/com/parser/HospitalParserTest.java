package com.parser;

import com.domain.Hospital;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HospitalParserTest {
    //read.line
    String line1 = "A1120837,서울특별시 금천구 벚꽃로 286 삼성리더스타워 111~114호 (가산동),C,의원,G099,응급의료기관 이외,2,외과: 상시진료 내과는 당분간 휴진,서울시 송파구 문정동 장지동 법조단지 위례 가락동 가락시장역 위치 삼성서울병원 외래교수 출신 구강외과 전문의 진료 진료과목 - 임플란트 치조골 뼈이식 수술 매복 사랑니 발치 턱관절 악관절 질환의 치료 교정 치료 및 기타 보존 보철(크라운 브릿지 인레이) 신경치료,방이역 1번출구 바로옆 굿모닝 신한증권 뒷건물,가산기대찬의원,02-6267-2580,02-920-5374,1930,1930,1930,1930,1930,1500,1500,1500,900,900,900,900,900,900,1000,1000,85,11,126.8841225,37.4803938,2022.4.7 14:55";
    String line2 = "A1117873,서울특별시 관악구 신원로 38 5층 (신림동 청암빌딩),N,치과의원,G099,응급의료기관 이외,2,대표번호1 지역번호 추가20170118150453,서울시 송파구 문정동 장지동 법조단지 위례 가락동 가락시장역 위치 삼성서울병원 외래교수 출신 구강외과 전문의 진료 진료과목 - 임플란트 치조골 뼈이식 수술 매복 사랑니 발치 턱관절 악관절 질환의 치료 교정 치료 및 기타 보존 보철(크라운 브릿지 인레이) 신경치료,서월치안센터 인근 청암빌딩 5층,가로수치과의원,02-882-2750,02-920-5374,1900,2100,1900,2100,1900,1400,1500,1500,1000,1000,930,1400,1000,1000,1000,1000,87,76,126.9293767,37.48191799,2022.1.7 14:54";

    private void assertHospital(Hospital hospital, String eId, String eAddress, String eDistrict,
                                String eCategory, String eEmergencyRoom, String eName, String eSubdivision) {

        Assertions.assertEquals(eId, hospital.getId());
        Assertions.assertEquals(eAddress, hospital.getAddress());
        Assertions.assertEquals(eDistrict, hospital.getDistrict());
        Assertions.assertEquals(eCategory, hospital.getCategory());
        Assertions.assertEquals(eEmergencyRoom, hospital.getEmergencyRoom());
        Assertions.assertEquals(eName, hospital.getName());
        Assertions.assertEquals(eSubdivision, hospital.getSubdivision());

    }

    @Test
    @DisplayName("Parsing doing well")
    void isParsing() {
        HospitalParser hospitalParser = new HospitalParser();

        Hospital hospital1 = hospitalParser.parse(this.line1);
        assertHospital(hospital1, "A1120837", "서울특별시 금천구 벚꽃로 286 삼성리더스타워 111~114호 (가산동)",
                "서울특별시 금천구", "C", "2", "가산기대찬의원", "분류 불가");

        Hospital hospital2 = hospitalParser.parse(this.line2);
        assertHospital(hospital2, "A1117873", "서울특별시 관악구 신원로 38 5층 (신림동 청암빌딩)",
                "서울특별시 관악구", "N", "2", "가로수치과의원", "치과");

    }
}