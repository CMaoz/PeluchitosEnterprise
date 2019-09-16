package com.example.peluchitosenterprise.ui.tools

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.peluchitosenterprise.R
import com.example.peluchitosenterprise.User
import kotlinx.android.synthetic.main.fragment_tools.view.*

class ToolsFragment : Fragment() {

    private lateinit var user: User

    var listUser: ArrayList<User> = ArrayList()
    private  var peluche = ""


    override fun onCreateView(
        inflater: LayoutInflater,container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tools, container, false)

        if (arguments!= null){
            listUser = arguments!!.getParcelableArrayList(ARG_PARAM)!!

            for (user in listUser){

                peluche = peluche + user.id + "     " + user.nombre + "     " + user.cantidad + "     " + user.precio + "\n"
            }

            view.tvinventario.text = peluche
            peluche = ""

        }
        else {
            view.tvinventario.text = "La lista se encuentra vacia"
        }

        return view
    }

    companion object{
        private val ARG_PARAM = "MyObject"

        fun newInstance(userList: ArrayList<User>): ToolsFragment{
            val datosFragment= ToolsFragment()
            val args = Bundle()
            args.putParcelableArrayList(ARG_PARAM,userList)
            datosFragment.arguments=args
            return  datosFragment

        }

    }
}