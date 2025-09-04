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
        val edtNum1 = findViewById<EditText>(R.id.edt_num1) // Tensão
        val edtNum2 = findViewById<EditText>(R.id.edt_num2) // Corrente
        val edtNum3 = findViewById<EditText>(R.id.edt_num3) // Resistência
        val btnCalcular = findViewById<Button>(R.id.btn_calcular)
        val btnLimpar = findViewById<Button>(R.id.btn_limpar)

        btnCalcular.setOnClickListener {
            val tensao = edtNum1.text.toString().toDoubleOrNull()
            val corrente = edtNum2.text.toString().toDoubleOrNull()
            val resistencia = edtNum3.text.toString().toDoubleOrNull()

            // I = V / R
            if (tensao != null && resistencia != null && corrente == null && resistencia != 0.0) {
                edtNum2.setText("%.2f".format(tensao / resistencia))
            }
            // R = V / I
            else if (tensao != null && corrente != null && resistencia == null && corrente != 0.0) {
                edtNum3.setText("%.2f".format(tensao / corrente))
            }
            // V = R * I
            else if (resistencia != null && corrente != null && tensao == null) {
                edtNum1.setText("%.2f".format(resistencia * corrente))
            }
            btnLimpar.setOnClickListener {
                edtNum1.text.clear()
                edtNum2.text.clear()
                edtNum3.text.clear()
            }
        }

    }
}