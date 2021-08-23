package com.jhdroid.opencsv.sample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    //테스트용 파일명1
    private val FILE_NAME_1 = "jhdroid_sample_1.csv"

    //테스트용 파일명2
    private val FILE_NAME_2 = "jhdroid_sample_2.csv"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //내부 저장소 경로
        val filePath = filesDir.toString()

        val csvHelper = CsvHelper(filePath)

        /**
         * write
         * */
        //테스트용 데이터 리스트1
        val dataList1 = arrayListOf<Array<String>>()

        //헤더로 사용할 데이터 추가
        dataList1.add(arrayOf("Name", "Age"))

        //데이터 추가
        dataList1.add(arrayOf("Kim", "28"))
        dataList1.add(arrayOf("Lee", "22"))
        dataList1.add(arrayOf("Kawk", "25"))
        dataList1.add(arrayOf("김준희", "25"))
        dataList1.add(arrayOf("곽지선", "25"))

        csvHelper.writeAllData(FILE_NAME_1, dataList1)

        //테스트용 데이터 리스트2
        val dataList2 : ArrayList<Array<String>> = arrayListOf()

        //헤더로 사용할 데이터 추가
        dataList2.add(arrayOf("Name", "Age"))

        //데이터 추가
        dataList2.add(arrayOf("Jo", "19"))
        dataList2.add(arrayOf("Jung", "30"))
        dataList2.add(arrayOf("Heo", "24"))

        csvHelper.writeData(FILE_NAME_2, dataList2)

        /**
         * read
         * */
        //1번 파일 읽기
        var dataList = csvHelper.readAllCsvData(FILE_NAME_1)
        for (data in dataList) {
            Log.d("jhdroid_test", "data : ${Arrays.deepToString(data)}")
        }

        //2번 파일 읽기
        dataList = csvHelper.readCsvData(FILE_NAME_2)
        for (data in dataList) {
            Log.d("jhdroid_test", "data : ${Arrays.deepToString(data)}")
        }
    }
}