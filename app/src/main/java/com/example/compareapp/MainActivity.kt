package com.example.compareapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

import android.widget.Toast
import android.text.TextWatcher
import android.text.Editable

class MainActivity : AppCompatActivity() {
    // Crea una instancia del ViewModel
    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencias a los elementos de la interfaz de usuario
        val editText1 = findViewById<EditText>(R.id.editText1)
        val editText2 = findViewById<EditText>(R.id.editText2)
        val textView = findViewById<TextView>(R.id.textView)
        val button = findViewById<Button>(R.id.button)

        // Agrega TextWatcher a los EditText para actualizar las propiedades del ViewModel
        editText1.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                viewModel.text1.value = s?.toString()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        editText2.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                viewModel.text2.value = s?.toString()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })


        // Observa las propiedades del ViewModel para actualizar la interfaz de usuario
        viewModel.result.observe(this) { text ->
            if (text == "ERROR") {
                Toast.makeText(this, "Por favor, complete ambos campos", Toast.LENGTH_SHORT).show()
            } else {
                textView.text = text
            }
        }


        // Maneja el clic en el botón "Comparar"
        button.setOnClickListener {
            viewModel.onCompareClick()
        }
    }
}
