package com;

import com.domain.Hospital;
import com.parser.HospitalParser;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        LineReader<Hospital> hospitalLineReader = new LineReader<>(new HospitalParser());
        String filename = "/Users/suin/Downloads/수업 데이터 파일/seoul_hospital.csv";
        List<Hospital> hospitals = hospitalLineReader.readLines(filename);


        for (Hospital hospital : hospitals) {
            System.out.printf("%s %s %s %s %s %s %s\n",
                    hospital.getId(), hospital.getAddress(), hospital.getDistrict(), hospital.getCategory(),
                    hospital.getEmergencyRoom(), hospital.getName(), hospital.getSubdivision());
        }
    }
}