package com.example.myapplication.loginapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.*
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentLoginBinding
import com.google.android.material.snackbar.Snackbar
import kotlin.concurrent.fixedRateTimer

class LoginFragment : Fragment(R.layout.fragment_login) {
    private lateinit var binding:FragmentLoginBinding
    private val mainViewModel:MainViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false)
       return binding.root
    }

    @SuppressLint("CommitTransaction")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btinSignup.setOnClickListener {

            parentFragmentManager.beginTransaction().setReorderingAllowed(true)
                .replace<SignUpFragment>(R.id.container)
                .addToBackStack(null)
                .commit()

        }
        binding.btnLogin.setOnClickListener {
            if (binding.edtUsername.text.toString()==mainViewModel.userLiveData.value &&
                    binding.edtPassword.text.toString()==mainViewModel.passLiveData.value){
                Snackbar.make(view,"login successfully!!!",Snackbar.LENGTH_SHORT).show()
            }else{
                Toast.makeText(activity,"no match!!!",Toast.LENGTH_SHORT).show()
            }
        }
        mainViewModel.passLiveData.observe(viewLifecycleOwner){
            binding.edtPassword.setText(it)
        }
        mainViewModel.userLiveData.observe(viewLifecycleOwner){
            binding.edtUsername.setText(it)
        }
    }
}