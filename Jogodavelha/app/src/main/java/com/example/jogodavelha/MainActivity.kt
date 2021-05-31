package com.example.jogodavelha

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnClick(view: View) {
        val btnSelect = view as Button
        var cellId = 0

        when(btnSelect.id) {
            R.id.btn1 -> cellId = 1
            R.id.btn2 -> cellId = 2
            R.id.btn3 -> cellId = 3
            R.id.btn4 -> cellId = 4
            R.id.btn5 -> cellId = 5
            R.id.btn6 -> cellId = 6
            R.id.btn7 -> cellId = 7
            R.id.btn8 -> cellId = 8
            R.id.btn9 -> cellId = 9
        }
        playGame(cellId, btnSelect)
    }

    //guardar jogadas
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    // turno do jogador
    var activate = 1

    fun playGame(cellId:Int, btnSelect: Button) {

        if(activate == 1) {
            btnSelect.text = "X"
            btnSelect.setBackgroundColor(Color.GREEN)
            player1.add(cellId)
            activate = 2
        } else {
            btnSelect.text = "O"
            btnSelect.setBackgroundColor(Color.RED)
            player2.add(cellId)
            activate = 1
        }
        btnSelect.isEnabled = false

        checkWinner()
    }

    fun checkWinner() {
        var winner = -1

        //DIAGONAL
        if(player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1
        }
        if(player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2
        }
        if(player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winner = 1
        }
        if(player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winner = 2
        }

        //COLUNA
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }

        //LINHA
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }

        if(winner != -1) {
            if(winner == 1) {
                Toast.makeText(this, "player 1 win the game", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "player 2 win the game", Toast.LENGTH_SHORT).show()
            }
        }
    }
}