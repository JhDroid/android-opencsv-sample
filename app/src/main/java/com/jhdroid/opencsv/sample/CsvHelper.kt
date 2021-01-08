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

            cw.use {
                //writeAll()을 이용한 리스트 데이터 등록
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
                val iterator = dataList.iterator()
                while (iterator.hasNext()) {
                    val data = iterator.next()
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

            reader.use {
                //readAll()을 이용해 데이터 읽기
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

            reader.use {
                //iterator()을 이용해 데이터 읽기
                val iterator = it.iterator()
                while (iterator.hasNext()) {
                    dataArray.add(iterator.next())
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