package com.example.ghtk_day3

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.ghtk_day3.databinding.ActivityMainBinding
import com.example.ghtk_day3.databinding.FragmentFirstBinding
import com.example.ghtk_day3.databinding.FragmentSecondBinding
import kotlin.math.abs
import kotlin.math.log

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentSecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SecondFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SecondFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btn2.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
        }
        binding.btnSubmit2.setOnClickListener {
            try {
                val xx: Float = binding.edtXX.text.toString().toFloat()
                val yx: Float = binding.edtYX.text.toString().toFloat()
                val xa: Float = binding.edtXA.text.toString().toFloat()
                val ya: Float = binding.edtYA.text.toString().toFloat()
                val xb: Float = binding.edtXB.text.toString().toFloat()
                val yb: Float = binding.edtYB.text.toString().toFloat()
                val xc: Float = binding.edtXC.text.toString().toFloat()
                val yc: Float = binding.edtYC.text.toString().toFloat()
                val s:Float=tinhDienTich(xa,xb,xb,yb,xc,yc)
                val s1:Float=tinhDienTich(xx,yx,xa,ya,xb,yb)
                val s2:Float=tinhDienTich(xx,yx,xa,ya,xc,yc)
                val s3:Float=tinhDienTich(xx,yx,xb,yb,xc,yc)
                if(s==(s1+s2+s3)){
                    binding.tvResult2.text="Diem x nam trong tam giac ABC"
                }else{
                    binding.tvResult2.text="Diem x nam ngoai tam giac ABC"
                }
            } catch (e: NumberFormatException) {
                Toast.makeText(requireContext(), "Vui long nhap vao dung so", Toast.LENGTH_SHORT)
                    .show()
            }


        }
    }

    fun tinhDienTich(x1: Float, y1: Float, x2: Float, y2: Float, x3: Float, y3: Float): Float {
        return 0.5f * abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2))
    }
}