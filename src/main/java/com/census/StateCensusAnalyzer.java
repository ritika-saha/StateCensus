package com.census;

import java.util.ArrayList;
import java.util.Iterator;

public class StateCensusAnalyzer {
    CSVStateCensus CSVutilObj;
    Iterator<String[]> data;
    public StateCensusAnalyzer(String path){
        CSVutilObj=new CSVStateCensus(path);
    }

    public void loadData() throws CensusException{
        try {
            data=CSVutilObj.loadCSV();
            System.out.println("Data Loaded Successfully");
        } catch (CensusException e) {
            e.printStackTrace();
        }
    }

    public int countData() throws CensusException{
       int count=0;
       Iterator<String[]> itr=CSVutilObj.loadCSV();
        while(itr.hasNext()){
            count++;
            itr.next();
        }
     return count;
    }
    

    public boolean verifyCount(int expectedCount) throws CensusException{
        int count=0;
       
         Iterator<String[]> itr=CSVutilObj.loadCSV();
        while(itr.hasNext()){
            count++;
            itr.next();
        }
        if(count !=expectedCount){
            throw new CensusException("WRONG COUNT");
        }

        return count==expectedCount;
    }

    public ArrayList<String> getStateCodes() throws CensusException{
        ArrayList<String> stateCodeList=new ArrayList<>();
         Iterator<String[]> itr=CSVutilObj.loadCSV();
        while(itr.hasNext()){
            String tmp[]=itr.next();
            stateCodeList.add(tmp[3]);
        }
        return stateCodeList;
    }


}
