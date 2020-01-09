package id.pptik.sampleiotgeneral.ui.monitoring;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
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
import com.google.gson.Gson;

import id.pptik.sampleiotgeneral.Models.General;
import id.pptik.sampleiotgeneral.Networks.RestServiceClass;
import id.pptik.sampleiotgeneral.Networks.RestServiceInterface;
import id.pptik.sampleiotgeneral.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MonitoringFragment extends Fragment {

    EditText etData;
    Button reloadBtn;
    SharedPreferences mSettings;
    private RestServiceInterface restServiceInterface;

    String topic;
    String deviceCode;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_monitoring, container, false);
        etData = (EditText)root.findViewById(R.id.dataContainer);
        reloadBtn = (Button)root.findViewById(R.id.reloadBtn);

        mSettings = container.getContext().getSharedPreferences("Settings", Context.MODE_PRIVATE);

        topic = mSettings.getString("topic", null);
        deviceCode = mSettings.getString("deviceCode", null);

        if((topic == null) || (deviceCode == null)) {
            Toast.makeText(container.getContext(), "Mohon Setting Device Code dan Topic Terlebih Dahulu", Toast.LENGTH_LONG).show();
        }

        restServiceInterface = RestServiceClass.getClient().create(RestServiceInterface.class);

        reloadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //Reload
            Call<General> call = restServiceInterface.getGeneral(deviceCode);
            call.enqueue(new Callback<General>() {

                @Override
                public void onResponse(Call<General> call, Response<General> response) {
                    General result = response.body();
                    if (result != null) {
                        etData.setText(new Gson().toJson(result.getData()));
                    }
                }

                @Override
                public void onFailure(Call<General> call, Throwable t) {
                    Toast.makeText(container.getContext(), "Error Jaringan", Toast.LENGTH_LONG).show();
                    call.cancel();
                }
            });
            }
        });

        return root;
    }
}