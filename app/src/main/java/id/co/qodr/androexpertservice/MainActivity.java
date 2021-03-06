package id.co.qodr.androexpertservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnStartService;
    private Button btnStartIntentService;

    // TODO: Buat inisialisasi button dan action click
    // TODO: Buat class Service dengan nama "OriginService" check exported dan enabled
    // TODO: Edit AndroidManifest daftarkan Service yg dibuat tadi
    // TODO: tambahkan method onStartCommand(Intent intent, int flags, int startId) return START_STICKY
    // TODO: Jalankan service dengan Intent di action btn_start_service

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStartService = (Button) findViewById(R.id.btn_start_service);
        btnStartService.setOnClickListener(this);
        btnStartIntentService = (Button) findViewById(R.id.btn_start_intent_service);
        btnStartIntentService.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_start_service:
                Intent mStartServiceIntent = new Intent(MainActivity.this, OriginService.class);
                startService(mStartServiceIntent);
                break;
            case R.id.btn_start_intent_service:
                Intent mStartIntentService = new Intent(MainActivity.this, DicodingIntentService.class);
                mStartIntentService.putExtra(DicodingIntentService.EXTRA_DURATION, 5000);
                startService(mStartIntentService);
                break;
        }
    }
}
