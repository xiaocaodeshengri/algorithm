package com.algorithm.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TanxinSort {
    /**
     * 贪心算法:
     *    就是从局部最优到全局最优
     *      最主要就是写一个排序的方法
     * @param args
     */
    public static void main(String[] args) {
        //准备数据
        Scanner cin = new Scanner(System.in);
        List<Meeting> meetings = new ArrayList<Meeting>();
        int n = cin.nextInt();
        for (int i = 0; i < n; i++) {
            int start =cin.nextInt();
            int end =cin.nextInt();
            Meeting meeting = new Meeting(i + 1, start, end);
            //添加进入之后就已经排序了，结束时间升序
            meetings.add(meeting);
        }

        System.out.println("排好顺序得列表！");
        for (int i = 0; i < n; i++) {
            Meeting meeting = meetings.get(i);
                System.out.println(meeting.toString());
            }
        System.out.println("最后结果！");
        int curTime = 0;
        for (int i = 0; i < n; i++) {
            Meeting meeting = meetings.get(i);
            if (meeting.startTime >= curTime) {
                System.out.println(meeting.toString());
                curTime = meeting.endTime;

            }
        }


    }

}

class Meeting implements Comparable<Meeting> {

    int meNum;
    int startTime;
    int endTime;

    public Meeting(int meNum, int startTime, int endTime) {
        this.meNum = meNum;
        this.startTime = startTime;
        this.endTime = endTime;
    }
   /*
   根据结束时间排序
    */
    public int compareTo(Meeting o) {
        if (this.endTime > o.endTime) {
            return 1;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Metting [meNum=" + meNum + ", startTime=" + startTime
                + ", endTime=" + endTime + "]";
    }
}
