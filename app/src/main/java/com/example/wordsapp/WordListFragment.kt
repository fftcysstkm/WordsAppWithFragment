package com.example.wordsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wordsapp.databinding.FragmentWordListBinding

/**
 * 選択したアルファベットから始まる単語リストを表示するフラグメント
 */
class WordListFragment : Fragment() {

    companion object {
        const val LETTER = "letter"
        const val SEARCH_PREFIX = "https://www.google.com/search?q="
    }

    // バインディングクラスをnullで初期化（onCreateView()にて実体が作成される）
    private var _binding: FragmentWordListBinding? = null

    // onCreateView()後にインスタンス化された_bindingにより値に設定（get-only）
    private val binding get() = _binding!!

    private lateinit var letterId: String

    /**
     * ①フラグメント生成時最初に呼ばれるメソッド（アクティビティと異なりインフレートはここではしない）
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            letterId = it.getString(LETTER).toString()
        }
    }

    /**
     * ②ここでレイアウトがインフレートされる
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWordListBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    /**
     * ③リサイクラービューにレイアウトマネージャー、アダプター等を設定する
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter =
            WordAdapter(letterId, requireContext())

        // 区切り線
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
            )
        )
    }

    /**
     * フラグメント終了時
     */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}