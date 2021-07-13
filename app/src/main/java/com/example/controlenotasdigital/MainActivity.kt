package com.example.controlenotasdigital

import android.graphics.Color
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btCalcular = btnCalcular
        val resultado :TextView = resultadoAluno

        btCalcular.setOnClickListener {
            val nota1 :Int = Integer.parseInt(nota1.text.toString())
            val nota2 :Int = Integer.parseInt(nota2.text.toString())
            val media : Int = (nota1 + nota2)/2
            val faltas :Int = Integer.parseInt(faltas.text.toString())

            if (media >=6 && faltas <=10){
                resultado.setText("Aluno foi aprovado." + "\n" + "Nota final: " + media+"\n" + "Faltas: " + faltas)
                resultado.setTextColor(Color.GREEN)
            }
            else{
                resultado.setText("Aluno foi reprovado." + "\n" + "Nota final: " + media+"\n" + "Faltas: " + faltas)
                resultado.setTextColor(Color.RED)
            }
            val imm: InputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            if (imm.isActive()) imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
        }

    }
}