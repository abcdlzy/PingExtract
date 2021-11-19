package com.lzy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Tools {

    public static List<String> readFileContent(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        //StringBuffer sbf = new StringBuffer();
        List<String> rtnStr=new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                rtnStr.add(tempStr);
            }
            reader.close();
            return rtnStr;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return rtnStr;
    }

    private static List<String> getFileList(String filePath){
        List<String> filelist=new ArrayList<>();
        if(null!=filePath&&!("".equals(filePath))){
            File file = new File(filePath);
            //判断文件或目录是否存在
            if(!file.exists()){
                System.out.println("【"+filePath + " not exists】");
            }
            //获取该文件夹下所有的文件
            File[] fileArray= file.listFiles();
            File fileName = null;
            for(int i =0;i<fileArray.length;i++){
                fileName = fileArray[i];
                //判断此文件是否存在
                if(!fileName.isDirectory()&&!fileName.getName().contains(".DS_Store")){
                    filelist.add(fileName.getName());
                }
            }
        }
        return filelist;
    }


}
