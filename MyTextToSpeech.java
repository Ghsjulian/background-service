package com.my.test;
import android.speech.tts.TextToSpeech;
import android.content.Context;
import java.util.Locale;

public class MyTextToSpeech {
    private TextToSpeech textToSpeech;

    public MyTextToSpeech(Context context, final String text) {
        textToSpeech = new TextToSpeech(context, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.US);
                    textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
                }
            }
        });
    }

    public void shutdown() {
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
    }
}
