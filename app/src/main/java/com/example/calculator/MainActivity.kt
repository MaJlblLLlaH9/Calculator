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

    private var pointExist : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialization()
    }


    private fun isNumber(input: String): Boolean {
        val integerChars = '0'..'9'
        return input.all { it in integerChars }
    }


    private fun initConditionView() {
        condition = findViewById(R.id.condition)
    }

    private fun initResultView() {
        result = findViewById(R.id.result)
    }

    private  fun clearFields(){
        condition.text = ""
        result.text = ""
        pointExist = false
    }

    private fun setResultField(answer: String) {

        result.text = answer
    }

    private fun defineConditionString() : String {
        return condition.text.toString()
    }

    // TODO : написать javaDoc для этого метода. Что принимает и что делает
    private fun setConditionField(expression: String) {
        conditionString = defineConditionString()

        if(conditionString.isEmpty()){
            condition.text = expression
        }
        else if (isNumber (expression) || isNumber(conditionString.last().toString()) || conditionString.last().toString() == "."|| conditionString.last().toString() == "%") {
            condition.text = conditionString + expression
            resultString = condition.text.toString()
        }
        else {
            conditionString = conditionString.dropLast(1)
            condition.text =  conditionString + expression

        }

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
            if(!pointExist){
                setConditionField(point.text.toString())
                pointExist = true
            }
        }
    }


    private fun calculation(expression: String): String {
        try {
            return if( isNumber (resultString.last().toString())){
                ExpressionBuilder (expression).build().evaluate().toString()
            } else {
                ExpressionBuilder (expression.dropLast(1)).build().evaluate().toString()
            }
        } catch (e : Exception) {
            clearFields()
            return ("Invalid Expression")
            Log.d("Ошибка.", "текст  ${e.message}")
        }
    }

    private fun initPercentView() {
        percent = findViewById(R.id.percent)
        percent.setOnClickListener {
            setConditionField(percent.text.toString())

            conditionString = defineConditionString()

            var position = conditionString.length - 2
            val conditionArray = conditionString.toCharArray()

            while (isNumber(conditionArray[position].toString()) && position != 0) {
                position--
            }

            if (position == 0 ) {
                setResultField(conditionString.dropLast(1))
            } else {

            val stringBeforePercent = resultString.substring(0 , position)

            val quantityOfPercent = resultString.substring(position + 1 , conditionString.length - 1)

            val countOfPercent = ((quantityOfPercent.toDouble() / 100) * (ExpressionBuilder(stringBeforePercent).build().evaluate()))

            resultString = stringBeforePercent + conditionArray[position] + countOfPercent.toString()

                setResultField(calculation(resultString))

            clearFields()
            setConditionField(resultString)
            }
        }
    }

    private fun initEqualView() {
        equal = findViewById(R.id.equall)
        equal.setOnClickListener {
           setResultField( calculation(resultString))
        }
    }

    private fun initClearView() {
        clear = findViewById(R.id.clear)
        clear.setOnClickListener {

            val conditionString = condition.text.toString()

            if (conditionString.isNotEmpty() && conditionString.last() == '.') {
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
