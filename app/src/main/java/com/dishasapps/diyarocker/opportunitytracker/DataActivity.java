package com.dishasapps.diyarocker.opportunitytracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

public class DataActivity extends Activity {
    public static String accountName = "";
    private int cols = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        displayData();
    }
    public void displayData()
    {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Account");
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> objects, ParseException e) {
                if(objects.size()!=0) {
                    TableLayout buttonsLayout = (TableLayout) findViewById(R.id.buttonsTable);
                    for (ParseObject m : objects) {
                        TableRow row = new TableRow(DataActivity.this);
                        buttonsLayout.addView(row);

                        final String name = "" + m.get("name");
                        Button account = new Button(DataActivity.this);
                        account.setText(name);
                        account.setOnClickListener(new View.OnClickListener()
                        {
                        @Override
                        public void onClick(View v) {
                            accountName = name;
                            editAccount();
                        }

                            private void editAccount() {
                                Intent i = new Intent(DataActivity.this, AccountActivity.class);
                                startActivity(i);
                            }
                        });
                        row.addView(account);

                        String type = "" + m.get("workType");
                        System.out.println(type);
                        TextView workType = new TextView(DataActivity.this);
                        workType.setText(type);
                        workType.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
                        row.addView(workType);

                        String log = "" + m.get("log");
                        System.out.println(log);
                        TextView activityLog = new TextView(DataActivity.this);
                        activityLog.setText(log);
                        activityLog.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
                        row.addView(activityLog);

                        }
                    }

                else {
                    return;
                }
            }
        });

    }

    public static String getAccountName() {
        return accountName;
    }
    public void newOpp(View v)
    {
        Intent i = new Intent(DataActivity.this, NewOMActivity.class);
        startActivity(i);
    }
/*    public void report(View v)
    {
        Intent i = new Intent(DataActivity.this, ReportActivity.class);
        startActivity(i);
    }*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.data, menu);
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
