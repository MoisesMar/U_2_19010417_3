package net.n_19010417.sensores;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {

    private List <Sensor> listadoDeSensores;
    private List <String> nombreDeLosSensores;

    private String sensores[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SensorManager sensorManager = (SensorManager)
                getSystemService(SENSOR_SERVICE);

        listadoDeSensores = sensorManager.getSensorList(Sensor.TYPE_ALL);

        nombreDeLosSensores = new ArrayList<String>();

        for (Sensor sensor: listadoDeSensores){
            nombreDeLosSensores.add(sensor.getName());
        }

        sensores = nombreDeLosSensores.toArray(
                new String[nombreDeLosSensores.size()]
        );

        setListAdapter(new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, sensores
        ));

    }
}