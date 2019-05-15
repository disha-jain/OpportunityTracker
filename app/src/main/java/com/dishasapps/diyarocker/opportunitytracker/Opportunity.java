package com.dishasapps.diyarocker.opportunitytracker;

import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by Disha Jain on 9/15/14.
 */
public class Opportunity {

    private String account;
    private int count;
    private String gu;
    private Boolean programACN;
    private ArrayList<String> capability = new ArrayList<String>();
    private int capIndex = 0;
    private String workType;
    private ArrayList<String> lead = new ArrayList<String>();
    private int leadIndex = 0;
    private String support;
    private String log;
    private Boolean inSAP;
    private ArrayList<String> stageGate = new ArrayList<String>();
    private int stageGateIndex = 0;
    private ArrayList<String> quarter = new ArrayList<String>();
    private int quarterIndex = 0;
    private int winProbability;
    private double revenue;
    private String resRec;
    private String onSM;
    private String onM;
    private String onC;
    private String onA;
    private String offSM;
    private String offM;
    private String offC;
    private String offA;
    private String inSM;
    private String inM;
    private String inC;
    private String inA;
    private String created;
    public Opportunity(String name, String person)
    {
        account = name;
        created = person;
        capability.add("RE Strategy");
        capability.add("Operations");
        capability.add("Process and Technology");
        lead.add("Reilly");
        lead.add("White");
        lead.add("Jain");
        lead.add("Fitch");
        lead.add("Murphy");
        lead.add("Web");
        stageGate.add("1");
        stageGate.add("2B");
        stageGate.add("3B");
        quarter.add("Q1-2014");
        quarter.add("Q2-2014");
        quarter.add("Q3-2014");
        quarter.add("Q4-2014");
        quarter.add("Q1-2015");
        quarter.add("Q2-2015");
        quarter.add("Q3-2015");
        quarter.add("Q4-2015");
        quarter.add("Q1-2016");
        quarter.add("Q2-2016");
        quarter.add("Q3-2016");
        quarter.add("Q4-2016");
    }
    public void setCount(int c)
    {
        count = c;
    }
    public void setGU(String c)
    {
        gu = c;
    }
    public void setProgramACN(boolean c)
    {
        programACN = c;
    }
    public void addCapability(String c)
    {
        capability.add(c);
    }
    public void setCapabilityIndex(int c)
    {
        capIndex = c;
    }
    public void setWorkType(String c)
    {
        workType = c;
    }
    public void addLead(String c)
    {
        lead.add(c);
    }
    public void setLeadIndex(int c)
    {
        leadIndex = c;
    }
    public void setSupport(String c)
    {
        support = c;
    }
    public void setLog(String c)
    {
        log = c;
    }
    public void setInSAP(boolean c)
    {
        inSAP = c;
    }
    public void addStageGate(String c)
    {
        stageGate.add(c);
    }
    public void setStageGateIndex(int c)
    {
        stageGateIndex = c;
    }
    public void addQuarter(String c)
    {
        quarter.add(c);
    }
    public void setQuarterIndex(int c)
    {
        quarterIndex = c;
    }
    public boolean setWinProbability(int c)
    {
        if(c >= 0 && c <= 100)
        {
            winProbability = c;
            return true;
        }
        return false;
    }
    public void setRevenue(double c)
    {
        revenue = c;
    }
    public void setResRec(String c)
    {
        resRec = c;
    }
    public void setOnSM(String c)
    {
        onSM = c;
    }
    public void setOnM(String c)
    {
        onM = c;
    }
    public void setOnC(String c)
    {
        onC = c;
    }
    public void setOnA(String c)
    {
        onA = c;
    }
    public void setOffSM(String c)
    {
        offSM = c;
    }
    public void setOffM(String c)
    {
        offM = c;
    }
    public void setOffC(String c)
    {
        offC = c;
    }
    public void setOffA(String c)
    {
        offA = c;
    }
    public void setInSM(String c)
    {
        inSM = c;
    }
    public void setInM(String c)
    {
        inM = c;
    }
    public void setInC(String c)
    {
        inC = c;
    }
    public void setInA(String c)
    {
        inA = c;
    }
    public String getAccount()
    {
        return account;
    }
    public String getCreated()
    {
        return created;
    }
    public int getCount()
    {
        return count;
    }
    public String getGU()
    {
        return gu;
    }
    public boolean getProgramACN()
    {
        return programACN;
    }
    public ArrayList<String> getCapabilityArray()
    {
        return capability;
    }
    public String getCapability()
    {
        return capability.get(capIndex);
    }
    public String getWorkType()
    {
        return workType;
    }
    public ArrayList<String> getLeadArray()
    {
        return lead;
    }
    public String getLead()
    {
        return lead.get(leadIndex);
    }
    public String getSupport()
    {
        return support;
    }
    public String getLog()
    {
        return log;
    }
    public boolean getInSAP(boolean c)
    {
        return inSAP;
    }
    public ArrayList<String> getStageGateArray()
    {
        return stageGate;
    }
    public String getStageGate()
    {
        return stageGate.get(stageGateIndex);
    }
    public ArrayList<String> getQuarterArray()
    {
        return quarter;
    }
    public String getQuarter()
    {
        return(quarter.get(quarterIndex));
    }
    public int getWinProbability()
    {
        return winProbability;
    }
    public String setRevenue()
    {
        DecimalFormat deci = new DecimalFormat("0.00");
        return deci.format(revenue);
    }
    public String getResRec()
    {
        return resRec;
    }
    public String getOnSM()
    {
        return onSM;
    }
    public String getOnM()
    {
        return onM;
    }
    public String getOnC()
    {
        return onC;
    }
    public String getOnA()
    {
        return onA;
    }
    public String getOffSM()
    {
        return offSM;
    }
    public String getOffM()
    {
        return offM;
    }
    public String getOffC()
    {
        return offC;
    }
    public String getOffA()
    {
        return offA;
    }
    public String getInSM()
    {
        return inSM;
    }
    public String getInM()
    {
        return inM;
    }
    public String getInC()
    {
        return inC;
    }
    public String getInA()
    {
        return inA;
    }

}
