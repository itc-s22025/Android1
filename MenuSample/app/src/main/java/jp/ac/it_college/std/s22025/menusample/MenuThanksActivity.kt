package jp.ac.it_college.std.s22025.menusample

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import jp.ac.it_college.std.s22025.menusample.databinding.ActivityMenuThanksBinding


class MenuThanksActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuThanksBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuThanksBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //ToolbarをActionBarとして使う
        setSupportActionBar(binding.toolbar2)

        // 前の画面から渡ってくるであろうデータを取り出す
        val menuName = intent.getStringExtra("menuName") ?: ""
        val menuPrice = intent.getIntExtra("menuPrice", 0)

        // データセット
        binding.tvMenuName.text = menuName
        binding.tvMenuPrice.text = "%,d".format(menuPrice)

        // リストに戻るボタンをタップしたときの処理
        binding.btThxBack.setOnClickListener {
            //インテント生成するたびにその画面がフロントに生成されていく
            // ので、finish()で前に来た画面を終了させる(バックボダン押したときと同じ動きになる)
            finish()
        }

        //アクションバーの戻るボタン
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val result = when (item.itemId) {
            //android.R てやる　Rだけじゃだめ
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
        return result
    }
}