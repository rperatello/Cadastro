package br.edu.ifsp.scl.sdm.cadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class FormularioActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText fullNameEt;
    private EditText telEt;
    private EditText emailEt;
    private EditText cityEt;
    private CheckBox checkCb;
    private RadioButton radio1Rb;
    private RadioButton radio2Rb;
    private Spinner ufOptions;
    private Button limparBt;
    private Button salvarBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        fullNameEt = findViewById(R.id.fullNameEt);
        telEt = findViewById(R.id.telEt);
        emailEt = findViewById(R.id.emailEt);
        cityEt = findViewById(R.id.cityEt);
        checkCb = findViewById(R.id.checkCb);
        radio1Rb = findViewById(R.id.radio1Rb);
        radio2Rb = findViewById(R.id.radio2Rb);
        ufOptions = findViewById(R.id.ufOptions);
        ufOptions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(getApplicationContext(), ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}

        });
        limparBt = findViewById(R.id.limparBt);
        limparBt.setOnClickListener(this);
        salvarBt = findViewById(R.id.salvarBt);
        salvarBt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId() ){
            case R.id.salvarBt:
                StringBuilder sb = new StringBuilder();
                sb.append("Nome: "+ fullNameEt.getText().toString());
                sb.append('\n');
                sb.append("Tel.: "+ telEt.getText().toString());
                sb.append('\n');
                sb.append("E-mail: "+ emailEt.getText().toString());
                sb.append('\n');
                sb.append("Checkbox: "+ (checkCb.isChecked() ? "selecionado" : "não selecionado"));
                sb.append('\n');
                sb.append("Sexo: " + (radio1Rb.isChecked() ? "Masculino" : "Feminino"));
                sb.append('\n');
                sb.append("Cidade: " + cityEt.getText().toString());
                sb.append('\n');
                sb.append("UF: " + ((TextView) ufOptions.getSelectedView()).getText());
                sb.append('\n');
                Toast.makeText(this, sb.toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.limparBt:
                this.clearForm();
                break;
            default:
                break;
        }
    }

    protected void clearForm(){
        fullNameEt.setText("");
        telEt.setText("");
        emailEt.setText("");
        cityEt.setText("");
        checkCb.setChecked(false);
        radio1Rb.setChecked(true);
        radio2Rb.setChecked(false);
        ufOptions.setSelection(0);
    }
}