package com.lzy;

import java.util.ArrayList;
import java.util.List;

public class MinAvgVariance {

    public static List<Double> GetMinAvgVariance(List<Double> allElements,int cutLength){
        var allVarianceList=GetVarianceList(allElements,cutLength);
        List<Double> rtn=new ArrayList<>();

        double minVariance=-1;
        int location=0;

        for(int i=0;i<allVarianceList.size();i++){
            if(minVariance==-1){
                minVariance=allVarianceList.get(i).variance;
                location=i;
            }
            else{
                if(minVariance>allVarianceList.get(i).variance){
                    minVariance=allVarianceList.get(i).variance;
                    location=i;
                }
            }
        }

        if(minVariance!=-1){
            rtn=allVarianceList.get(location).elements;
        }

        return  rtn;
    }


    public static double GetVariance(List<Double> elements){
        double avg=0;
        double variance=0;
        for(int i=0;i<elements.size();i++){
            avg+=elements.get(i);
        }
        avg=avg/elements.size();

        for(int i=0;i<elements.size();i++){
            variance+=Math.sqrt(Math.abs(elements.get(i)-avg));
        }

        return variance;
    }

    public static List<VarianceDetail> GetVarianceList(List<Double> allElements,int cutLength){
        List<VarianceDetail> rtn=new ArrayList<>();

        for(int i=0;i<allElements.size();i++){
            if(i+cutLength>allElements.size()){
                break;
            }

            VarianceDetail varianceDetail=new VarianceDetail();
            varianceDetail.serialNumber=i;
            for(int j=0;j<cutLength;j++){
                varianceDetail.elements.add(allElements.get(i+j));
            }

            varianceDetail.variance=GetVariance(varianceDetail.elements);

            rtn.add(varianceDetail);
        }

        return rtn;
    }

}
