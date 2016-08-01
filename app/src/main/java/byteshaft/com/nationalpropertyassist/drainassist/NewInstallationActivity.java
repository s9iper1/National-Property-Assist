package byteshaft.com.nationalpropertyassist.drainassist;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import byteshaft.com.nationalpropertyassist.R;
import byteshaft.com.nationalpropertyassist.utils.ServicesTask;

public class NewInstallationActivity extends Activity implements RadioGroup.OnCheckedChangeListener{

    private Button button_submit;
    private RadioGroup radioGroup;
    private EditText details;
    private RadioButton radioButton;
    private String mRecoveryEmail;
    private String mRadioText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_installation_activity);
        mRecoveryEmail = getString(R.string.email_string);
        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        button_submit = (Button) findViewById(R.id.submit);
        details = (EditText) findViewById(R.id.new_installation_et);
        radioGroup.setOnCheckedChangeListener(this);

        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String description = details.getText().toString();
                new ServicesTask(NewInstallationActivity.this, description, mRadioText).execute();
            }
        });
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        radioButton = (RadioButton) findViewById(checkedId);
        mRadioText = radioButton.getText().toString();
        System.out.println(mRadioText);
    }
}
