package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    //   val conditionText1
// lateinint - что это ? Какой есть другой способ инициализации

    fun setConditionField(str:String){
        val conditionText = findViewById<TextView>(R.id.condition)
        conditionText.setText(conditionText.text.toString()+str)
    }

    fun zero() {
        findViewById<TextView>(R.id.zero).setOnClickListener{
            Toast.makeText(it.context, "0 is added",Toast.LENGTH_SHORT).show()
            setConditionField(findViewById<TextView>(R.id.zero).text.toString())
        }
    }
    fun threeZero() {
        findViewById<TextView>(R.id.threeZero).setOnClickListener{
            Toast.makeText(it.context, "000 is added", Toast.LENGTH_SHORT).show()
            setConditionField(findViewById<TextView>(R.id.threeZero).text.toString())
        }
    }
    fun one(){
            findViewById<TextView>(R.id.one).setOnClickListener{
                Toast.makeText(it.context, "1 is added", Toast.LENGTH_SHORT).show()
                setConditionField(findViewById<TextView>(R.id.one).text.toString())
        }
    }
    fun two() {
        findViewById<TextView>(R.id.two).setOnClickListener{
            Toast.makeText(it.context, "2 is added", Toast.LENGTH_SHORT).show()
            setConditionField(findViewById<TextView>(R.id.two).text.toString())
        }
    }
    fun three() {
        findViewById<TextView>(R.id.three).setOnClickListener{
            Toast.makeText(it.context, "3 is added", Toast.LENGTH_SHORT).show()
            setConditionField(findViewById<TextView>(R.id.three).text.toString())
        }
    }
    fun four() {
        findViewById<TextView>(R.id.four).setOnClickListener{
            Toast.makeText(it.context, "4 is added", Toast.LENGTH_SHORT).show()
            setConditionField(findViewById<TextView>(R.id.four).text.toString())
        }
    }
    fun five() {
        findViewById<TextView>(R.id.five).setOnClickListener{
            Toast.makeText(it.context, "5 is added", Toast.LENGTH_SHORT).show()
            setConditionField(findViewById<TextView>(R.id.five).text.toString())
        }
    }
    fun six() {
        findViewById<TextView>(R.id.six).setOnClickListener{
            Toast.makeText(it.context, "6 is added", Toast.LENGTH_SHORT).show()
            setConditionField(findViewById<TextView>(R.id.six).text.toString())
        }
    }
    fun seven() {
        findViewById<TextView>(R.id.seven).setOnClickListener{
            Toast.makeText(it.context, "7 is added", Toast.LENGTH_SHORT).show()
            setConditionField(findViewById<TextView>(R.id.seven).text.toString())
        }
    }
    fun eight() {
        findViewById<TextView>(R.id.eight).setOnClickListener{
            Toast.makeText(it.context, "8 is added", Toast.LENGTH_SHORT).show()
            setConditionField(findViewById<TextView>(R.id.eight).text.toString())
        }
    }
    fun nine(){
        findViewById<TextView>(R.id.nine).setOnClickListener{
            Toast.makeText(it.context, "9 is added", Toast.LENGTH_SHORT).show()
            setConditionField(findViewById<TextView>(R.id.nine).text.toString())
        }
    }
    fun equall(){
        findViewById<TextView>(R.id.equall)
    }

    fun reset(){
            findViewById<TextView>(R.id.reset).setOnClickListener{
            Toast.makeText(this, "Clear", Toast.LENGTH_LONG).show()
            findViewById<TextView>(R.id.condition).setText("")
        }
    }
    fun run(){
        zero()
        threeZero()
        one()
        two()
        three()
        four()
        five()
        six()
        seven()
        eight()
        nine()
        reset()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            // conditionText1 = findViewById<TextView>(R.id.condition)
        run()
//
//        // вынести вверх. не срать в onCreate
//        val conditionText = findViewById<TextView>(R.id.condition)
//        val deleteButton = findViewById<TextView>(R.id.delete)
//
//
//        deleteButton.setOnClickListener {
//
//            // вынести в метод. не срать в onCreate
//            Toast.makeText(it.context, "Text", Toast.LENGTH_LONG).show()
//            var newConditionText = conditionText.text.toString() + "0"
//            conditionText.setText(newConditionText)
//        }

    }
}