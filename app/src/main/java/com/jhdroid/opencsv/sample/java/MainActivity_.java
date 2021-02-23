package com.jhdroid.opencsv.sample.java;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.jhdroid.opencsv.sample.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity_ extends AppCompatActivity {
    //테스트용 파일명1
    private final String FILE_NAME_1 = "jhdroid_sample_1.csv";

    //테스트용 파일명2
    private final String FILE_NAME_2 = "jhdroid_sample_2.csv";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //내부 저장소 경로
        String filePath = getFilesDir().toString();

        CsvHelper_ csvHelper = new CsvHelper_(filePath);

        /**
         * write
         * */
        //테스트용 데이터 리스트1
        ArrayList<String[]> dataList1 = new ArrayList<>();

        //헤더로 사용할 데이터 추가
        dataList1.add(new String[] {"Name", "Age"});

        //데이터 추가
        dataList1.add(new String[] {"Kim", "28"});
        dataList1.add(new String[] {"Lee", "22"});
        dataList1.add(new String[] {"Kawk", "25"});

        csvHelper.writeAllData(FILE_NAME_1, dataList1);

        //테스트용 데이터 리스트2
        ArrayList<String[]> dataList2 = new ArrayList<>();

        //헤더로 사용할 데이터 추가
        dataList2.add(new String[] {"Name", "Age"});

        //데이터 추가
        dataList2.add(new String[] {"Jo", "19"});
        dataList2.add(new String[] {"Jung", "30"});
        dataList2.add(new String[] {"Heo", "24"});

        csvHelper.writeData(FILE_NAME_2, dataList2);

        /**
         * read
         * */
         //1번 파일 읽기
        List<String[]> dataList = csvHelper.readAllCsvData(FILE_NAME_1);
        for (String[] data : dataList) {
            Log.d("jhdroid_test", "data : " + Arrays.deepToString(data));
        }

        //2번 파일 읽기
        dataList = csvHelper.readCsvData(FILE_NAME_2);
        for (String[] data : dataList) {
            Log.d("jhdroid_test", "data : " + Arrays.deepToString(data));
        }
    }
}
