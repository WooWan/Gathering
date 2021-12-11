package com.example.gatheringfront.ui

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.content.ContextCompat
import com.example.gatheringfront.databinding.ActivityContentAddBinding
import com.example.gatheringfront.dto.ContentDto
import com.google.android.material.chip.Chip
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class ContentAddActivity : AppCompatActivity() {

    private val initialValue:String = "언어를 선택해주세요"
    private var auth: FirebaseAuth? = null
    private var firestore: FirebaseFirestore?= null
    private val binding by lazy { ActivityContentAddBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setButton()
        setInfo()
    }

    private fun setInfo() {
        auth = FirebaseAuth.getInstance()
        firestore = FirebaseFirestore.getInstance()
        setStudyInfo()
        setSkillInfo()
    }
    private fun setButton() {
        binding.addContentBtn.setOnClickListener{
            contentUpload()
        }
    }

    private fun contentUpload() {
        val contentDto= ContentDto()
        contentDto.title = binding.contentTitle.text.toString()
        contentDto.description = binding.contentDescription.text.toString()
//        contentDto.skillList = binding.chipGroup
        contentDto.timeStamp = System.currentTimeMillis()
        contentDto.status = binding.studyStatusSpinner.selectedItem.toString()
        contentDto.uId = auth?.currentUser?.uid
        contentDto.userId = auth?.currentUser?.email
        firestore
            ?.collection("info")
            ?.document()
            ?.set(contentDto)
            ?.addOnSuccessListener {
                finish()
            }
    }



    private fun setStudyInfo() {
        val studyList = listOf("오프라인", "온라인")
        val studyAdapter =
            ArrayAdapter<String>(this, R.layout.simple_list_item_1, studyList)
        binding.studyStatusSpinner.adapter = studyAdapter

        binding.studyStatusSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Log.d("itm", "nothing is selected")
            }
        }
    }
    private fun setSkillInfo() {
        val skillList = listOf(initialValue, "Python", "Java", "Node", "Spring", "Django", "Vue.js", "Angular.js", "Javascript", "React")
        val skillAdapter =
            ArrayAdapter<String>(this, R.layout.simple_list_item_1, skillList)
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
        val mChip = Chip(this)
        mChip.text = skillList[position]
        mChip.setTextColor(ContextCompat.getColor(this, R.color.background_dark))
        mChip.chipBackgroundColor = ContextCompat.getColorStateList(this, R.color.holo_blue_bright)
        mChip.setBackgroundColor(ContextCompat.getColor(this, R.color.holo_green_light))
        binding.chipGroup.addView(mChip)
    }
}