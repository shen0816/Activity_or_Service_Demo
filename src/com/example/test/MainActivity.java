package com.example.test;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

  private Button buttonUpdate;
  private TextView textView;
  
  private Handler handler;
  
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    buttonUpdate = (Button) findViewById(R.id.buttonUpdate);
    textView = (TextView) findViewById(R.id.textView);
    
    buttonUpdate.setOnClickListener(new OnClickListener() {
      
      @Override
      public void onClick(View v) {
        // TODO Auto-generated method stub
        textView.setText("Time : " + myService.getTime());
        System.out.println("111111111111");
        myService.test();
        System.out.println("222222222222");
      }
    });
    
    
    System.out.println("onCreate A");
  }

  @Override
  protected void onDestroy() {
    // TODO Auto-generated method stub
    super.onDestroy();
    System.out.println("onDestroy A");
//    this.unbindService(mConnection);
//    this.stopService(new Intent(this, MyService.class));
  }

  @Override
  protected void onPause() {
    // TODO Auto-generated method stub
    super.onPause();
    System.out.println("onPause A");
  }

  @Override
  protected void onRestart() {
    // TODO Auto-generated method stub
    super.onRestart();
    System.out.println("onRestart A");
  }

  @Override
  protected void onResume() {
    // TODO Auto-generated method stub
    super.onResume();
    System.out.println("onResume A");
  }

  @Override
  protected void onStart() {
    // TODO Auto-generated method stub
    super.onStart();
    System.out.println("onStart A");
  }

  @Override
  protected void onStop() {
    // TODO Auto-generated method stub
    super.onStop();
    System.out.println("onStop A");
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // TODO Auto-generated method stub
    
    switch(item.getItemId()){
    case R.id.action_settings :
      startActivity(new Intent(this, TestActivity.class));
      break;
    case R.id.start_service :
      this.startService(new Intent(this, MyService.class));
      break;
    case R.id.bind_service :
      this.bindService(new Intent(this,MyService.class), mConnection, Context.BIND_AUTO_CREATE);
      break;
    case R.id.unbind_service :
      this.unbindService(mConnection);
      break;
    case R.id.stop_service :
      this.stopService(new Intent(this,MyService.class));
      break;
    }
    return super.onOptionsItemSelected(item);
  }

  private MyService myService;
  
  private ServiceConnection mConnection = new ServiceConnection() {
    
    @Override
    public void onServiceDisconnected(ComponentName name) {
      // TODO Auto-generated method stub
      myService = null;
      System.out.println("onServiceDisconnected()");
    }
    
    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
      // TODO Auto-generated method stub
      myService = ((MyService.LocalBinder)service).getService();
      myService.setMainActivity(MainActivity.this);
//      myService.startTime();
    }
  };
  
}
