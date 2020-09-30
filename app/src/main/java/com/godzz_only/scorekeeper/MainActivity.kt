package com.godzz_only.scorekeeper

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val STATE_SCORE_1 = "Team 1 Score"
    val STATE_SCORE_2 = "Team 2 Score"
    var mscore1:Int = 0
    var mscore2:Int = 0
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(STATE_SCORE_1,mscore1)
        outState.putInt(STATE_SCORE_2,mscore2)
        super.onSaveInstanceState(outState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState !=null){
            mscore1 = savedInstanceState.getInt(STATE_SCORE_1)
            mscore2 = savedInstanceState.getInt(STATE_SCORE_2)
            score_1.text = mscore1.toString()
            score_2.text = mscore2.toString()

        }
    }


    fun decreaseScore(view: View){
        when(view.id){
            R.id.decreaseTeam1->{
                if (mscore1>0){
                mscore1 -=1
                score_1.text = mscore1.toString()}
            }
            R.id.decreaseTeam2->{
                if(mscore2>0){
                mscore2 -=1
                score_2.text = mscore2.toString() }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
       var nightMode = AppCompatDelegate.getDefaultNightMode()
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu!!.findItem(R.id.night_mode).setTitle(R.string.day_mode)
        }
        else{
            menu!!.findItem(R.id.night_mode).setTitle(R.string.night_mode)
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.night_mode){
            var nightMode = AppCompatDelegate.getDefaultNightMode()
            if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
            else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }

            recreate()
        }
        return true
    }

    fun increaseScore(view: View){
        when(view.id){
            R.id.increaseTeam1->{
                mscore1 +=1
                score_1.text = mscore1.toString()
            }
            R.id.increaseTeam2->{
                mscore2 +=1
                score_2.text = mscore2.toString()
            }
        }
    }


}