package ga.drasselio.gateaux;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        if(getIntent().getExtras() != null){

            Intent intent = getIntent();

            try{
                ((TextView) findViewById(R.id.title_text_intro)).setText("Sur les " + intent.getExtras().getInt("nbr_cake") + " gateaux :");

                ((TextView) findViewById(R.id.title_text_moi)).setText("- Le Commercant prend " + intent.getExtras().getInt("gagne_commercant")+ " F cfa");

                ((TextView) findViewById(R.id.title_text_commercant)).setText("- Vous prenez " + intent.getExtras().getInt("gagne_moi")+ " F cfa");
            }catch (NullPointerException e){
                e.printStackTrace();
            }
        }

    }
}
