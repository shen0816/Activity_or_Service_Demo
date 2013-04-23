package com.example.test;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class TestActivity extends Activity {

  private Button button;
  private TextView textView;

  private Handler handler = new Handler() {

    @Override
    public void handleMessage(Message msg) {
      // TODO Auto-generated method stub
      super.handleMessage(msg);
      if (msg.what == 1) {
        textView.setText("Time : " + myService.getTime());
      }
    }

  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    startService(new Intent(this, MyService.class));
    bindService(new Intent(this, MyService.class), conn,
        Context.BIND_AUTO_CREATE);
    button = (Button) findViewById(R.id.buttonUpdate);
    textView = (TextView) findViewById(R.id.textView);

    button.setOnClickListener(new OnClickListener() {

      @Override
      public void onClick(View v) {
        // TODO Auto-generated method stub

        textView.setText("Time : " + myService.getTime());
      }
    });

  }

  @Override
  protected void onDestroy() {
    // TODO Auto-generated method stub
    super.onDestroy();
  }

  @Override
  protected void onPause() {
    // TODO Auto-generated method stub
    super.onPause();
  }

  @Override
  protected void onRestart() {
    // TODO Auto-generated method stub
    super.onRestart();
  }

  @Override
  protected void onResume() {
    // TODO Auto-generated method stub
    super.onResume();
  }

  @Override
  protected void onStart() {
    // TODO Auto-generated method stub
    super.onStart();
  }

  @Override
  protected void onStop() {
    // TODO Auto-generated method stub
    super.onStop();
    System.out.println("onStop B");
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.test, menu);
    return true;
  }

  private MyService myService;

  private ServiceConnection conn = new ServiceConnection() {

    @Override
    public void onServiceDisconnected(ComponentName name) {
      // TODO Auto-generated method stub

    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
      // TODO Auto-generated method stub
      myService = ((MyService.LocalBinder) service).getService();
      myService.setHandler(handler);
    }
  };

}
