package com.lzy;

import java.util.ArrayList;
import java.util.List;

public class PingStatistic {

    int seq=0;
    int minLatency=0;
    int maxLatency=0;
    int DUPCount=0;
    List<Integer> latencyList=new ArrayList<>();
}
