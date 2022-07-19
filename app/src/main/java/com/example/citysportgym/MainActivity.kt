package com.example.citysportgym

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.AuthFailureError
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.example.citysportgym.EndPoint.EndPoint
import com.example.citysportgym.Fragments.ProfileFragment
import com.example.citysportgym.singleton.VolleySingleton
import org.json.JSONException
import org.json.JSONObject


class MainActivity : AppCompatActivity() {
    private var editTextEmail: EditText? = null
    private var editTextPassword: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // get btnLogin to set action
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        editTextEmail = findViewById<EditText>(R.id.userEmail)
        editTextPassword = findViewById<EditText>(R.id.userPassword)


        // ACTION BUTTON LOGIN
        btnLogin.setOnClickListener{
            login(editTextEmail!!.getText().toString(), editTextPassword!!.getText().toString())
        }
    }

    // function login
    private fun login(email:String, password:String) {
        //creating volley string request
        val stringRequest: StringRequest = object : StringRequest(Method.POST, EndPoint.URL,
            Response.Listener { response ->
                try {
                    val jsonObject = JSONObject(response)

                    if (jsonObject != null) {
                        val dataJson: JSONObject = jsonObject.getJSONObject("user")
                        val name = dataJson.getString("name")
                        val address = dataJson.getString("address")
                        val email = dataJson.getString("email")
                        val phone = dataJson.getString("phone")
                        val password = dataJson.getString("password")

                        val intent = Intent(this, ProfileActivity::class.java)
                        // set parameter to activity
                        val bundle = Bundle()
                        bundle.putString("name", name)
                        bundle.putString("address", address)
                        bundle.putString("email", email)
                        bundle.putString("phone", phone)
                        bundle.putString("password", password)
                        intent.putExtras(bundle)
                        startActivity(intent)

                        Toast.makeText(applicationContext, "Logged ok", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            },
            Response.ErrorListener { println("volley Error .................") }) {
            @Throws(AuthFailureError::class)
            override fun getParams(): Map<String, String>? {
                val params: MutableMap<String, String> = HashMap()
                params["action"] = "login"
                params["email"] = email
                params["password"] = password
                return params
            }
        }

        VolleySingleton.instance?.addToRequestQueue(stringRequest)
    }
}