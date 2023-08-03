package jp.ac.it_college.std.s22025.intentsample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import jp.ac.it_college.std.s22025.intentsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lvMenu.apply {
            // アダプタとデータをセット
            adapter = MenuListAdapter(menuList){name, price ->
                // アイテムを選択されたときの処理はここに書くことができる。
                // インテントオブジェクトの作成
                val intent2MenuThanks = Intent(this@MainActivity, MenuThanksActivity::class.java)
                // 次の画面に送るデータをセットする
                intent2MenuThanks.putExtra("menuName", name)
                intent2MenuThanks.putExtra("menuPrice", price)
                // 次の画面を起動
                startActivity(intent2MenuThanks)
            }

            // RecyclerViewの表示方法を直線的にする
            LinearLayoutManager(this@MainActivity).let {
                layoutManager = it
                // 区切り線を並べる方向に合わせて表示する
                addItemDecoration(DividerItemDecoration(this@MainActivity, it.orientation))
            }
        }


    }
}