package br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus.usuario.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus.R
import br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus.usuario.data.UsuarioEntity

class UsuarioAdapter(private val usuarios: List<UsuarioEntity>, private val onItemClick: (UsuarioEntity) -> Unit) :

    RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder>() {

    class UsuarioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nomeTv: TextView = itemView.findViewById(R.id.nomeTv)
        val idadeTv: TextView = itemView.findViewById(R.id.idadeTv)
        val sexoTv: TextView = itemView.findViewById(R.id.sexoTv)
        val alturaTv: TextView = itemView.findViewById(R.id.alturaTv)
        val pesoTv: TextView = itemView.findViewById(R.id.pesoTv)
        val atividadeTv: TextView = itemView.findViewById(R.id.atividadeTv)
        val imcTv: TextView = itemView.findViewById(R.id.imcTv)
        val categoriaTv: TextView = itemView.findViewById(R.id.categoriaTv)
        val tmbTv: TextView = itemView.findViewById(R.id.tmbTv)
        val pesoIdealTv: TextView = itemView.findViewById(R.id.pesoIdealTv)
        val editarBt: Button = itemView.findViewById(R.id.editar_bt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.historico_usuario_dados, parent, false)
        return UsuarioViewHolder(view)
    }

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        val usuario = usuarios[position]

        holder.nomeTv.text = "Nome: ${usuario.nome}"
        holder.idadeTv.text = "Idade: ${usuario.idade}"
        holder.sexoTv.text = "Sexo: ${usuario.sexo}"
        holder.alturaTv.text = "Altura: ${usuario.altura} m"
        holder.pesoTv.text = "Peso: ${usuario.peso} kg"
        holder.atividadeTv.text = "Atividade: ${usuario.atividade}"
        holder.imcTv.text = "IMC: %.2f".format(usuario.imc)
        holder.categoriaTv.text = "Categoria IMC: ${usuario.categoriaImc}"
        holder.tmbTv.text = "TMB: %.2f kcal".format(usuario.tmb)
        holder.pesoIdealTv.text = "Peso Ideal: %.1f kg".format(usuario.pesoIdeal)


        holder.editarBt.setOnClickListener {
            onItemClick(usuario)
        }
    }

    override fun getItemCount() = usuarios.size
}
