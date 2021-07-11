package io.github.agrania.fintechresponsi

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView

class SettingFragment : Fragment() {

    private lateinit var cvProfile : CardView
    private lateinit var cvBank : CardView
    private lateinit var cvCredit : CardView
    private lateinit var cvPassword : CardView
    private lateinit var cvHelp : CardView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cvProfile = view.findViewById(R.id.cv_profile)
        cvBank= view.findViewById(R.id.cv_bank)
        cvCredit = view.findViewById(R.id.cv_credit)
        cvPassword = view.findViewById(R.id.cv_password)
        cvHelp= view.findViewById(R.id.cv_help)

        cvProfile.setOnClickListener(this)
        cvBank.setOnClickListener(this)
        cvCredit.setOnClickListener(this)
        cvPassword.setOnClickListener(this)
        cvHelp.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.cv_profile -> {
                startActivity(Intent(activity,ProfileActivity::class.java))
            }
        }
    }
}