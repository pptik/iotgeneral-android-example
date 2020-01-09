package id.pptik.sampleiotgeneral.ui.control;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import id.pptik.sampleiotgeneral.Helpers.MQTTHelper;
import id.pptik.sampleiotgeneral.R;

public class ControlFragment extends Fragment {

    TextInputEditText etMessage;
    Button sendToRMQ;
    SharedPreferences mSettings;
    MQTTHelper rmq;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_control, container, false);

        rmq = new MQTTHelper(container.getContext());
        startMQTT();

        etMessage = (TextInputEditText)root.findViewById(R.id.message);

        mSettings = container.getContext().getSharedPreferences("Settings", Context.MODE_PRIVATE);
        String topic = mSettings.getString("topic", null);
        String deviceCode = mSettings.getString("deviceCode", null);

        if((topic == null) || (deviceCode == null)) {
            Toast.makeText(container.getContext(), "Mohon Setting Device Code dan Topic Terlebih Dahulu", Toast.LENGTH_LONG).show();
        }

        sendToRMQ = (Button)root.findViewById(R.id.sendToRMQ);
        sendToRMQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Reload
                String message = etMessage.getText().toString();
                rmq.publish(topic, message);
            }
        });

        return root;
    }

    private void startMQTT() {
        rmq.setCallback(new MqttCallbackExtended() {
            @Override
            public void connectComplete(boolean b, String s) {

            }

            @Override
            public void connectionLost(Throwable throwable) {

            }

            @Override
            public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
                Log.w("Debug",mqttMessage.toString());
            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

            }
        });
    }
}