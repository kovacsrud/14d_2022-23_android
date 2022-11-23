package com.raz.rnduserapi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.raz.rnduserapi.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_detail,container,false)
        val aktUser=DetailFragmentArgs.fromBundle(requireArguments()).aktdata
        binding.aktuser=aktUser
        Glide.with(requireContext()).load(aktUser.picture.large).into(binding.detailPicture)

        return binding.root
    }


}