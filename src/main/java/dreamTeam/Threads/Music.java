package dreamTeam.Threads;

import dreamTeam.App;
import dreamTeam.CustomExceptions.MusicSleepException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class Music implements Runnable{

    private static final Logger logger = LogManager.getLogger(App.class);

   // public static synchronized void music (String track, boolean play){}
        private final String trackname = "music/sound.wav";

        private Thread thread = null;

        public synchronized void start() {
        if(thread == null){


            thread = new Thread((this));


            logger.info("Thread start");
            thread.start();
        }
        }


        public synchronized void interrupt(){
            if(thread != null){
                logger.info("Thread interrupt");
                thread.interrupt();
            }
        }

        public void run(){
            while (thread!=null && !thread.isInterrupted()) {

                try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputstream = AudioSystem.getAudioInputStream(new File(trackname));
                    //stillPlaying(play);
                    clip.open(inputstream);

                    logger.debug("Length of clip: " + clip.getMicrosecondLength());

                    clip.loop(clip.LOOP_CONTINUOUSLY);

                    logger.debug("Threads state" + thread.toString());



                    logger.debug("Mööp - Music");


                    Thread.sleep(clip.getMicrosecondLength() / 1);

                } catch (LineUnavailableException l) {
                    logger.error("Line Unavailable");
                } catch (UnsupportedAudioFileException u){
                    logger.error("Unsupported Audio File");
                } catch (IOException i){
                    logger.error("Input Stream");
                }catch (InterruptedException e){
                    logger.error("Thread sleep interrupted");
                    throw new MusicSleepException("Thread sleep interrupted");


                }
            }

        }



}
