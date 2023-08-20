package com.am.amstore

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class GameActivity:AppCompatActivity() {

    lateinit var computerImageView: ImageView
    lateinit var scissorsImageButton: ImageButton
    lateinit var paperImageButton: ImageButton
    lateinit var rockImageButton: ImageButton
    lateinit var resultImageView: ImageView

    private fun initComponents(){
        computerImageView=findViewById(R.id.computerImageView)
        scissorsImageButton=findViewById(R.id.scissorsImageButton)
        paperImageButton=findViewById(R.id.paperImageButton)
        rockImageButton=findViewById(R.id.rockImageButton)
        resultImageView= findViewById(R.id.resultImageView)
    }

    private  fun iniListener(){
        scissorsImageButton.setOnClickListener{ startGame("SCISSORS")}
        paperImageButton.setOnClickListener{startGame("PAPER")}
        rockImageButton.setOnClickListener{startGame("ROCK")}
    }

    private  fun startGame(option:String){
        val computerOptions=Game.pickRandomOption()
        computerImageView.setImageResource(Game.pickDrawable(computerOptions))
        when{
            Game.isDraw(option,computerOptions)-> resultImageView.setImageResource(R.drawable.draw)
            Game.isWin(option,computerOptions)-> resultImageView.setImageResource(R.drawable.win)
            else->resultImageView.setImageResource(R.drawable.lose)
        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.game)
        initComponents()
        iniListener()
    }
}