package com.example.test;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;

public class MyService extends Service implements Runnable{

  public class LocalBinder extends Binder {
    public MyService getService(){
      return MyService.this;
    }
  }
  
  private final IBinder mBinder = new LocalBinder();
  
  @Override
  public IBinder onBind(Intent intent) {
    // TODO: Return the communication channel to the service.
    System.out.println("onBind()");
    this.startTime();
    return mBinder;
  }

  @Override
  public void onCreate() {
    // TODO Auto-generated method stub
    super.onCreate();
    System.out.println("onCreate()");
  }

  @Override
  public void onDestroy() {
    // TODO Auto-generated method stub
    super.onDestroy();
    _b =false;
    System.out.println("onDestroy()");
  }

  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    // TODO Auto-generated method stub
    System.out.println("onStartCommand()");
    
    return super.onStartCommand(intent, flags, startId);
  }

  @Override
  public boolean onUnbind(Intent intent) {
    // TODO Auto-generated method stub
    System.out.println("onUnbind()");
    return super.onUnbind(intent);
  }
  
  private int time = 0;
  private Thread thread;
  private boolean _b = false;
  
  public int getTime() {
    return time;
  }
  
  public void startTime(){
    thread = new Thread(this);
    _b = true;
    thread.start();
  }
  
  private Handler handler;
  
  public void setHandler(Handler handler){
    this.handler = handler;
  }

  @Override
  public void run() {
    // TODO Auto-generated method stub
    while(_b){
      try {
        Thread.sleep(1000);
        time++;
        Message msg = new Message();
        msg.what = 1;
        handler.sendMessage(msg);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
  
  private MainActivity main;
  public void setMainActivity(MainActivity m){
    main = m;
  }
  
  public void test(){
    System.out.println("0000000000000");
    
    System.out.println("aaaaaaaaaaaaaa");
    
    System.out.println("asdasdasdasd1");
  }
}
