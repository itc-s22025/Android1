package jp.ac.it_college.std.s22025.fragmentsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import jp.ac.it_college.std.s22025.fragmentsample.databinding.FragmentMenuThanksBinding

internal const val ARG_NAME = "menuName"
internal const val ARG_PRICE = "menuPrice"

/**
 * 注文完了を表示するためのフラグメント
 */
class MenuThanksFragment : Fragment() {
    // Bindingクラスのインスタンスを入れておくプロパティ(Nullable)
    private var _binding: FragmentMenuThanksBinding? = null

    // Bindingを non-null 型としてシンプルに使うための工夫
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuThanksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // arguments プロパティ経由で外部からパラメータを受け取る
        val menuName = arguments?.getString(ARG_NAME) ?: ""
        val menuPrice = arguments?.getInt(ARG_PRICE) ?: 0

        // ビューにパラメータをセットする。
        binding.tvMenuName.text = menuName
        binding.tvMenuPrice.text = "%,d".format(menuPrice)

        // ボタンのイベントリスナを設定
        binding.btThxBack.setOnClickListener(::onBackButtonClick)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /**
     * 戻るボタンが押されたときの処理。フラグメントの履歴を遡る処理。
     */
    private fun onBackButtonClick(v: View) {
        parentFragmentManager.popBackStack()
    }
}