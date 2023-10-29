package com.example.mad_practical6_21012011120
import android.content.Intent
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    var flag=0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var playAudio:FloatingActionButton=findViewById<FloatingActionButton>(R.id.play);
        playAudio.setOnClickListener { play();
            val b:FloatingActionButton=findViewById<FloatingActionButton>(R.id.play);
            if(flag==0){
                b.setImageResource(R.drawable.baseline_stop_24);
                flag=1;
            }
            else
            {
                b.setImageResource(R.drawable.baseline_play_arrow_24);
                flag=0;
            }

        }
        var stopAudio:FloatingActionButton=findViewById<FloatingActionButton>(R.id.stop);
        stopAudio.setOnClickListener { stop() };
        val b:FloatingActionButton=playAudio;
    }

    fun play(){
        Intent(applicationContext,MyService::class.java).putExtra(MyService.PLAYERKEY,MyService.PLAYERVALUE).apply { startService(this) };
    }

    fun stop(){
        Intent(applicationContext,MyService::class.java).putExtra(MyService.PLAYERKEY,MyService.PLAYERVALUE).apply { stopService(this) };
    }
}
