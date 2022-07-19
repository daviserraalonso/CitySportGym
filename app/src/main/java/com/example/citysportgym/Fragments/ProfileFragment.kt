package com.example.citysportgym.Fragments

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.citysportgym.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment() : Fragment() {
    // TODO: Rename and change types of parameters
    private var userNameConst: String? = null
    private var userAddressConst: String? = null
    private var userEmailConst: String? = null
    private var userPhoneConst: String? = null
    private var passwordConst: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var userNameConst = getArguments()?.getString(SENDING_NAME)
        var userAddressConst = getArguments()?.getString(SENDING_ADDRESS)
        var userEmailConst = getArguments()?.getString(SENDING_EMAIL)
        var userPhoneConst = getArguments()?.getString(SENDING_PHONE)
        var passwordConst = getArguments()?.getString(SENDING_PASSWORD)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_profile, container, false)
        var bundle: Bundle? = null
        bundle = this.arguments

        var editUserName = view.findViewById<EditText>(R.id.userName)
        var userAddresEdit = view.findViewById<EditText>(R.id.userAddress)
        var userEmailEdit = view.findViewById<EditText>(R.id.userEmailText)
        var userPhoneEdit = view.findViewById<EditText>(R.id.userPhone)
        var userPasswordEdit = view.findViewById<EditText>(R.id.userPasswordEdit)

        editUserName.setText(userNameConst.toString())
        userAddresEdit.setText(userAddressConst.toString())
        userEmailEdit.setText(userEmailConst.toString())
        userPhoneEdit.setText(userPhoneConst.toString())
        userPasswordEdit.setText(passwordConst.toString())

        return view
    }



    companion object {
        const val SENDING_NAME = "mqttAndroidClientAddress"
        const val SENDING_ADDRESS = "mqttAndroidClientId"
        const val SENDING_EMAIL = "x"
        const val SENDING_PHONE = "x"
        const val SENDING_PASSWORD = "x"

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(userName: String, userAddress: String, userEmail: String,
                        userPhone: String, password: String): ProfileFragment {
            Log.i(TAG, "entro")
            val args = Bundle()
            args.putString(SENDING_NAME, userName)
            args.putString(SENDING_ADDRESS , userAddress)
            args.putString(SENDING_EMAIL , userEmail)
            args.putString(SENDING_PHONE , userPhone)
            args.putString(SENDING_PASSWORD , password)
            val fragment = ProfileFragment()
            fragment.arguments = args
            return fragment
        }

    }
}