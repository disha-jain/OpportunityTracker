package com.dishasapps.diyarocker.opportunitytracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.parse.ParseObject;


public class NewOMActivity extends Activity {
    EditText accountNameBox;
    EditText countBox;
    EditText guBox;
    Spinner progACNBox;
    Spinner capBox;
    EditText workTypeBox;
    Spinner leadBox;
    EditText supportBox;
    EditText logBox;
    Spinner inSAPBox;
//    Spinner stageGateBox;
    Spinner quarterBox;
    EditText winProbBox ;
    EditText revenueBox;
    EditText resRecBox;
    EditText onSMBox;
    EditText onMBox;
    EditText onCBox;
    EditText onABox;
    EditText offSMBox;
    EditText offMBox;
    EditText offCBox;
    EditText offABox;
    EditText inSMBox;
    EditText inMBox;
    EditText inCBox;
    EditText inABox;
    EditText createdBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_om);
        accountNameBox = (EditText) findViewById(R.id.accountName);
        countBox = (EditText) findViewById(R.id.countValue);
        guBox = (EditText) findViewById(R.id.guValue);
        progACNBox = (Spinner) findViewById(R.id.progACNValue);
        capBox = (Spinner) findViewById(R.id.capValue);
        workTypeBox = (EditText) findViewById(R.id.workTypeValue);
        leadBox = (Spinner) findViewById(R.id.leadValue);
        supportBox = (EditText) findViewById(R.id.supportValue);
        logBox = (EditText) findViewById(R.id.logValue);
        inSAPBox = (Spinner) findViewById(R.id.inSAPValue);
//        stageGateBox = (Spinner) findViewById(R.id.stageGateValue);
        quarterBox = (Spinner) findViewById(R.id.quarterValue);
        winProbBox = (EditText) findViewById(R.id.winProbValue);
        revenueBox = (EditText) findViewById(R.id.revenueValue);
        resRecBox = (EditText) findViewById(R.id.resRecValue);
        onSMBox = (EditText) findViewById(R.id.onSMValue);
        onMBox = (EditText) findViewById(R.id.onMValue);
        onCBox = (EditText) findViewById(R.id.onCValue);
        onABox = (EditText) findViewById(R.id.onAValue);
        offSMBox = (EditText) findViewById(R.id.offSMValue);
        offMBox = (EditText) findViewById(R.id.offMValue);
        offCBox = (EditText) findViewById(R.id.offCValue);
        offABox = (EditText) findViewById(R.id.offAValue);
        inSMBox = (EditText) findViewById(R.id.inSMValue);
        inMBox = (EditText) findViewById(R.id.inMValue);
        inCBox = (EditText) findViewById(R.id.inCValue);
        inABox = (EditText) findViewById(R.id.inAValue);
        createdBox = (EditText) findViewById(R.id.createdValue);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.new_om, menu);
        return true;
    }
    public void saveNewOM(View v)
    {
        String accountName = String.valueOf(accountNameBox.getText());
        String count = String.valueOf(countBox.getText());
        String gu = String.valueOf(guBox.getText());
        String progACN = String.valueOf(progACNBox.getSelectedItem());
        String capability = String.valueOf(capBox.getSelectedItem());
        String workType = String.valueOf(workTypeBox.getText());
        String lead = String.valueOf(leadBox.getSelectedItem());
        String support = String.valueOf( supportBox.getText());
        String log = String.valueOf( logBox.getText());
        String inSAP = String.valueOf( inSAPBox.getSelectedItem());
//        String stageGate = String.valueOf( stageGateBox.getSelectedItem());
        String quarter = String.valueOf( quarterBox.getSelectedItem());
        String winProb = String.valueOf( winProbBox.getText());
        String revenue = String.valueOf( revenueBox.getText());
        String resRec = String.valueOf( resRecBox.getText());
        String onSM = String.valueOf( onSMBox.getText());
        String onM = String.valueOf( onMBox.getText());
        String onC = String.valueOf( onCBox.getText());
        String onA = String.valueOf( onABox.getText());
        String offSM = String.valueOf( offSMBox.getText());
        String offM = String.valueOf( offMBox.getText());
        String offC = String.valueOf( offCBox.getText());
        String offA = String.valueOf( offABox.getText());
        String inSM = String.valueOf( inSMBox.getText());
        String inM = String.valueOf( inMBox.getText());
        String inC = String.valueOf( inCBox.getText());
        String inA = String.valueOf( inABox.getText());
        String created = String.valueOf( createdBox.getText());
        ParseObject account = new ParseObject("Account");
        account.put("name", accountName);
        account.put("count", count);
        account.put("gu", gu);
        account.put("progACN", progACN);
        account.put("capability", capability);
        account.put("workType", workType);
        account.put("lead", lead);
        account.put("support", support);
        account.put("log", log);
        account.put("inSAP", inSAP);
 //       account.put("stageGate", stageGate);
        account.put("quarter", quarter);
        account.put("winProb", winProb);
        account.put("revenue", revenue);
        account.put("resRec", resRec);
        account.put("onSM", onSM);
        account.put("onM", onM);
        account.put("onC", onC);
        account.put("onA", onA);
        account.put("offSM", offSM);
        account.put("offM", offM);
        account.put("offC", offC);
        account.put("offA", offA);
        account.put("inSM", inSM);
        account.put("inM", inM);
        account.put("inC", inC);
        account.put("inA", inA);
        account.put("created", created);
        account.saveInBackground();
        Intent i = new Intent (NewOMActivity.this, DataActivity.class);
        startActivity(i);
    }
    public void cancel(View v)
    {
        Intent i = new Intent(NewOMActivity.this, DataActivity.class);
        startActivity(i);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
