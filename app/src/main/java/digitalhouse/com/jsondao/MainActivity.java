package digitalhouse.com.jsondao;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AssetManager assetManager = getAssets();
        try {
                InputStream  newJson = assetManager.open("noticias.json");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(newJson));
                Gson gson = new Gson();

                NoticiasResposta resposta = gson.fromJson(bufferedReader,NoticiasResposta.class);
            Log.i("TAG","onCreate: " + resposta.getNoticias().get(0).getTitle());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
