package com.census;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws CensusException{
        System.out.println("================================= STATE CENSUS ===============================");
        StateCensusAnalyzer analyzer=new StateCensusAnalyzer("StateCensus.csv");
        analyzer.loadData();
        System.out.println("Data count : "+analyzer.countData());
        System.out.println("Is data count correct? "+analyzer.verifyCount(37));
        System.out.println("The state codes are as follows");
        ArrayList<String> stateCodeList=analyzer.getStateCodes();
        System.out.println(stateCodeList);
        System.out.println("count of state codes : "+stateCodeList.size());
    }
}