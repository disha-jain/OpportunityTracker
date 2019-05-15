package com.dishasapps.diyarocker.opportunitytracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;


public class AccountActivity extends Activity {
    String name;


    TextView accountLabel;
    TextView countLabel;
    TextView guLabel;
    TextView progACNLabel;
    TextView capLabel;
    TextView workTypeLabel;
    TextView leadLabel;
    TextView supportLabel;
    TextView logLabel;
    TextView inSAPLabel;
    TextView quarterLabel;
    TextView winProbLabel;
    TextView revenueLabel;
    TextView resRecLabel;
    TextView onSMLabel;
    TextView onMLabel;
    TextView onCLabel;
    TextView onALabel;
    TextView offSMLabel;
    TextView offMLabel;
    TextView offCLabel;
    TextView offALabel;
    TextView inSMLabel;
    TextView inMLabel;
    TextView inCLabel;
    TextView inALabel;
    TextView createdLabel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        name = DataActivity.getAccountName();
        accountLabel = (TextView) findViewById(R.id.accountName);
        countLabel = (TextView) findViewById(R.id.countLabel);
        guLabel = (TextView) findViewById(R.id.guLabel);
        progACNLabel = (TextView) findViewById(R.id.progACNLabel);
        capLabel = (TextView) findViewById(R.id.capabilityLabel);
        workTypeLabel = (TextView) findViewById(R.id.workTypeLabel);
        leadLabel = (TextView) findViewById(R.id.leadLabel);
        supportLabel = (TextView) findViewById(R.id.supportLabel);
        logLabel = (TextView) findViewById(R.id.logLabel);
        inSAPLabel = (TextView) findViewById(R.id.inSAPLabel);
        quarterLabel = (TextView) findViewById(R.id.quarterLabel);
        winProbLabel = (TextView) findViewById(R.id.winProbabilityLabel);
        revenueLabel = (TextView) findViewById(R.id.revenueLabel);
        resRecLabel = (TextView) findViewById(R.id.resRecLabel);
        onSMLabel = (TextView) findViewById(R.id.onSMLabel);
        onMLabel = (TextView) findViewById(R.id.onMLabel);
        onCLabel = (TextView) findViewById(R.id.onCLabel);
        onALabel = (TextView) findViewById(R.id.onALabel);
        offSMLabel = (TextView) findViewById(R.id.offSMLabel);
        offMLabel = (TextView) findViewById(R.id.offMLabel);
        offCLabel = (TextView) findViewById(R.id.offCLabel);
        offALabel = (TextView) findViewById(R.id.offALabel);
        inSMLabel = (TextView) findViewById(R.id.inSMLabel);
        inMLabel = (TextView) findViewById(R.id.inMLabel);
        inCLabel = (TextView) findViewById(R.id.inCLabel);
        inALabel = (TextView) findViewById(R.id.inALabel);
        createdLabel = (TextView) findViewById(R.id.createdLabel);
        display();
    }
    public void display()
    {
        accountLabel.setText(name);
        System.out.println("Account: "+name);
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Account");
        query.whereEqualTo("name", "" + name);
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> scoreList, ParseException e) {
                for(ParseObject account: scoreList) {
                    countLabel.setText(account.get("count") + "");
                    guLabel.setText(account.get("gu") + "");
                    progACNLabel.setText(account.get("progACN") + "");
                    capLabel.setText(account.get("capability") + "");
                    workTypeLabel.setText(account.get("workType") + "");
                    leadLabel.setText(account.get("lead") + "");
                    supportLabel.setText(account.get("support") + "");
                    logLabel.setText(account.get("log") + "");
                    inSAPLabel.setText(account.get("inSAP") + "");
                    quarterLabel.setText(account.get("quarter") + "");
                    winProbLabel.setText(account.get("winProb") + "");
                    revenueLabel.setText(account.get("revenue") + "");
                    resRecLabel.setText(account.get("resRec") + "");
                    onSMLabel.setText(account.get("onSM") + "");
                    onMLabel.setText(account.get("onM") + "");
                    onCLabel.setText(account.get("onC") + "");
                    onALabel.setText(account.get("onA") + "");
                    offSMLabel.setText(account.get("offSM") + "");
                    offMLabel.setText(account.get("offM") + "");
                    offCLabel.setText(account.get("offC") + "");
                    offALabel.setText(account.get("offA") + "");
                    inSMLabel.setText(account.get("inSM") + "");
                    inMLabel.setText(account.get("inM") + "");
                    inCLabel.setText(account.get("inC") + "");
                    inALabel.setText(account.get("inA") + "");
                    createdLabel.setText(account.get("created") + "");
                    return;
                }

            }
        });    }
    public void edit(View v)
    {
        Intent i = new Intent(AccountActivity.this, EditActivity.class);
        startActivity(i);
    }
    public void returnOM(View v)
    {
        Intent i = new Intent(AccountActivity.this, DataActivity.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.account, menu);
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
