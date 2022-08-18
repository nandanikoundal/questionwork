package com.nandani.question_work

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.nandani.question_work.databinding.FragmentPlayQuizBinding


// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PlayQuizFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PlayQuizFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    var arrayList: ArrayList<QuizQuestions> = ArrayList()
    var currentIndex = 0
    lateinit var binding: FragmentPlayQuizBinding
    lateinit var adapter : QuestionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPlayQuizBinding.inflate(layoutInflater)
        var optionsArray: ArrayList<QuizQOptions> = ArrayList()

        adapter = QuestionAdapter(optionsArray)
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = GridLayoutManager(requireActivity(),2)
        optionsArray.add(QuizQOptions("1"))
        arrayList.add(QuizQuestions(1, "Question",optionsArray,1))
        setQuizQuestion()

        binding.btnConfirm.setOnClickListener{
//            if (binding.recyclerview.checkedrecyclerviewId == -1){
//                return@setOnClickListener
//            }
//
//            if()

        }
        return binding.root
    }

    private fun setQuizQuestion() {
        binding.tvQPart1.setText(arrayList[currentIndex].question)


    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PlayQuizFragment.
         */

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PlayQuizFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}