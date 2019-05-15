package com.dishasapps.diyarocker.opportunitytracker;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;


public class EditActivity extends Activity {

    String name;
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
    ParseObject object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        name = DataActivity.getAccountName();
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
        display();
    }
    public void delete(View v)
    {
        object.deleteInBackground();
        Intent i = new Intent(EditActivity.this, DataActivity.class);
        startActivity(i);
    }
    public void display()
    {
        accountNameBox.setText(name);
        System.out.println("Account: "+name);
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Account");
        query.whereEqualTo("name", "" + name);
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> scoreList, ParseException e) {
                for(ParseObject account: scoreList) {
                    object = account;
                    countBox.setText(account.get("count") + "");
                    guBox.setText(account.get("gu") + "");
                    progACNBox.setSelection(getPosition(account, "progACN"));
                    capBox.setSelection(getPosition(account, "capability"));
                    workTypeBox.setText(account.get("workType") + "");
                    leadBox.setSelection(getPosition(account, "lead"));
                    supportBox.setText(account.get("support") + "");
                    logBox.setText(account.get("log") + "");
                    inSAPBox.setSelection(getPosition(account, "inSAP"));
                    quarterBox.setSelection(getPosition(account, "quarter"));
                    winProbBox.setText(account.get("winProb") + "");
                    revenueBox.setText(account.get("revenue") + "");
                    resRecBox.setText(account.get("resRec") + "");
                    onSMBox.setText(account.get("onSM") + "");
                    onMBox.setText(account.get("onM") + "");
                    onCBox.setText(account.get("onC") + "");
                    onABox.setText(account.get("onA") + "");
                    offSMBox.setText(account.get("offSM") + "");
                    offMBox.setText(account.get("offM") + "");
                    offCBox.setText(account.get("offC") + "");
                    offABox.setText(account.get("offA") + "");
                    inSMBox.setText(account.get("inSM") + "");
                    inMBox.setText(account.get("inM") + "");
                    inCBox.setText(account.get("inC") + "");
                    inABox.setText(account.get("inA") + "");
                    createdBox.setText(account.get("created") + "");
                    return;
                }

            }
        });    }

    public int getPosition(ParseObject m, String field) {
        Resources res = getResources();
        String entry = m.get(field) + "";
        String[] entries = null;
        if (field.equals("progACN"))
            entries = res.getStringArray(R.array.acn_array);
        else if (field.equals("capability"))
            entries = res.getStringArray(R.array.cap_array);
        else if (field.equals("lead"))
            entries = res.getStringArray(R.array.cap_array);
        else if (field.equals("inSAP"))
            entries = res.getStringArray(R.array.cap_array);
        else if (field.equals("quarter"))
            entries = res.getStringArray(R.array.cap_array);
        int pos = -1;
        if (entries != null) {
            for (int k = 0; k < entries.length; k++) {
                if (entries[k].equals(entry))
                    pos = k;
            }
        }
        return pos;
    }

    public void cancel(View v)
    {
        Intent i = new Intent(EditActivity.this, AccountActivity.class);
        startActivity(i);
    }
    public void update(View v)
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
        object.put("name", accountName);
        object.put("count", count);
        object.put("gu", gu);
        object.put("progACN", progACN);
        object.put("capability", capability);
        object.put("workType", workType);
        object.put("lead", lead);
        object.put("support", support);
        object.put("log", log);
        object.put("inSAP", inSAP);
        //       object.put("stageGate", stageGate);
        object.put("quarter", quarter);
        object.put("winProb", winProb);
        object.put("revenue", revenue);
        object.put("resRec", resRec);
        object.put("onSM", onSM);
        object.put("onM", onM);
        object.put("onC", onC);
        object.put("onA", onA);
        object.put("offSM", offSM);
        object.put("offM", offM);
        object.put("offC", offC);
        object.put("offA", offA);
        object.put("inSM", inSM);
        object.put("inM", inM);
        object.put("inC", inC);
        object.put("inA", inA);
        object.put("created", created);
        object.saveInBackground();
        Intent i = new Intent (EditActivity.this, AccountActivity.class);
        startActivity(i);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.edit, menu);
        return true;
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
