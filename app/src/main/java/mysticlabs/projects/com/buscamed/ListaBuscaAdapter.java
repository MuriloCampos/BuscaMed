package mysticlabs.projects.com.buscamed;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import mysticlabs.projects.com.buscamed.Model.medico;

/**
 * Created by Guilherme on 15/01/2017.
 */

public class ListaBuscaAdapter extends RecyclerView.Adapter {

    public static class ViewListaHolder extends  RecyclerView.ViewHolder{
        TextView nome, especialidade, crm;
        View item_medico_busca;
        public ViewListaHolder(View _item_medico_busca){
            super(_item_medico_busca);
            nome = (TextView)_item_medico_busca.findViewById(R.id.nomeMedico);
            especialidade = (TextView)_item_medico_busca.findViewById(R.id.especialidade);
            crm = (TextView)_item_medico_busca.findViewById(R.id.crm);
        }
    }
    ArrayList<medico> lista;

    public ListaBuscaAdapter(ArrayList<medico> busca){
        lista = busca;
    }
    public ListaBuscaAdapter.ViewListaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item_medico = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_medico_busca,parent,false);
        ViewListaHolder vh = new ViewListaHolder(item_medico);
        return vh;
    }
    public void AtualizaLista(ArrayList<medico> novaLista, ViewGroup pai){
        lista.clear();
        lista = novaLista;
        onCreateViewHolder(pai,0);

    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ListaBuscaAdapter.ViewListaHolder novoHolder = new ListaBuscaAdapter.ViewListaHolder(holder.itemView);
        holder = novoHolder;
        onBindViewHolder(novoHolder,position);
    }


    public void onBindViewHolder(ListaBuscaAdapter.ViewListaHolder holder, int position) {
        holder.nome.setText(lista.get(position).getNome());
        holder.especialidade.setText(lista.get(position).getEspecialidade());
        holder.crm.setText(lista.get(position).getCrm());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
