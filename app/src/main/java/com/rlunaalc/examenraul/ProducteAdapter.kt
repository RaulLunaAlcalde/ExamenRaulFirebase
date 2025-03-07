import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rlunaalc.examenraul.R
import com.rlunaalc.examenraul.dataBase.Producte

class ProducteAdapter(private val productesList: List<Producte>) : RecyclerView.Adapter<ProducteAdapter.ProducteViewHolder>() {

    class ProducteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.ProducteNom)
        val priceTextView: TextView = itemView.findViewById(R.id.ProductePreu)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProducteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.producte_cardview, parent, false)
        return ProducteViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProducteViewHolder, position: Int) {
        val producte = productesList[position]
        holder.nameTextView.text = producte.nom
        holder.priceTextView.text = "€${producte.preu}"
    }

    override fun getItemCount(): Int = productesList.size
}