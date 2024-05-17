package com.example.lab2.view

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.lab2.R
import com.example.lab2.databinding.StudentDialogBinding
import com.example.lab2.model.Student
import com.example.lab2.viewmodel.StudentViewModel

class StudentDialogFragment:DialogFragment() {
    private lateinit var binding: StudentDialogBinding
    private lateinit var student:Student
    private val studentViewModel: StudentViewModel by lazy {
        ViewModelProvider(this).get(StudentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= StudentDialogBinding.inflate(inflater,container,false)
        binding.btOk.setOnClickListener {
            student= Student()
            student.name=binding.etFIO.text.toString()
            student.group=binding.etGroup.text.toString()
            student.phis=binding.etMarkPhis.text.toString().toInt()
            student.his=binding.etMarkHis.text.toString().toInt()
            student.inf=binding.etMarkInfo.text.toString().toInt()
            studentViewModel.saveStudent(student)
            dismiss()
        }
        return binding.root
    }
}