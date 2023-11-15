package com.example.wakeupalready;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.button.MaterialButton;

public class SignUp extends AppCompatActivity {
    private EditText et1, et2, et3, et4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        et3=(EditText)findViewById(R.id.et3);
        et4=(EditText)findViewById(R.id.et4);
    }

    public void insertar(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);

        SQLiteDatabase bd = admin.getWritableDatabase();
        String user = et1.getText().toString();
        String mail = et2.getText().toString();
        String pass = et3.getText().toString();
        String repass = et4.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("username", user);
        registro.put("email", mail);
        registro.put("password", pass);
        registro.put("confirm_pass", repass);
        bd.insert("usuarios", null, registro);
        bd.close();
        et1.setText("");
        et2.setText("");
        et3.setText("");
        et4.setText("");
        Toast.makeText(this,"se cargaron tus datos a la base de datos", Toast.LENGTH_SHORT).show();
    }
}