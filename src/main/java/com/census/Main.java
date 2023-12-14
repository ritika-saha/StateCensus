package com.census;

public class Main {
    public static void main(String[] args) throws CensusException{
        System.out.println("================================= STATE CENSUS ===============================");
        StateCensusAnalyzer analyzer=new StateCensusAnalyzer("StateCensus.csv");
        analyzer.loadData();
        System.out.println("Data count : "+analyzer.countData());
        System.out.println("Is data count correct? "+analyzer.verifyCount(37));
        
    }
}