package jp.ac.it_college.std.s22025.menusample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import jp.ac.it_college.std.s22025.menusample.databinding.MenuRowBinding


class MenuListAdapter(
    private val data: List<Menu>,
    //callback ... そのときがきたら呼び出す関数
    private val callback: (String, Int) -> Unit) :
    RecyclerView.Adapter<MenuListAdapter.ViewHolder>() {

    class ViewHolder(val binding: MenuRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            MenuRowBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val menu = data[position]
        holder.binding.apply {
            tvName.text = menu.name
            tvPrice.text = menu.price.toString()
            //root(全体の画面)のsetOnClickListener(クリックしたときの動作)↓
            root.setOnClickListener{
                //このAdapterを使う側に、選択された定食名と価格をパラメータとしてコールバック
                callback(menu.name, menu.price)
            }
        }
    }

}