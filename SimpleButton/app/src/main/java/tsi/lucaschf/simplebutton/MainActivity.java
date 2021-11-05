package tsi.lucaschf.simplebutton;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();
    }

    private void initComponent() {
        Button mainButton = findViewById(R.id.btn_create);
        Button secondaryButton = createSecondaryButton();

        mainButton.setOnClickListener(btn -> secondaryButton.setVisibility(View.VISIBLE));
        setUpSecondaryButton(secondaryButton);
    }

    private @NotNull Button createSecondaryButton() {
        Button btn = new Button(this);
        btn.setText(R.string.click_or_hold_me);

        btn.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

        return btn;
    }

    private void setUpSecondaryButton(Button secondaryButton) {
        ((LinearLayout) findViewById(R.id.parent)).addView(secondaryButton);
        secondaryButton.setVisibility(View.GONE);

        secondaryButton.setOnClickListener(btn -> btn.setVisibility(View.GONE));
        secondaryButton.setOnLongClickListener(btn -> {
            showDayOfTheWeek();
            return true;
        });
    }

    private void showDayOfTheWeek() {
        Toast.makeText(MainActivity.this,
                LocalDate.now().getDayOfWeek().name(),
                Toast.LENGTH_SHORT).show();
    }
}