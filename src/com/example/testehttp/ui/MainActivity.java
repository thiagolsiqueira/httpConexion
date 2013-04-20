package com.example.testehttp.ui;

import java.io.UnsupportedEncodingException;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.example.testehttp.R;
import com.example.testhttp.core.Constants;
import com.exmple.testehttp.connection.Connection;

public class MainActivity extends Activity {
private ProgressDialog dialog;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		dialog = new ProgressDialog(MainActivity.this);
		dialog.setMessage("carregando...");
		dialog.show();
		new TestConn().execute();
	}

	private class TestConn extends AsyncTask<Void, Void, String> {

		@Override
		protected String doInBackground(Void... params) {

			try {
				 String result = Connection.sendRequestGet(Constants.URL);
				 return result;
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			return null;
		}

		@Override
		protected void onPostExecute(String result) {
			
			dialog.dismiss();

			if (result != null) {
				Log.i(Constants.TAG, result);
			}

			super.onPostExecute(result);
		}
	}

}
