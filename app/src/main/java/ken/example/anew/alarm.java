package ken.example.anew;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.os.PowerManager;
import android.widget.Toast;

public class alarm extends BroadcastReceiver {
    MediaPlayer mp= null;
    private  static final  String TAG = "VPET";

    @Override
    public void onReceive(Context context, Intent intent) {
        PowerManager pm= (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        PowerManager.WakeLock wl= pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,"AlarmManagerActivity:TAG");
        wl.acquire();
        //Put ur code//
        Toast.makeText(context, "Your Alarm", Toast.LENGTH_SHORT).show();

        AudioManager audio= (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        MediaPlayer player= MediaPlayer.create(context, RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE));
        try {
            player.setVolume((float) (audio.getStreamVolume(AudioManager.STREAM_ALARM)),
                    (float) (audio.getStreamVolume(AudioManager.STREAM_ALARM)));
        } catch (Exception e){
            e.printStackTrace();
        }

        player.start();
        wl.release();
    }
}
