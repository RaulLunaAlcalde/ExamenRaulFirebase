import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.rlunaalc.examenraul.R
import com.rlunaalc.examenraul.dataBase.Producte
import com.rlunaalc.examenraul.llistar.LlistarFragmentDirections


class ProducteAdapter(private val productesList: List<Producte>) : RecyclerView.Adapter<ProducteAdapter.ProducteViewHolder>() {

    class ProducteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.ProducteNom)
        val priceTextView: TextView = itemView.findViewById(R.id.ProductePreu)
        val layoutCardView = itemView.findViewById<View>(R.id.layoutCardView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProducteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.producte_cardview, parent, false)
        return ProducteViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProducteViewHolder, position: Int) {
        val producte = productesList[position]
        holder.nameTextView.text = producte.nom
        holder.priceTextView.text = producte.preu.toString()

        holder.layoutCardView.setOnClickListener { view ->
            val action = LlistarFragmentDirections.actionLlistarFragmentToModificarFragment(producte.id.toString())
            view.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int = productesList.size
}