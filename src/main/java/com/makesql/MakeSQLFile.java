package com.makesql;

import com.domain.Hospital;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MakeSQLFile {
    /*
        1. 파일 이름, String을 받아 txt파일 생성 및 쓰기 메소드
        2. 입력받은 객체 list를 stringBuffer로 가공
     */

    public void createFile(String fileName, StringBuffer sb) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));

        bw.write(sb.toString());
        bw.close();
    }

    public StringBuffer createSQL(List<Hospital> list){
        StringBuffer sb = new StringBuffer("INSERT INTO `likelion-db`.`seoul_hospital`\n" +
                "(`id`,`address`,`district`,`category`,`emergency_room`,`name`,`subdivision`)\n" +
                "VALUES\n");

        for (int i = 0; i < list.size() - 1; i++) {
            sb.append(list.get(i) +",\n");
        }
        sb.append(list.get(list.size() - 1) + ";");

        return sb;
    }
}
