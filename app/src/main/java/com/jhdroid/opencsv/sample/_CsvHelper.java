package com.jhdroid.opencsv.sample;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class _CsvHelper {
    private String filePath;

    public _CsvHelper(String filePath) {
        this.filePath = filePath;
    }

    public void writeAllData(String fileName, ArrayList<String[]> dataList) {
        File file = new File(filePath + "/" + fileName);

        try (FileWriter fw = new FileWriter(file);
             CSVWriter cw = new CSVWriter(fw)) {
            cw.writeAll(dataList);
        } catch (IOException e) {
            if (BuildConfig.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void writeData(String fileName, ArrayList<String[]> dataList) {
        File file = new File(filePath + "/" + fileName);

        try (FileWriter fw = new FileWriter(file);
             CSVWriter cw = new CSVWriter(fw)) {
            for (String[] strings : dataList) {
                cw.writeNext(strings);
            }
        } catch (IOException e) {
            if (BuildConfig.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public List<String[]> readAllCsvData(String fileName) {
        File file = new File(filePath + "/" + fileName);

        try (FileReader fr = new FileReader(file);
             CSVReader reader = new CSVReader(fr)) {
            return reader.readAll();
        } catch (IOException e) {
            if (BuildConfig.DEBUG) {
                e.printStackTrace();
            }

            return new ArrayList<>();
        }
    }

    public List<String[]> readCsvData(String fileName) {
        File file = new File(filePath + "/" + fileName);
        List<String[]> dataArray = new ArrayList<>();

        try (FileReader fr = new FileReader(file);
             CSVReader reader = new CSVReader(fr)) {
            for (String[] data : reader) {
                dataArray.add(data);
            }

            return dataArray;
        } catch (IOException e) {
            if (BuildConfig.DEBUG) {
                e.printStackTrace();
            }

            return new ArrayList<>();
        }
    }
}
