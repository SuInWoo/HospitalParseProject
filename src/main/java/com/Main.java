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

        MakeSQLFile makeSQLFile = new MakeSQLFile();

        String fileName = "seoulHospital.sql";
        makeSQLFile.createFile(fileName,makeSQLFile.createSQL(hospitals));
    }
}