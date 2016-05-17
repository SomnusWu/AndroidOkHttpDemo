package com.somnus.androidokhttpdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.somnus.androidokhttpdemo.model.IP;

import okhttp3.Call;

/**
 * https://github.com/hongyangAndroid/okhttp-utils
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void onGetIp(View view){
        httpHelper.getIp("202.202.32.202", ipCallBack);
    }



    private IPCallBack ipCallBack = new IPCallBack() {
        @Override
        public void onError(Call call, Exception e) {
            //TODO   ...  ..
        }

        @Override
        public void onResponse(IP response) {
            Log.d("IP---->",response.toString());
            Log.d("http request Tag  ->",+ipCallBack.getTag()+"");
            Toast.makeText(MainActivity.this,"IP"+response.toString(),Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        OkHttpUtils.getInstance().cancelTag(AppEnvironment.HttpGetIPTAG);
    }
}
