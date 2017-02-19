package mysticlabs.projects.com.buscamed;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import mysticlabs.projects.com.buscamed.Model.medico;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference firebaseReferencia = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference medicoReferencia = firebaseReferencia.child("medicos");
    private medico md;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> convenios = new ArrayList<String>();
        convenios.add("UNIMED");
        convenios.add("PACS");
        convenios.add("BRADESCO");

        //md = new medico("Matador de Onça", "000000", "Amazonia", "matamesmo@onca.com","6533332222","tiaomatador","06:00 - 18:00", convenios, "cardiologista");

        //medicoReferencia.child("002").setValue(md);

        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "mysticlabs.projects.com.buscamed",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
    }
}
