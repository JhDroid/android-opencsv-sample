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
            FileWriter(File("$filePath/$fileName")).use { fw ->
                val cw = CSVWriter(fw)

                //writeAll()을 이용한 리스트 데이터 등록
                cw.use {
                    it.writeAll(dataList)
                }
            }
        } catch (e: IOException) {
            if (BuildConfig.DEBUG) {
                e.printStackTrace()
            }
        }
    }

    fun writeData(fileName: String, dataList: ArrayList<Array<String>>) {
        try {
            FileWriter(File("$filePath/$fileName")).use { fw ->
                val cw = CSVWriter(fw)

                //writeNext()를 이용한 리스트 데이터 등록
                cw.use {
                    for (data in dataList) {
                        cw.writeNext(data)
                    }
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
            FileReader("$filePath/$fileName").use { fr ->
                val reader = CSVReader(fr)

                //readAll()을 이용해 데이터 읽기
                reader.use {
                    it.readAll()
                }
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
            FileReader("$filePath/$fileName").use { fr ->
                val reader = CSVReader(fr)
                val dataList = arrayListOf<Array<String>>()

                //for문을 이용해 데이터 읽기
                reader.use {
                    for (data in it) {
                        dataList.add(data)
                    }
                }

                dataList
            }
        } catch (e: IOException) {
            if (BuildConfig.DEBUG) {
                e.printStackTrace()
            }

            listOf()
        }
    }
}