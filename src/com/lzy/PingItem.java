package com.lzy;

public class PingItem {
    public String IPAddress="";
    public int ICMP_seq=0;
    public int ttl=0;
    //ms
    public int time=0;
    public boolean isDup=false;

    public PingItem(){

    }

    public PingItem(String IPAddress, int ICMP_seq, int ttl, int time, boolean isDup) {
        this.IPAddress = IPAddress;
        this.ICMP_seq = ICMP_seq;
        this.ttl = ttl;
        this.time = time;
        this.isDup = isDup;
    }

    public String getIPAddress() {
        return IPAddress;
    }

    public int getICMP_seq() {
        return ICMP_seq;
    }

    public int getTtl() {
        return ttl;
    }

    public int getTime() {
        return time;
    }

    public boolean isDup() {
        return isDup;
    }


    public void setIPAddress(String IPAddress) {
        this.IPAddress = IPAddress;
    }

    public void setICMP_seq(int ICMP_seq) {
        this.ICMP_seq = ICMP_seq;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setDup(boolean dup) {
        isDup = dup;
    }
}
