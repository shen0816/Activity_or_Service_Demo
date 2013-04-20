package com.example.test;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class TestActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_test);
    System.out.println("onCreate B");
  }

  @Override
  protected void onDestroy() {
    // TODO Auto-generated method stub
    super.onDestroy();
    System.out.println("onDestroy B");
  }

  @Override
  protected void onPause() {
    // TODO Auto-generated method stub
    super.onPause();
    System.out.println("onPause B");
  }

  @Override
  protected void onRestart() {
    // TODO Auto-generated method stub
    super.onRestart();
    System.out.println("onRestart B");
  }

  @Override
  protected void onResume() {
    // TODO Auto-generated method stub
    super.onResume();
    System.out.println("onResume B");
  }

  @Override
  protected void onStart() {
    // TODO Auto-generated method stub
    super.onStart();
    System.out.println("onStart B");
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

}
