package com.jhdroid.opencsv.sample

import com.opencsv.CSVReader
import com.opencsv.CSVWriter
import java.io.File
import java.io.FileReader
import java.io.FileWriter
import java.io.IOException

class CsvHelper(private val filePath: String) {
    fun writeAllData(fileName: String, dataList: ArrayList<Array<String>>) {
        try {
            val cw = CSVWriter(FileWriter(File("$filePath/$fileName")))

            //writeAll()을 이용한 리스트 데이터 등록
            cw.use {
                it.writeAll(dataList)
            }
        } catch (e: IOException) {
            if (BuildConfig.DEBUG) {
                e.printStackTrace()
            }
        }
    }

    fun writeData(fileName: String, dataList: ArrayList<Array<String>>) {
        try {
            val cw = CSVWriter(FileWriter(File("$filePath/$fileName")))

            //writeNext()를 이용한 리스트 데이터 등록
            cw.use {
                for (data in dataList) {
                    cw.writeNext(data)
                }
            }
        } catch (e: IOException) {
            if (BuildConfig.DEBUG) {
                e.printStackTrace()
            }
        }
    }

    fun readAllCsvData(fileName: String) : List<Array<String>> {
        return try {
            val reader = CSVReader(FileReader("$filePath/$fileName"))

            //readAll()을 이용해 데이터 읽기
            reader.use {
                it.readAll()
            }
        } catch (e: IOException) {
            if (BuildConfig.DEBUG) {
                e.printStackTrace()
            }

            listOf()
        }
    }

    fun readCsvData(fileName: String) : List<Array<String>> {
        return try {
            val reader = CSVReader(FileReader("$filePath/$fileName"))
            val dataArray = arrayListOf<Array<String>>()

            //for문을 이용해 데이터 읽기
            reader.use {
                for (data in it) {
                    dataArray.add(data)
                }
            }

            dataArray
        } catch (e: IOException) {
            if (BuildConfig.DEBUG) {
                e.printStackTrace()
            }

            listOf()
        }
    }
}