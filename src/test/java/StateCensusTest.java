import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.census.CensusException;
import com.census.StateCensusAnalyzer;

public class StateCensusTest {
    StateCensusAnalyzer analyzer;

    // Test case 1.1
    @Test
    public void testDataCountHappy() throws CensusException {
        analyzer=new StateCensusAnalyzer("StateCensus.csv");
            int count=analyzer.countData();
            assertEquals(count, 37);
            assertTrue(analyzer.verifyCount(count));
           
    }

    //Test 1.2
    @Test
    public void testDataCountSad()  {
        analyzer=new StateCensusAnalyzer("StateCensus.csv");
            int count;
            try {
                count=3838;
                assertTrue(analyzer.verifyCount(count));
            } catch (CensusException e) {
                fail("COUNT MISMATCH :"+ e.getMessage());
                 e.printStackTrace();
            }
           
    }

    //Test 1.3
    @Test
    public void testFileType(){
        
        try {
            analyzer=new StateCensusAnalyzer("StateCensus.txt");
            analyzer.loadData();
            assertEquals(37, analyzer.countData());
        } catch (CensusException e) {
            fail("EXCEPTION OCCURED: "+ e.getMessage());
            e.printStackTrace();
        }
    }

    //Test 1.4
    @Test 
    public void testDelimiter(){
        try{
            analyzer=new StateCensusAnalyzer("StateCensus2.csv");
            analyzer.loadData();
            analyzer.countData();
        }catch(CensusException e){
            fail("EXCEPTION OCCURRED : "+e.getMessage());
            e.printStackTrace();
        }
    }

    //Test 1.5
    @Test
    public void testHeader(){
        try{
            analyzer=new StateCensusAnalyzer("StateCensus3.csv");
            analyzer.loadData();
            analyzer.countData();
        }catch(CensusException e){
            fail("EXCEPTION OCCURRED : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
