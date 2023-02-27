package com.example.myapplication.loginapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.replace
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentSignupBinding

class SignUpFragment : Fragment(R.layout.fragment_signup) {
    lateinit var binding:FragmentSignupBinding
    private val mainViewModel: MainViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_signup,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSign.setOnClickListener {
            if (binding.edtUser.text.isNotEmpty() && binding.edtPass.text.isNotEmpty()){
                mainViewModel.updateUserPass(binding.edtUser.text.toString(),binding.edtPass.text.toString())
                parentFragmentManager.beginTransaction().setReorderingAllowed(true)
                    .replace<LoginFragment>(R.id.container)
                    .commit()
            }else {
                Toast.makeText(activity,"User an pass no empty!",Toast.LENGTH_SHORT).show()
            }
        }
        mainViewModel.userLiveData.observe(viewLifecycleOwner){
            binding.edtUser.setText(it)
        }
        mainViewModel.passLiveData.observe(viewLifecycleOwner){
            binding.edtPass.setText(it)
        }
    }

}

