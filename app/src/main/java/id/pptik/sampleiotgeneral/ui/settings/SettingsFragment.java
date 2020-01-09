package id.pptik.sampleiotgeneral.ui.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.textfield.TextInputEditText;

import id.pptik.sampleiotgeneral.R;

public class SettingsFragment extends Fragment {

    TextInputEditText etTopic;
    TextInputEditText etDeviceCode;
    Button saveSettings;

    SharedPreferences mSettings;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_settings, container, false);
        etTopic = (TextInputEditText)root.findViewById(R.id.topicName);
        etDeviceCode = (TextInputEditText)root.findViewById(R.id.deviceCode);
        saveSettings = (Button)root.findViewById(R.id.saveSettingsBtn);

        mSettings = container.getContext().getSharedPreferences("Settings", Context.MODE_PRIVATE);

        String getTopic = mSettings.getString("topic", null);
        String getDeviceCode = mSettings.getString("deviceCode", null);

        etTopic.setText(getTopic);
        etDeviceCode.setText(getDeviceCode);

        saveSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Save Settings
                String setTopic = etTopic.getText().toString();
                String setDeviceCode = etDeviceCode.getText().toString();

                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString("topic", setTopic);
                editor.putString("deviceCode", setDeviceCode);
                editor.apply();

                Toast.makeText(container.getContext(), "Simpan Data Sukses", Toast.LENGTH_LONG).show();
            }
        });

        return root;
    }
}