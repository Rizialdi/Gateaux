package ga.drasselio.gateaux;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int nbr_gateau_int;
    int prx_commercant_int;
    EditText nbr_gateau;
    EditText prx_commercant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calc = (Button) findViewById(R.id.btn_calc);
        Button reset = (Button) findViewById(R.id.btn_reset);
        calc.setOnClickListener(this);
        reset.setOnClickListener(this);

        nbr_gateau = (EditText) findViewById(R.id.nbr_gateau);

        prx_commercant = (EditText) findViewById(R.id.prx_commercant);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.btn_calc:
                if(nbr_gateau.getText().toString().matches("") || prx_commercant.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this, " Veuillez remplir tous les champs ", Toast.LENGTH_LONG).show();

                }
                else {
                    nbr_gateau_int = Integer.parseInt(nbr_gateau.getText().toString());
                    prx_commercant_int = Integer.parseInt(prx_commercant.getText().toString());
                    Intent intent = new Intent(this, Details.class);
                    intent.putExtra("nbr_cake", nbr_gateau_int);
                    intent.putExtra("gagne_commercant", (nbr_gateau_int * prx_commercant_int));
                    intent.putExtra("gagne_moi", nbr_gateau_int * (100 - prx_commercant_int));
                    startActivity(intent);
                }
            case R.id.btn_reset:
                nbr_gateau.setText(null);
                prx_commercant.setText(null);
        }
    }
}
