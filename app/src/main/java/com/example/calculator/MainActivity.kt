package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception


class MainActivity : AppCompatActivity() {

    private lateinit var condition: TextView
    private lateinit var zero: TextView
    private lateinit var threeZero: TextView
    private lateinit var one: TextView
    private lateinit var two: TextView
    private lateinit var three: TextView
    private lateinit var four: TextView
    private lateinit var five: TextView
    private lateinit var six: TextView
    private lateinit var seven: TextView
    private lateinit var eight: TextView
    private lateinit var nine: TextView
    private lateinit var plus: TextView
    private lateinit var minus: TextView
    private lateinit var multiply: TextView
    private lateinit var divide: TextView
    private lateinit var clear: TextView
    private lateinit var reset: TextView
    private lateinit var percent: TextView
    private lateinit var equal: TextView
    private lateinit var result: TextView
    private lateinit var point: TextView
    private lateinit var resultString: String
    private lateinit var conditionString: String

    private var pointExist: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialization()
    }

    private fun defineConditionString(): String {
        return condition.text.toString()
    }

    private fun isNumber(input: String): Boolean {
        val integerChars = '0'..'9'
        return input.all { it in integerChars }
    }


    private fun initConditionView() {
        condition = findViewById(R.id.condition)
    }

    private fun pasteSymbol(value: String): String {
        return conditionString + value
    }

    private fun initResultView() {
        result = findViewById(R.id.result)
    }

    private fun setResultField(answer: String) {
        result.text = answer
    }

    private fun setConditionField(value: String) {
        conditionString = defineConditionString()

        if(conditionString.isEmpty()){
            condition.text = value
        }
        else if (checkingOnOperator(value)) {
            conditionString = conditionString.dropLast(1)
            condition.text =  pasteSymbol(value)

        }
        else {
            condition.text = pasteSymbol(value)
            resultString = defineConditionString()
        }

    }

    private fun checkingOnOperator(value: String): Boolean {
        return !(isNumber (value) || isNumber(conditionString.last().toString()) || conditionString.last().toString() == "."|| conditionString.last().toString() == "%")
    }

    private fun initThreeZeroView() {
        threeZero = findViewById(R.id.threeZero)
        threeZero.setOnClickListener {
            setConditionField(threeZero.text.toString())
        }
    }

    private fun initOneView() {
        one = findViewById(R.id.one)
        one.setOnClickListener {
            setConditionField(one.text.toString())
        }
    }

    private fun initTwoView() {
        two = findViewById(R.id.two)
        two.setOnClickListener {
            setConditionField(two.text.toString())
        }
    }

    private fun initThreeView() {
        three = findViewById(R.id.three)
        three.setOnClickListener {
            setConditionField(three.text.toString())
        }
    }

    private fun initFourView() {
        four = findViewById(R.id.four)
        four.setOnClickListener {
            setConditionField(four.text.toString())
        }
    }

    private fun initFiveView() {
        five = findViewById(R.id.five)
        five.setOnClickListener {
            setConditionField(five.text.toString())
        }
    }

    private fun initSixView() {
        six = findViewById(R.id.six)
        six.setOnClickListener {
            setConditionField(six.text.toString())
        }
    }

    private fun initSevenView() {
        seven = findViewById(R.id.seven)
        seven.setOnClickListener {
            setConditionField(seven.text.toString())
        }
    }

    private fun initEightView() {
        eight = findViewById(R.id.eight)
        eight.setOnClickListener {
            setConditionField(eight.text.toString())
        }
    }

    private fun initNineView() {
        nine = findViewById(R.id.nine)
        nine.setOnClickListener {
            setConditionField(nine.text.toString())
        }
    }

    private fun initZeroView() {
        zero = findViewById(R.id.zero)
        zero.setOnClickListener {
            setConditionField(zero.text.toString())
        }
    }


    private fun initPlusView() {
        plus = findViewById(R.id.plus)
        plus.setOnClickListener {
            setConditionField(plus.text.toString())
            pointExist = false
        }
    }

    private fun initMinusView() {
        minus = findViewById(R.id.minus)
        minus.setOnClickListener {
            setConditionField(minus.text.toString())
            pointExist = false
        }
    }

    private fun initMultiplyView() {
        multiply = findViewById(R.id.multiply)
        multiply.setOnClickListener {
            setConditionField(multiply.text.toString())
            pointExist = false
        }
    }

    private fun initDivideView() {
        divide = findViewById(R.id.divide)
        divide.setOnClickListener {
            setConditionField(divide.text.toString())
            pointExist = false
        }
    }

    private fun initPointView() {
        point = findViewById(R.id.point)
        point.setOnClickListener {
            checkingPoint()
            if (!pointExist) {
                setConditionField(point.text.toString())
                pointExist = true
            }
        }
    }

    private fun checkingPoint() {
        conditionString = defineConditionString()
        pointExist = false
        val conditionArray = conditionString.toCharArray()
        var position = conditionString.length-2

        if(conditionArray[position+1] == '.'){
            pointExist = true
            return
        }
//
        while((isNumber(conditionArray[position].toString()) || conditionArray[position] == '.') && position > 0){
            if(conditionArray[position] == '.'){
                pointExist = true
                break
            }else {
                position--
            }
        }

        }


    private fun initPercentView() {
        percent = findViewById(R.id.percent)
        percent.setOnClickListener {
            conditionString = defineConditionString()

            if (defineConditionString().isEmpty()) {
                clearFields()
            } else {
                setConditionField(percent.text.toString())

                resultString = countOfPercent(findPositionOfPercentNumber())

                clearFields()
                setResultField(resultString)
                setConditionField(resultString)
            }
        }
    }

    private  fun findPositionOfPercentNumber(): Int {

        var position = conditionString.length - 2
        val conditionArray = conditionString.toCharArray()

        while ((isNumber(conditionArray[position].toString()) && position != 0)||conditionArray[position]== '.') {
            position--
        }
        return position
    }

    private fun countOfPercent(position: Int): String {
        conditionString = defineConditionString()
        val conditionArray = conditionString.toCharArray()

        return if (position == 0) {
            (conditionString.dropLast(1).toDouble()/100).toString()
        } else {
            val stringBeforePercent = resultString.substring(0, position)
            val quantityOfPercent = resultString.substring(position + 1, conditionString.length - 1)
            val calculatedPercent =
                ((quantityOfPercent.toDouble() / 100) * (ExpressionBuilder(stringBeforePercent).build()
                    .evaluate()))

            stringBeforePercent + conditionArray[position] + calculatedPercent.toString()
        }

    }


    private fun initClearView() {
        clear = findViewById(R.id.clear)
        clear.setOnClickListener {

            conditionString = defineConditionString()

            if(conditionString.isNotEmpty() && conditionString.last() == '.') {
                condition.text = conditionString.dropLast(1)
                pointExist = false
            }
            else {
                condition.text = conditionString.dropLast(1)
            }
        }
    }

    private fun initResetView() {
        reset = findViewById(R.id.reset)
        reset.setOnClickListener {
            clearFields()
        }
    }

    private fun initEqualView() {
        equal = findViewById(R.id.equall)
        equal.setOnClickListener {
           setResultField( calculation(resultString))
        }
    }

    private  fun clearFields() {
        condition.text = ""
        result.text = ""
        pointExist = false
    }

    private fun calculation(expression: String): String {
        return try{
            if( isNumber (resultString.last().toString())) {
                ExpressionBuilder (expression).build().evaluate().toString()
            } else {
                ExpressionBuilder (expression.dropLast(1)).build().evaluate().toString()
            }
        } catch(e : Exception) {
            clearFields()
            Log.d("Error.", "text  ${e.message}")
            ("Invalid Expression")
        }
    }

    private fun initialization() {
        initResultView()
        initConditionView()
        initZeroView()
        initThreeZeroView()
        initOneView()
        initTwoView()
        initThreeView()
        initFourView()
        initFiveView()
        initSixView()
        initSevenView()
        initEightView()
        initNineView()
        initPlusView()
        initMinusView()
        initMultiplyView()
        initDivideView()
        initClearView()
        initResetView()
        initPercentView()
        initEqualView()
        initPointView()
    }
}
