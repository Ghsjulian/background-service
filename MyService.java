package com.my.test;


/*
import com.my.test.MyTextToSpeech;
import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import android.content.Context;
import android.speech.tts.TextToSpeech;
import java.util.Locale;

public class MyService extends Service {
	private MyTextToSpeech textTospeech;
	private Handler handler;
	private Runnable runnable;
	public static final int NOTIFICATION_ID = 1;

	@Override
	public void onCreate() {
		super.onCreate();
		handler = new Handler();
		runnable = new Runnable() {
			@Override
			public void runnable() {
				//	textTospeech = new MyTextToSpeech(MyService.this, "Hello, this is a test message.");
				Toast.makeText(getApplicationContext(), "Received request from localhost:8080", Toast.LENGTH_SHORT)
						.show();
				handler.postDelayed(runnable, 5000); // 5000 milliseconds = 5 seconds
			};
		};
		handler.post(runnable);

		// Start foreground service
		Notification notification = new NotificationCompat.Builder(this, "MyServiceChannel")
				.setContentTitle("MyService").setContentText("MyService is running").build();

		startForeground(NOTIFICATION_ID, notification);
	}



	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		return START_STICKY;
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
}
*/


import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {

    private Handler handler;
    private Runnable runnable;

    @Override
    public void onCreate() {
        super.onCreate();
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), "Received request from localhost:8080", Toast.LENGTH_SHORT).show();
                handler.postDelayed(this, 5000); // 5000 milliseconds = 5 seconds
            }
        };
        handler.post(runnable);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
