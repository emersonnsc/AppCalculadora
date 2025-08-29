package br.unimes.appsoma

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val edtNum1 = findViewById<EditText>(R.id.edt_num1)
        val edtNum2 = findViewById<EditText>(R.id.edt_num2)
        val btnSoma = findViewById<Button>(R.id.btn_somar)
        val btnSub = findViewById<Button>(R.id.btn_sub)
        val btnDiv = findViewById<Button>(R.id.btn_div)
        val btnMult = findViewById<Button>(R.id.btn_mult)

        btnSub.setOnClickListener {
            val num1 = edtNum1.text.toString().toInt()
            val num2 = edtNum2.text.toString().toInt()
            val sub = num1 - num2

            val builder = AlertDialog.Builder(this)
            builder.setTitle("RESULTADO!!")
            builder.setMessage("A Subtração é: $sub")
            val alert = builder.create()
            alert.show()
            edtNum1.text.clear()
            edtNum2.text.clear()
        }

        btnDiv.setOnClickListener {
            val num1 = edtNum1.text.toString().toInt()
            val num2 = edtNum2.text.toString().toInt()

            if (num2 == 0){
                val builder = AlertDialog.Builder(this)
                builder.setTitle("ERROR!!")
                builder.setMessage("NÃO É POSSIVEL DIVIDIR POR 0")
                val alert = builder.create()
                alert.show()
            }
            else {
                val div = num1 / num2
                val builder = AlertDialog.Builder(this)
                builder.setTitle("RESULTADO!!")
                builder.setMessage("A Divisão é: $div")
                val alert = builder.create()
                alert.show()
            }
            edtNum1.text.clear()
            edtNum2.text.clear()
        }

        btnMult.setOnClickListener {
            val num1 = edtNum1.text.toString().toInt()
            val num2 = edtNum2.text.toString().toInt()
            val mult = num1 * num2

            val builder = AlertDialog.Builder(this)
            builder.setTitle("RESULTADO!!")
            builder.setMessage("A Subtração é: $mult")
            val alert = builder.create()
            alert.show()
            edtNum1.text.clear()
            edtNum2.text.clear()
        }

        btnSoma.setOnClickListener {
            val num1 = edtNum1.text.toString().toInt()
            val num2 = edtNum2.text.toString().toInt()
            val soma = num1+num2

            val builder = AlertDialog.Builder(this)
            builder.setTitle("RESULTADO!!")
            builder.setMessage("A Soma é: $soma")
            val alert = builder.create()
            alert.show()
            edtNum1.text.clear()
            edtNum2.text.clear()
        }

    }
}