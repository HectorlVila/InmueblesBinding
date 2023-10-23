package hector.lagunas.inmueblesbinding;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;


import hector.lagunas.inmueblesbinding.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private ActivityResultLauncher<Intent> launcherAddInmueble;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        inicializarLauncher();

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launcherAddInmueble.launch(new Intent(MainActivity.this, AddInmuebleActivity.class));
            }
        });
    }

    private void inicializarLauncher() {
        launcherAddInmueble = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult o) {
                        //RESULTADO DE VOLVER DE LA ACTIVIDAD ADD INMUEBLE
                    }
                }
        );
    }
}