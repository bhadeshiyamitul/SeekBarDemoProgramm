package com.ubrain.seekbarrgbdemoprogramm

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.SeekBar
import android.widget.TextView

//4)create screen like below image and change background color after sliding the seekbar (back- ground should be in RGB color)

class SeekbarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seekbar)
getSupportActionBar()!!.hide()

        var linearLayout=findViewById(R.id.linear_layout) as LinearLayout
        var seekbarRed=findViewById(R.id.seekBar1) as SeekBar
        var seekbarGreen=findViewById(R.id.seekBar2) as SeekBar
        var seekbarBlue=findViewById(R.id.seekBar3) as SeekBar

        var txtRed=findViewById(R.id.txt_red) as TextView
        var txtGreen=findViewById(R.id.txt_green) as TextView
        var txtBlue=findViewById(R.id.txt_blue) as TextView

        fun updateBackground()
        {
            var sred=seekbarRed.getProgress()
            var sgreen=seekbarGreen.getProgress()
            var sblue=seekbarBlue.getProgress()
            var color= arrayOf<Int>(sred,sgreen,sblue)
            txtRed.setText(seekbarRed.getProgress().toString())
            txtGreen.setText(seekbarGreen.getProgress().toString())
            txtBlue.setText(seekbarBlue.getProgress().toString())

            fun getHexColor(color:Array<Int>):Int {
                return android.graphics.Color.rgb(color[0], color[1], color[2]);
            }
            linearLayout.setBackgroundColor(getHexColor(color))
        }

        var seekBarListener:SeekBar.OnSeekBarChangeListener=object:SeekBar.OnSeekBarChangeListener
        {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
               updateBackground()

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        }
        seekbarRed.setOnSeekBarChangeListener(seekBarListener)
        seekbarGreen.setOnSeekBarChangeListener(seekBarListener)
        seekbarBlue.setOnSeekBarChangeListener(seekBarListener)






       /* seekbarRed.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener
        {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })*/
    }
}
