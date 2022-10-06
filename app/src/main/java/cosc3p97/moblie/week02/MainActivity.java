package cosc3p97.moblie.week02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnA = findViewById(R.id.bntA);
        //btnA.setOnClickListener(new ButtonA());
        btnA.setOnClickListener(view -> {
            Toast.makeText(this, "Eh", Toast.LENGTH_SHORT).show();
        });

        findViewById(R.id.btnB).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Always be clicking", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("Counter", counter);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        counter = savedInstanceState.getInt("Counter",0);
        updateCounter();
    }

    private void updateCounter() {
        ((TextView)findViewById(R.id.CounterText)).setText(Integer.toString(counter));
    }

    public void bread(View view) {
        //Log.d("debugging",view.getId()+"");
        Toast.makeText(this, "CLeek", Toast.LENGTH_SHORT).show();
    }

    public void Counters(View btn) {
        switch (btn.getId()){
            case R.id.bntIncrement:
                counter++;
                break;
            case R.id.btnReset:
                counter = 0;
                break;
        }
        updateCounter();
    }

    private class ButtonA implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this,"Click, eh",Toast.LENGTH_SHORT).show();
        }
    }
}