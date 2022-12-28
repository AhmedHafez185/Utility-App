package com.utility.app.batches;

import java.util.concurrent.CountDownLatch;

public class RunnableRequest implements Runnable {

    String columns[];
    String row[];
    CountDownLatch   noOfThreads ;

    public RunnableRequest(String[] column, String[] row, CountDownLatch noOfThreads) {
        this.columns = column;
        this.row = row;
        this.noOfThreads = noOfThreads;

    }

    String createXmlRecord() {
//        StringBuffer recordBuffer = new StringBuffer("<?xml version=\"1.0\"?>, \n" +
//                "<Request>,     \n" +
//                "                <REQ>NTW</REQ>,     \n" +
//                "                <ID>1934430</ID>,     \n" +
//                "                <CH>RBS</CH>,     \n" +
//                "                <WT>JSON</WT>,     \n" +
//                "                <PARAM>\n");

//        for (int i = 0; i < row.length; i++) {
//            String key = columns[i];
//            String  value = row[i];
//            recordBuffer.append(" <ATT name="+key+">"+value+"</ATT>,\n");
//        }
  //      recordBuffer.append(" <ATT name="+columns[0]+">"+row[0]+"</ATT>,\n");
//        return recordBuffer.append(">, ,     \n" +
//                "                </PARAM>, \n" +
//                "</Request>\n").toString();
        return "<ATT name="+columns[0]+">"+row[0]+"</ATT>";
    }
void post(String body) {

        System.out.println("current Thread "+Thread.currentThread().getName()+" ,  XML Body : "+body);

// do some computations

// track how many threads are running the section

//    count.getAndDecrement(); // end of section

    }

    @Override
    public void run() {
        String xmlBody = createXmlRecord();
        post(xmlBody);
        System.out.println("Progress : "+(noOfThreads.getCount()/51)*100+"%");
//        noOfThreads.countDown();
    }

}
