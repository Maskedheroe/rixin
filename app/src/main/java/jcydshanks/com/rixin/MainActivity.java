package jcydshanks.com.rixin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import net.tsz.afinal.annotation.view.ViewInject;

public class MainActivity extends AppCompatActivity {

    @ViewInject(id = R.id.back,click = "Onclick")ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void OnClick(View view){
        switch (view.getId()){
            case R.id.back:
                onBackPressed();
                break;
        }
    }
}
