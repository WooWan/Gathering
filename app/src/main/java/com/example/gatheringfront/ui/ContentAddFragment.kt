package com.example.gatheringfront.ui

import android.R
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.gatheringfront.databinding.FragmentContentAddBinding
import com.google.android.material.chip.Chip

class ContentAddFragment : Fragment() {
    var mContext: Context? = null
    private var _binding: FragmentContentAddBinding? = null
    private val binding get() = _binding!!
    private val initialValue:String = "언어를 선택해주세요"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentContentAddBinding.inflate(inflater, container, false)
        val view = binding.root
        setInfo()
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }
    private fun setInfo() {
        setStudyInfo()
        setSkillInfo()
    }

    private fun setStudyInfo() {
        val studyList = listOf("오프라인", "온라인")
        val studyAdapter =
            ArrayAdapter<String>(requireContext(), R.layout.simple_list_item_1, studyList)
        binding.studyWaySpinner.adapter = studyAdapter

        binding.studyWaySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Log.d("itm", "parent: $parent, view: $view, position: $position, id: $id")
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Log.d("itm", "nothing is selected")
            }
        }
    }
    private fun setSkillInfo() {
        val skillList = listOf(initialValue, "Python", "Java", "Node", "Spring", "Django", "Vue.js", "Angular.js", "Javascript", "React")
        val skillAdapter =
            ArrayAdapter<String>(requireContext(), R.layout.simple_list_item_1, skillList)
        binding.studySkillSpinner.adapter = skillAdapter

        binding.studySkillSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                addChip(skillList, position)
                Log.d("itm", "parent: $parent, view: $view, position: $position, id: $id")
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Log.d("itm", "nothing is selected")
            }
        }
    }

    private fun addChip(skillList: List<String>, position: Int) {
        if(position == 0) {
            return
        }
        val mChip = Chip(requireContext())
        mChip.text = skillList[position]
        mChip.setTextColor(ContextCompat.getColor(requireContext(),R.color.background_dark))
        mChip.chipBackgroundColor = ContextCompat.getColorStateList(requireContext(),R.color.holo_blue_bright)
        mChip.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.holo_green_light))
        binding.chipGroup.addView(mChip)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}