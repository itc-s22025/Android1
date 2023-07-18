package jp.ac.it_college.std.s22025.hellosample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import jp.ac.it_college.std.s22025.hellosample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Bindingクラスのインスタンスを生成してもらう
        binding = ActivityMainBinding.inflate(layoutInflater)
        //Bindingクラスが管理しているビューを使う
//        setContentView(R.layout.activity_main)
        setContentView(binding.root)

        //ボタンを取ってくる
//        val btClick = findViewById<Button>(R.id.btClick)

        //リスナクラスのインスタンスを作る
        val listener = HelloListener()

//        btClick.setOnClickListener(listener)
        //binding経由でボタンにリスナを設定する
        binding.btClick.setOnClickListener(listener)
    }

    private inner class HelloListener: View.OnClickListener{
        override fun onClick(v: View?) {
            //名前が入力されるであろうEditTextをとってくる
//            val input = findViewById<EditText>(R.id.etName)
            val input = binding.etName

            //メッセージを出力する先のTextViewをとってくる
//            val output = findViewById<TextView>(R.id.tvOutput)
            val output = binding.tvOutput

            //input(EditText)から入力を取り出してString型へ
//            val inputStr= input.text.toString()
            val inputStr = binding.etName.text.toString()

            //メッセージを出す
//            output.text = "${inputStr}さん、こんにちは！"
            binding.tvOutput.text = "${inputStr}さん、こんにちは(^_^)/~~"
        }

    }
}