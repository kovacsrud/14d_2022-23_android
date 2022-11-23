package com.raz.rnduserapi

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.raz.rnduserapi.databinding.FragmentListBinding
import retrofit2.Call
import retrofit2.Response


class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var adapter: UserDataAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_list,container,false)

        UserDataApi.retrofitService.getAdatok(25).enqueue(object:
        retrofit2.Callback<UserResults>{
            override fun onResponse(call: Call<UserResults>, response: Response<UserResults>) {
                val valasz=response.body()
                layoutManager= LinearLayoutManager(requireContext())
                val navController=this@ListFragment.findNavController()
                adapter=UserDataAdapter(requireContext(),valasz!!){
                    itemDto:UserData,position->
                    navController.navigate(ListFragmentDirections.actionListFragmentToDetailFragment(itemDto))
                }
                binding.lista.layoutManager=layoutManager
                binding.lista.adapter=adapter
            }

            override fun onFailure(call: Call<UserResults>, t: Throwable) {
                Log.e("Hiba","Api hiba:${t.message}")
            }

        }

        )



        return binding.root
    }


}