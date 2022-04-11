package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    //   val conditionText1
// lateinint - что это ? Какой есть другой способ инициализации

    val condition = findViewById<TextView>(R.id.condition)
    val zero = findViewById<TextView>(R.id.zero)
    val threeZero = findViewById<TextView>(R.id.threeZero)
    val one = findViewById<TextView>(R.id.one)
    val two = findViewById<TextView>(R.id.two)
    val three = findViewById<TextView>(R.id.three)
    val four = findViewById<TextView>(R.id.four)
    val five = findViewById<TextView>(R.id.five)
    val six = findViewById<TextView>(R.id.six)
    val seven = findViewById<TextView>(R.id.seven)
    val eight = findViewById<TextView>(R.id.eight)
    val nine = findViewById<TextView>(R.id.nine)
    val plus = findViewById<TextView>(R.id.plus)
    val minus = findViewById<TextView>(R.id.minus)
    val multiply = findViewById<TextView>(R.id.multiply)
    val divide = findViewById<TextView>(R.id.divide)
    val clear = findViewById<TextView>(R.id.clear)
    val reset = findViewById<TextView>(R.id.reset)
    val percent = findViewById<TextView>(R.id.percent)
    val equall = findViewById<TextView>(R.id.equall)
    val conditionString = condition.text.toString()

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
    fun setConditionField(str: String) {
        condition.setText(condition.text.toString() + str)
    }

    fun zero() {
        zero.setOnClickListener {
            Toast.makeText(it.context, "0 is added", Toast.LENGTH_SHORT).show()
            setConditionField(zero.text.toString())
        }
    }

    fun threeZero() {
        threeZero.setOnClickListener {
            Toast.makeText(it.context, "000 is added", Toast.LENGTH_SHORT).show()
            setConditionField(threeZero.text.toString())
        }
    }

    fun one() {
        one.setOnClickListener {
            Toast.makeText(it.context, "1 is added", Toast.LENGTH_SHORT).show()
            setConditionField(one.text.toString())
        }
    }

    fun two() {
        two.setOnClickListener {
            Toast.makeText(it.context, "2 is added", Toast.LENGTH_SHORT).show()
            setConditionField(two.text.toString())
        }
    }

    fun three() {
        three.setOnClickListener {
            Toast.makeText(it.context, "3 is added", Toast.LENGTH_SHORT).show()
            setConditionField(three.text.toString())
        }
    }

    fun four() {
        four.setOnClickListener {
            Toast.makeText(it.context, "4 is added", Toast.LENGTH_SHORT).show()
            setConditionField(four.text.toString())
        }
    }

    fun five() {
        five.setOnClickListener {
            Toast.makeText(it.context, "5 is added", Toast.LENGTH_SHORT).show()
            setConditionField(five.text.toString())
        }
    }

    fun six() {
        six.setOnClickListener {
            Toast.makeText(it.context, "6 is added", Toast.LENGTH_SHORT).show()
            setConditionField(six.text.toString())
        }
    }

    fun seven() {
        seven.setOnClickListener {
            Toast.makeText(it.context, "7 is added", Toast.LENGTH_SHORT).show()
            setConditionField(seven.text.toString())
        }
    }

    fun eight() {
        eight.setOnClickListener {
            Toast.makeText(it.context, "8 is added", Toast.LENGTH_SHORT).show()
            setConditionField(eight.text.toString())
        }
    }

    fun nine() {
        nine.setOnClickListener {
            Toast.makeText(it.context, "9 is added", Toast.LENGTH_SHORT).show()
            setConditionField(nine.text.toString())
        }
    }

    fun orderOperation(){
        val condition = findViewById<TextView>(R.id.condition)

    }

    fun plus() {
        plus.setOnClickListener {
            setConditionField(plus.text.toString())
        }
    }

    fun minus() {
        minus.setOnClickListener {
            setConditionField(minus.text.toString())
        }
    }

    fun multiply() {
        multiply.setOnClickListener {
            setConditionField(multiply.text.toString())
        }
    }

    fun divide() {
        divide.setOnClickListener {
            setConditionField(divide.text.toString())
        }
    }

    fun percent() {

    }

    fun equall() {

    }

    fun clear() {
       clear.setOnClickListener{
            Toast.makeText(this, "Clear1", Toast.LENGTH_LONG).show()
            if(conditionString.isNotEmpty())   {
                condition.setText(conditionString.substring(0,conditionString.length -1))
                }
            }
    }
    fun reset(){
            reset.setOnClickListener{
            Toast.makeText(this, "Clear", Toast.LENGTH_LONG).show()
            condition.setText("")
            reset.setText("")
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
        plus()
        minus()
        multiply()
        divide()
        clear()
    }


}