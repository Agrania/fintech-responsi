package io.github.agrania.fintechresponsi

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.SparseArray
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.SurfaceHolder
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat.startActivity
import java.util.jar.Manifest

class PaymentFragment : Fragment() {

    private val requestCodeCameraPermission = 1001
    private lateinit var tvHere: TextView
    private lateinit var cameraSource: CameraSource
    private lateinit var detector: BarcodeDetector
    private lateinit var tvHere : TextView

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setting, container, false)

        if (ContentCompat.checkSelfPermission(
                        this@PaymentFragment,
                        Manifest.permission.CAMERA
                ) != PackageManager.PERMISSION_GRANTED
        ) {
            askForcameraPermission()
        } else
            setupControls()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvHere = view.findViewById(R.id.tv_here)

        tvHere.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_here -> {
                startActivity(Intent(activity, PaymentActivity::class.java))
            }
        }
    }

    private fun setupControls() {
        detector = BarcodeDetector.Builder(this@PaymentFragment).build()
        cameraSource = CameraSource.Builder(this@PaymentFragment), detector)
        .setAutoFocusEnabled(true)
                .build()
        cameraSurfaceView.holder.addCallback(surfaceCallBack)
        detector.setProcessor(processor)
    }
    private fun askForcameraPermission() {
        ActivityCompat.requestPermissions(
                this@PaymentFragment,
                arrayOf(Manifest.permission.CAMERA),
                requestCodeCameraPermission
        )
    }

    override fun onRequestPermissionsResult(
            requestCode: Int,
            permission: Array<out String>,
            grantResults: IntArray
    ){
        super.onRequestPermissionsResult(requestCode, permission, grantResults)
        if(requestCode == requestCodeCameraPermission && grantResults.isNotEmpty()){
            setupControls()
        } else {
            Toast.makeText(applicationContext, "Permission Denied", Toast.LENGTH_SHORT).show()
        }

        private val surfaceCallBack = object : SurfaceHolder.Callback{

            override fun surfaceChanged(holder: SurfaceHolder?, p1: Int, p2: Int, p3:Int) {

            }

            override fun surfaceDestroyed(p0: SurfaceHolder?) {
                cameraSource.stop()
            }

            override fun surfaceCreated(surfaceHolder: SurfaceHolder) {
                try {
                    cameraSource.start(surfaceHolder)
                } catch (exception: Exception) {
                    Toast.makeText(applicationContext, "Something went wrong", Toast.LENGTH_LONG)
                            .show()
                }
            }
        }

        private val processor = object : Detector.Processor<Barcode>{
            override fun release() {

            }

            override fun receiveDetections(detections: Detectoor.Detections<Barcode>?) {

                if(detections != null && detections.detectedItems.isNotEmpty()) {
                    val qrCodes: SparseArray<Barcode> = detections.detectedItems
                    val code = qrCodes.value(0)
                    textScanResult.text = code.displayValue
                } else {
                    textScanResult.text = ""
                }
            }
        }

    }
}