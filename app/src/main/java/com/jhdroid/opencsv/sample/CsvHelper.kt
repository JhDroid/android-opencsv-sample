package com.jhdroid.opencsv.sample

import com.opencsv.CSVReader
import com.opencsv.CSVWriter
import java.io.File
import java.io.FileReader
import java.io.FileWriter
import java.io.IOException

class CsvHelper(private val filePath: String) {
    fun writeAllData(fileName: String, dataList: ArrayList<Array<String>>) {
        val cw = CSVWriter(FileWriter(File("$filePath/$fileName")))

        try {
            //writeAll()을 이용한 리스트 데이터 등록
            cw.writeAll(dataList)
        } catch (e: IOException) {
            if (BuildConfig.DEBUG) {
                e.printStackTrace()
            }
        } finally {
            cw.close()
        }
    }

    fun writeData(fileName: String, dataList: ArrayList<Array<String>>) {
        val cw = CSVWriter(FileWriter(File("$filePath/$fileName")))

        val it = dataList.iterator()
        try {
            //writeNext()를 이용한 리스트 데이터 등록
            while (it.hasNext()) {
                val data = it.next()
                cw.writeNext(data)
            }
        } catch (e: IOException) {
            if (BuildConfig.DEBUG) {
                e.printStackTrace()
            }
        } finally {
            cw.close()
        }
    }

    fun readAllCsvData(fileName: String) : List<Array<String>> {
        val reader = CSVReader(FileReader("$filePath/$fileName"))

        return try {
            //readAll()을 이용해 데이터 읽기
            reader.readAll()
        } catch (e: IOException) {
            if (BuildConfig.DEBUG) {
                e.printStackTrace()
            }

            listOf()
        } finally {
            reader.close()
        }
    }

    fun readCsvData(fileName: String) : List<Array<String>> {
        val reader = CSVReader(FileReader("$filePath/$fileName"))
        val dataArray = arrayListOf<Array<String>>()

        return try {
            //iterator()을 이용해 데이터 읽기
            val it = reader.iterator()
            while (it.hasNext()) {
                dataArray.add(it.next())
            }

            dataArray
        } catch (e: IOException) {
            if (BuildConfig.DEBUG) {
                e.printStackTrace()
            }

            listOf()
        } finally {
            reader.close()
        }
    }
}