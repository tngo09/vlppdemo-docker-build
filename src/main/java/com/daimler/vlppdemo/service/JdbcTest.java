/**
 * 
 */
package com.daimler.vlppdemo.service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tngo
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JdbcTest {

	@Autowired
    JdbcTemplate jdbcTemplate;
	String query = "SELECT FM78_MM, FM78_JJ, FM78_WERT_ABS, FM78_KENNZ,FM78_FZBM_12||FM78_FZBM_3||FM78_FZBM_4||FM78_FZBM_5||FM78_FZBM_6||FM78_FZBM_7||FM78_FZBM_8||FM78_CODE_MOTOR||FM78_CODE_2||FM78_CODE_3||FM78_CODE_4||FM78_CODE_5 as BMVF,RTBM_BEZ as BM_DESCR,RTBM_TY as TY,STYP_BEZ as TY_DESCR,RTBM_KL as KL,SKLA_BEZ as KL_DESCR,FM78_LD as LD,SLAN_BEZ as LD_DESCR,RMBL_MB as MB,SMBR_BEZ as MB_DESCR,RVMB_VB as VB,SVBR_BEZ as VB_DESCR,FM78_CODE_L as VAR, CASE WHEN FJ78_KENNZ='%' THEN FJ78_WERT_REL ELSE FJ78_WERT_ABS END AS JAHRESVORGABE ,FJ78_KENNZ AS JAHRESVORGABE_KZ  FROM V68RFM78 LEFT OUTER JOIN V68RRTBM ON RTBM_SP=FM78_SP AND RTBM_WK=FM78_WK AND RTBM_FU=FM78_FU AND RTBM_FZBM_12=FM78_FZBM_12 AND RTBM_FZBM_3=FM78_FZBM_3 AND RTBM_FZBM_4=FM78_FZBM_4 AND RTBM_FZBM_5=FM78_FZBM_5 AND RTBM_FZBM_6=FM78_FZBM_6 AND RTBM_FZBM_7=FM78_FZBM_7 AND RTBM_FZBM_8=FM78_FZBM_8 AND RTBM_CODE_MOTOR=FM78_CODE_MOTOR AND RTBM_CODE_FHAUS=FM78_CODE_2 AND RTBM_CODE_TONN=FM78_CODE_3 AND RTBM_CODE_RADST=FM78_CODE_4 AND RTBM_CODE_FEDER=FM78_CODE_5 AND ((202000 >= (RTBM_JJ_VON*100) AND 202000<=(RTBM_JJ_BIS*100)) or (202000 >= (RTBM_HO_JJ_VON*100) AND 202000<=(RTBM_JJ_BIS*100)))  LEFT OUTER JOIN V68RSLAN ON SLAN_SP=FM78_SP AND SLAN_LD=FM78_LD AND (202000 >= (SLAN_JJ_VON*100) AND 202000<=(SLAN_JJ_BIS*100))  LEFT OUTER JOIN V68RRMBL ON RMBL_SP=FM78_SP AND RMBL_LD=FM78_LD AND (202000 >= (RMBL_JJ_VON*100) AND 202000<=(RMBL_JJ_BIS*100))  LEFT OUTER JOIN V68RSMBR ON RMBL_SP=SMBR_SP AND RMBL_MB=SMBR_MB AND (202000 >= (RMBL_JJ_VON*100) AND 202000<=(RMBL_JJ_BIS*100))  LEFT OUTER JOIN V68RRVMB ON RVMB_SP=RMBL_SP AND RVMB_MB=RMBL_MB AND (202000 >= (RVMB_JJ_VON*100) AND 202000<=(RVMB_JJ_BIS*100))  LEFT OUTER JOIN V68RSVBR ON SVBR_SP=RVMB_SP AND SVBR_VB=RVMB_VB AND (202000 >= (SVBR_JJ_VON*100) AND 202000<=(SVBR_JJ_BIS*100))  LEFT OUTER JOIN V68RSKLA ON SKLA_SP=RTBM_SP AND SKLA_WK=RTBM_WK AND SKLA_FU=RTBM_FU AND SKLA_KL=RTBM_KL AND (202000 >= (SKLA_JJ_VON*100) AND 202000<=(SKLA_JJ_BIS*100))  LEFT OUTER JOIN V68RSTYP ON STYP_SP=RTBM_SP AND STYP_WK=RTBM_WK AND STYP_FU=RTBM_FU AND STYP_TY=RTBM_TY AND STYP_KL=RTBM_KL AND (202000 >= (STYP_JJ_VON*100) AND 202000<=(STYP_JJ_BIS*100))  LEFT OUTER JOIN V68RFJ78 ON FJ78_SP=FM78_SP AND FJ78_WK=FM78_WK AND FJ78_FU=FM78_FU AND FJ78_AL6=FM78_AL6 AND FJ78_AL7=FM78_AL7 AND FJ78_FZBM_12=FM78_FZBM_12 AND FJ78_FZBM_3=FM78_FZBM_3 AND FJ78_FZBM_4=FM78_FZBM_4 AND FJ78_FZBM_5=FM78_FZBM_5 AND FJ78_FZBM_6=FM78_FZBM_6 AND FJ78_FZBM_7=FM78_FZBM_7 AND FJ78_FZBM_8=FM78_FZBM_8 AND FJ78_CODE_MOTOR=FM78_CODE_MOTOR AND FJ78_CODE_2=FM78_CODE_2 AND FJ78_CODE_3=FM78_CODE_3 AND FJ78_CODE_4=FM78_CODE_4 AND FJ78_CODE_5=FM78_CODE_5 AND FJ78_CODE_L=FM78_CODE_L AND FJ78_LD=FM78_LD AND FJ78_JJ=FM78_JJ WHERE  FM78_SP='7' AND FM78_WK='0650' AND FM78_FU='01'  AND FM78_AL6='RECVSG' AND FM78_AL7='1' AND FM78_JJ=2020";
    String queryTemp = "select 1 from sysibm.sysdummy1";

    @RequestMapping("jdbctestOnlyOne")
    public @ResponseBody ResponseEntity<String> example() {
    	long before = System.currentTimeMillis(); 
        jdbcTemplate.queryForList(query);
        long duration =  System.currentTimeMillis() - before;
        return new ResponseEntity<String>("Query-duration: " + Long.valueOf(duration).toString() + " ms", HttpStatus.OK);
    }

    @RequestMapping("jdbctest")
    public ResponseEntity<ResultSummary> exampleParam(@RequestParam(name="count") String countStr) {
    	ResultSummary summary = new ResultSummary();
    	List<Result> results = new ArrayList<Result>();
    	int count = 1;
    	try {
        	count = Integer.parseInt(countStr);
    	} catch (Exception e) {
		}
    	StringBuilder sb = new StringBuilder();
    	sb.append("TestNr,Dauer\n");
    	long common = 0;
    	for (int i = 0; i < count; i++) {
    		Result obj = new Result();
        	long before = System.currentTimeMillis(); 
        	try {
        		jdbcTemplate.queryForList(query);
                obj.setError(false);       		
        	} catch (Throwable e) {
                obj.setError(true);			
            }
            long duration =  System.currentTimeMillis() - before;
            obj.setNr(i + 1);
            long elapsed = duration/1000;
            obj.setElapsed(elapsed);
            common = common + elapsed;
            results.add(obj);
    	}
    	summary.setCount(count);
    	summary.setQuery(query);
     	summary.setAverage(common/count);
     	summary.setResults(results);
    	return ResponseEntity.ok(summary);
    }

    @RequestMapping("h2jdbctest")
    public ResponseEntity<ResultSummary> exampleH2Param(@RequestParam(name="count") String countStr) {
    	ResultSummary summary = new ResultSummary();
    	List<Result> results = new ArrayList<Result>();
    	int count = 1;
    	try {
        	count = Integer.parseInt(countStr);
    	} catch (Exception e) {
		}
    	StringBuilder sb = new StringBuilder();
    	sb.append("TestNr,Dauer\n");
    	long common = 0;
    	for (int i = 0; i < count; i++) {
    		Result obj = new Result();
        	long before = System.currentTimeMillis(); 
        	try {
        		jdbcTemplate.queryForList(query);
                obj.setError(false);       		
        	} catch (Throwable e) {
                obj.setError(true);			
            }
            long duration =  System.currentTimeMillis() - before;
            obj.setNr(i + 1);
            long elapsed = duration/1000;
            obj.setElapsed(elapsed);
            common = common + elapsed;
            results.add(obj);
    	}
    	summary.setCount(count);
    	summary.setQuery(query);
     	summary.setAverage(common/count);
     	summary.setResults(results);
    	return ResponseEntity.ok(summary);
    }

    @RequestMapping("querytest")
    public ResponseEntity<ResultSummary> exampleParam(@RequestParam(name="count") String countStr,
    		@RequestParam(name="query") String queryStr) {
    	ResultSummary summary = new ResultSummary();
    	List<Result> results = new ArrayList<Result>();
    	int count = 1;
    	try {
        	count = Integer.parseInt(countStr);
    	} catch (Exception e) {
		}
    	StringBuilder sb = new StringBuilder();
    	sb.append("TestNr,Dauer\n");
    	long common = 0;
    	for (int i = 0; i < count; i++) {
    		Result obj = new Result();
        	long before = System.currentTimeMillis(); 
        	try {
        		jdbcTemplate.queryForList(queryStr);
                obj.setError(false);       		
        	} catch (Throwable e) {
                obj.setError(true);			
            }
            long duration =  System.currentTimeMillis() - before;
            obj.setNr(i + 1);
            long elapsed = duration/1000;
            obj.setElapsed(elapsed);
            common = common + elapsed;
            results.add(obj);
    	}
    	summary.setCount(count);
    	summary.setQuery(queryStr);
     	summary.setAverage(common/count);
     	summary.setResults(results);
    	return ResponseEntity.ok(summary);
    }
    
}
