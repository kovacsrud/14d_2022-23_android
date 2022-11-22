package com.raz.recyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.raz.recyclerview.databinding.FragmentListaBinding


class ListaFragment : Fragment() {
    private lateinit var binding: FragmentListaBinding
    private  lateinit var adapter:PersonAdapter
    private  lateinit var layoutManager:LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var adatok= listOf(
            Person("Kiss","Elek",1999),
            Person("Kiss","Endre",1998),
            Person("Kiss","Ubul",1997),
            Person("Kiss","Elek",1999),
            Person("Kiss","Endre",1998),
            Person("Kiss","Ubul",1997),
            Person("Kiss","Elek",1999),
            Person("Kiss","Endre",1998),
            Person("Kiss","Ubul",1997),
            Person("Kiss","Elek",1999),
            Person("Kiss","Endre",1998),
            Person("Kiss","Ubul",1997)

        )

        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_lista,container,false)
        val navController=this.findNavController()
        adapter= PersonAdapter(requireContext(),adatok){
            itemDto:Person,position:Int->
            //utasítások, amit kattintáskor végrehajtódnak
            navController.navigate(ListaFragmentDirections.actionListaFragmentToDetailFragment2(itemDto))
        }


        layoutManager=LinearLayoutManager(requireContext())
        binding.lista.adapter=adapter
        binding.lista.layoutManager=layoutManager

        //return inflater.inflate(R.layout.fragment_lista, container, false)
        return binding.root
    }


}