package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    //   val conditionText1
// lateinint - что это ? Какой есть другой способ инициализации

    lateinit var condition : TextView
    lateinit var zero : TextView
    lateinit var threeZero : TextView
    lateinit var one : TextView
    lateinit var two : TextView
    lateinit var three : TextView
    lateinit var four : TextView
    lateinit var five : TextView
    lateinit var six : TextView
    lateinit var seven : TextView
    lateinit var eight : TextView
    lateinit var nine : TextView
    lateinit var plus : TextView
    lateinit var minus : TextView
    lateinit var multiply : TextView
    lateinit var divide : TextView
    lateinit var clear : TextView
    lateinit var reset : TextView
    lateinit var percent : TextView
    lateinit var equall : TextView
    lateinit var result : TextView
    lateinit var point : TextView
    lateinit var resultString : String
    lateinit var conditionString : String

    var isPoint = false
    var isPercent = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // conditionText1 = findViewById<TextView>(R.id.condition)
        initialization()
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

    fun isNumber(input: String): Boolean {
        val integerChars = '0'..'9'
        return input.all { it in integerChars}
    }

    fun setResultField(str:String){
        var string = str
        if(str.last().toString() == "0")
            string = str.dropLast(2)
        result.setText(string)
    }

    fun setConditionField(str: String) {
        conditionString = condition.text.toString()

        if(isNumber(str) || isNumber(conditionString.last().toString())){
            condition.setText(conditionString + str)
            resultString = conditionString+str
        }
        else if (!isNumber(str)|| !isPoint || !isPercent){
            conditionString = conditionString.dropLast(1)
            condition.setText(conditionString + str)
        }

    }

//    fun setResultField(str:String){
//        result.setText(str)
//    }

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

    fun operation(){

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

    fun point(){
        point.setOnClickListener{
            setConditionField(point.text.toString())
            isPoint = true
        }
    }
    fun percent() {
        percent.setOnClickListener{
            setConditionField(percent.text.toString())
            isPercent = true
        }
    }

    fun equall() {
        equall.setOnClickListener{
           try{ val ex = ExpressionBuilder(resultString).build()
            resultString = ex.evaluate().toString()
            setResultField(resultString)
           } catch(e:Exception){
               setResultField("Invalid Expression")
               Log.d("Ошибка.", "текст  ${e.message}" )
           }
        }
    }

    fun clear() {
        clear.setOnClickListener{
            val conditionString = condition.text.toString()
            Toast.makeText(this, "Clear1", Toast.LENGTH_LONG).show()
            if(conditionString.isNotEmpty())   {
                condition.setText(conditionString.dropLast(1))
            }
        }
    }
    fun reset(){
        reset.setOnClickListener{
            Toast.makeText(this, "Clear", Toast.LENGTH_LONG).show()
            condition.setText("")
            result.setText("")
        }
    }
    fun initialization(){
        result = findViewById<TextView>(R.id.result)
        condition = findViewById<TextView>(R.id.condition)
        zero = findViewById<TextView>(R.id.zero)
        threeZero = findViewById<TextView>(R.id.threeZero)
        one = findViewById<TextView>(R.id.one)
        two = findViewById<TextView>(R.id.two)
        three = findViewById<TextView>(R.id.three)
        four = findViewById<TextView>(R.id.four)
        five = findViewById<TextView>(R.id.five)
        six = findViewById<TextView>(R.id.six)
        seven = findViewById<TextView>(R.id.seven)
        eight = findViewById<TextView>(R.id.eight)
        nine = findViewById<TextView>(R.id.nine)
        plus = findViewById<TextView>(R.id.plus)
        minus = findViewById<TextView>(R.id.minus)
        multiply = findViewById<TextView>(R.id.multiply)
        divide = findViewById<TextView>(R.id.divide)
        clear = findViewById<TextView>(R.id.clear)
        reset = findViewById<TextView>(R.id.reset)
        percent = findViewById<TextView>(R.id.percent)
        equall = findViewById<TextView>(R.id.equall)
        point = findViewById<TextView>(R.id.point)
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
        point()
        percent()
        equall()
    }


}