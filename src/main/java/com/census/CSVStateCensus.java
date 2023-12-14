package com.census;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


public class CSVStateCensus {
    private String path;
    public CSVStateCensus(String p){
        this.path=p;
    }

    public Iterator<String[]> loadCSV() throws CensusException{
        if(path.endsWith(".csv")==false){
            throw new CensusException("FILE TYPE NOT CSV");
        }

        try{
            ArrayList<String[]> data=new ArrayList<>();
            BufferedReader br=new BufferedReader(new FileReader(path));
            String header=br.readLine();
            if(header==null || header.equals("SrNo,StateName,TIN,StateCode")==false){
                br.close();
                throw new CensusException("WRONG HEADER IN CSV FOUND");
            }
            String line;
            while((line=br.readLine())!=null){
                if(line.contains("-")==true){
                    br.close();
                    throw new CensusException("WRONG DELIMITER EXCEPTION");
                }
                String lineArray[];
                     lineArray=line.split(",");
                     data.add(lineArray);
            }
            br.close();
            return data.iterator();
        }catch(Exception e){
            throw new CensusException(e.getMessage());
        }
    }
}
