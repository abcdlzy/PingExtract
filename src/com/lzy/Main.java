package com.lzy;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here

        var filePath="TestData/pingdup.txt";
        List<String> datas= Tools.readFileContent(filePath);

        boolean isStarted=false;
        List<PingItem> pingItemList=new ArrayList<>();
        //format file
        for(int i=0;i<datas.size();i++) {



            if(isStarted){
                var currentProcess=datas.get(i).split(" ");
                if(currentProcess.length<7){
                    break;
                }

                var item=new PingItem();
                item.setIPAddress(currentProcess[3].substring(0,currentProcess[3].length()-1));
                item.setICMP_seq(Integer.parseInt(currentProcess[4].split("=")[1]));
                item.setTtl(Integer.parseInt(currentProcess[5].split("=")[1]));
                item.setTime(Integer.parseInt(currentProcess[6].split("=")[1]));
                item.setDup(datas.get(i).contains("DUP"));

                pingItemList.add(item);

            }
            else if(datas.get(i).startsWith("PING")){
                isStarted=true;
                continue;
            }
            else{
                continue;
            }
        }

        //statistic data
        List<PingStatistic> pingStatisticList=new ArrayList<>();
        for(int i=0;i< pingItemList.size();i++){
            final var currentItem=pingItemList.get(i);
            var finditem=pingStatisticList.stream().filter(s->s.seq==currentItem.ICMP_seq).findFirst();
            if(finditem.isEmpty()){
                var newitem=new PingStatistic();
                newitem.seq=currentItem.ICMP_seq;
                newitem.minLatency= currentItem.time;
                newitem.maxLatency= currentItem.time;
                newitem.DUPCount=currentItem.isDup()?1:0;
                newitem.latencyList.add(currentItem.time);

                pingStatisticList.add(newitem);
            }
            else
            {
                finditem.get().minLatency= finditem.get().minLatency<currentItem.time?finditem.get().minLatency:currentItem.time;
                finditem.get().maxLatency= finditem.get().maxLatency>currentItem.time?finditem.get().maxLatency:currentItem.time;
                finditem.get().DUPCount+=currentItem.isDup()?1:0;
                finditem.get().latencyList.add(currentItem.time);
            }
        }


        //output
        for(int i=0;i<pingStatisticList.size();i++){
            System.out.println(
                            pingStatisticList.get(i).seq+","+
                            pingStatisticList.get(i).minLatency+","+
                            pingStatisticList.get(i).maxLatency+","+
                            pingStatisticList.get(i).DUPCount);
        }

        System.out.println("");

    }
}
