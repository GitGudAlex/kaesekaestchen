package dreamTeam.Threads;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Music implements Runnable{

   // public static synchronized void music (String track, boolean play){}
        final String trackname = "music/sound.wav";

        Thread thread = null;

        public synchronized void start() {
        if(thread == null){
            thread = new Thread((this));
            thread.start();
        }
        }

       public synchronized void stop(){
            if(thread != null){
                thread = null;
            }
        }

        public synchronized void interrupt(){
            if(thread != null){
                thread.interrupt();
            }
        }

        public void run(){
            while (thread!=null) {

                try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputstream = AudioSystem.getAudioInputStream(new File(trackname));
                    //stillPlaying(play);
                    clip.open(inputstream);
                    clip.loop(clip.LOOP_CONTINUOUSLY);

                    Thread.sleep(clip.getMicrosecondLength() / 1);
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            }}



        /*new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputstream = AudioSystem.getAudioInputStream(new File(trackname));
                    stillPlaying(play);
                    clip.open(inputstream);
                    clip.loop(clip.LOOP_CONTINUOUSLY);

                    Thread.sleep(clip.getMicrosecondLength()/1);
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }).start();*/


    private static void stillPlaying(boolean play){
      if(!play){

      }
    };


}
