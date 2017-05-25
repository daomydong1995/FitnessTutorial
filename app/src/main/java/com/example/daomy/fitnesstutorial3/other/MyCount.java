//package com.example.daomy.fitnesstutorial3.other;
//
//import android.os.CountDownTimer;
//import android.widget.TextView;
//
//import com.example.daomy.fitnesstutorial3.R;
//
//import java.util.Timer;
//
///**
// * Created by daomy on 5/25/2017.
// */
//
//public class MyCount extends CountDownTimer {
//    public MyCount(long millisInFuture, long countDownInterval) {
//        super(millisInFuture, countDownInterval);
//    }//MyCount
//
//    public void onResume1() {
//        onResume();
//    }
//
//    public void onPause1() {
//        onPause();
//    }
//
//    public void onFinish() {
//        Timer.setText("00:00");
//        p1++;
//        if (p1 <= 4) {
//            TextView PScore = (TextView) findViewById(R.id.pscore);
//            PScore.setText(p1 + "");
//        }//end if
//    }//finish
//
//    public void onTick(long millisUntilFinished) {
//        Integer milisec = new Integer(new Double(millisUntilFinished).intValue());
//        Integer cd_secs = milisec / 1000;
//
//        Integer minutes = (cd_secs % 3600) / 60;
//        Integer seconds = (cd_secs % 3600) % 60;
//
//        Timer.setText(String.format("%02d", minutes) + ":"
//                + String.format("%02d", seconds));
//        ///long timeLeft = millisUntilFinished / 1000;
//        }//on tick
//    protected void onResume() {
//        super.onResume();
//        //handler.removeCallbacks(updateTimeTask);
//        //handler.postDelayed(updateTimeTask, 1000);
//    }//onResume
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        //do stuff
//    }//onPause
//}
//
//
//
