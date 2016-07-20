package adithya.scarnesdice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.test.suitebuilder.annotation.MediumTest;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button b_roll;
    Button b_hold;
    Button b_reset;
    Button b_exit;
    ImageView iv_dice;
    TextView tv_p1s;
    TextView tv_p2s;

    Random r;
    int rolledNumber;
    int UOS=0;
    //int COS=0;
    int TS=0;
    boolean nextTurn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_roll= (Button) findViewById(R.id.b_roll);
        b_hold= (Button) findViewById(R.id.b_hold);
        b_reset= (Button) findViewById(R.id.b_reset);
        b_exit= (Button) findViewById(R.id.b_exit);
        iv_dice= (ImageView) findViewById(R.id.iv_dice);
        tv_p1s= (TextView)findViewById(R.id.tv_p1s);
        tv_p2s= (TextView)findViewById(R.id.tv_p2s);

        r = new Random();

        b_roll.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                TS=0;
                //nextTurn=true;
                //while(nextTurn!=false )
                //{
                    rolledNumber=r.nextInt(6) +1;

                    if (rolledNumber == 1) {
                        iv_dice.setImageResource(R.drawable.dice1);
                        TS = 0;
                        nextTurn = false;
                    } else if (rolledNumber == 2) {
                        iv_dice.setImageResource(R.drawable.dice2);
                        TS += 2;
                        nextTurn = true;
                    } else if (rolledNumber == 3) {
                        iv_dice.setImageResource(R.drawable.dice3);
                        TS += 3;
                        nextTurn = true;
                    } else if (rolledNumber == 4) {
                        iv_dice.setImageResource(R.drawable.dice4);
                        TS += 4;
                        nextTurn = true;
                    } else if (rolledNumber == 5) {
                        iv_dice.setImageResource(R.drawable.dice5);
                        TS += 5;
                        nextTurn = true;
                    } else if (rolledNumber == 6) {
                        iv_dice.setImageResource(R.drawable.dice6);
                        TS += 6;
                        nextTurn = true;
                    }

                //}
                UOS += TS;
                if (UOS>=100){
                    Toast.makeText(MainActivity.this, "Player1 has won!", Toast.LENGTH_SHORT).show();

                }

                Toast.makeText(MainActivity.this, "ROLLED", Toast.LENGTH_SHORT).show();
                tv_p1s.setText("Player1 Score : "+UOS);
            }
        });
        b_exit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V) {
                System.exit(0);
            }
        });
        b_reset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V) {
                UOS=0;
                tv_p1s.setText("Player1 Score : "+UOS);
                //COS=0;
            }
        });

    }
}
