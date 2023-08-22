package jp.ac.it_college.std.s22025.fragmentsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import jp.ac.it_college.std.s22025.fragmentsample.databinding.FragmentMenuListBinding


//メニュー一覧を表示するためのフラグメント
class MenuListFragment : Fragment() {
    //Binding クラスのインスタンスを入れておくプロパティ(Nullable)
    private var _binding: FragmentMenuListBinding? = null

    //Activityのときと同じようにbindingを使うための工夫
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.menuList.apply {
            adapter = MenuAdapter(teishokuList)
            val manager = LinearLayoutManager(context)
            layoutManager = manager
            addItemDecoration(DividerItemDecoration(context, manager.orientation))
        }
    }
    override fun onDestroyView() {
        //viewの破棄
        super.onDestroyView()
        //どっからも参照してないとき？　ガベージコレクションのためにかいとく
        _binding = null
    }
}