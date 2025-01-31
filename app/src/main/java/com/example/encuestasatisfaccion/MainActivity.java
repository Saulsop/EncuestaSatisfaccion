package com.example.encuestasatisfaccion;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Declarar las vistas
    EditText txtNombre;
    SeekBar seekSatisfaccion;
    EditText txtComentarios;
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializar las vistas
        txtNombre = findViewById(R.id.txtNombre);
        seekSatisfaccion = findViewById(R.id.seekSatisfaccion);
        txtComentarios = findViewById(R.id.txtComentarios);
        btnEnviar = findViewById(R.id.btnEnviar);

        // Configurar el clic del botón "Enviar"
        btnEnviar.setOnClickListener(v-> {

                // Obtener los valores ingresados por el usuario
                String nombre = txtNombre.getText().toString();
                int satisfaccion = seekSatisfaccion.getProgress();
                String comentarios = txtComentarios.getText().toString();

                // Mostrar un Toast con la información
                String mensaje = "Nombre: " + nombre + "\nNivel de satisfacción: " + satisfaccion;
                Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_LONG).show();

        });
    }
}