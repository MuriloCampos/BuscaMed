package mysticlabs.projects.com.buscamed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import mysticlabs.projects.com.buscamed.Model.medico;

public class Busca extends AppCompatActivity {
    RecyclerView lista;
    EditText texto;
    private DatabaseReference firebaseReferencia = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference medicoReferencia = firebaseReferencia.child("medicos");
    private ArrayList<medico> listaMedicos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_busca);

        listaMedicos = new ArrayList<medico>();


        medicoReferencia.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot medicosSnapchot : dataSnapshot.getChildren()){
                    medico med = medicosSnapchot.getValue(medico.class);
                    listaMedicos.add(med);
                    //Log.i("FIREBASE", medicosSnapchot.getValue().toString());
                }
                //geraListaTeste(listaMedicos);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        configuraRecycleView();

    }

    private void configuraRecycleView() {
        lista = (RecyclerView) findViewById(R.id.listaBusca);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        lista.setLayoutManager(mLayoutManager);

        lista.setAdapter(new ListaBuscaAdapter(listaMedicos));
    }

    public void atualizaListaDeBusca(ArrayList<medico> novaListaMedico){
        lista.setAdapter(new ListaBuscaAdapter(novaListaMedico));

    }

    //TEste
    private void geraListaTeste(ArrayList<medico> list){
        medico aux ;
        int j = 3;
        for (int i = 0; i < 6; i++){
            aux = new medico();
            aux.setNome("Nome medico "+i);
            aux.setEspecialidade("Especialidade #"+i);
            aux.setCrm("CRM 00"+i);
            list.add(aux);
            medicoReferencia.child(Integer.toString(j)).setValue(aux);
            j++;
        }
    }
}
