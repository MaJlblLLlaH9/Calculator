package com.example.calculator

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    lateinit var condition: TextView
    lateinit var zero: TextView
    lateinit var threeZero: TextView
    lateinit var one: TextView
    lateinit var two: TextView
    lateinit var three: TextView
    lateinit var four: TextView
    lateinit var five: TextView
    lateinit var six: TextView
    lateinit var seven: TextView
    lateinit var eight: TextView
    lateinit var nine: TextView
    lateinit var plus: TextView
    lateinit var minus: TextView
    lateinit var multiply: TextView
    lateinit var divide: TextView
    lateinit var clear: TextView
    lateinit var reset: TextView
    lateinit var percent: TextView
    lateinit var equall: TextView
    lateinit var result: TextView
    lateinit var point: TextView
    lateinit var resultString: String
    lateinit var conditionString: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialization()
    }

    fun initConditionView() {
        condition = findViewById(R.id.condition)
    }

    fun initResultView() {
        result = findViewById(R.id.result)
    }

    private fun isNumber(input: String): Boolean {
        val integerChars = '0'..'9'
        return input.all { it in integerChars }
    }

    // Str - Навроцкий был бы рад
    private fun setResultField(answer: String) {

        var string = answer
        if (answer.last().toString() == "0") {
            string = answer.dropLast(2)
        }
        result.text = string
    }

    // Str - Навроцкий был бы рад
    // TODO : написать javaDoc для этого метода. Что принимает и что делает
    private fun setConditionField(expression: String) {
        conditionString = condition.text.toString()

        if (isNumber(expression) || isNumber(conditionString.last().toString())) {
            condition.text = conditionString + expression
            resultString = conditionString + expression
        } else if (!isNumber(expression)) {
            conditionString = conditionString.dropLast(1)
            condition.text = conditionString + expression
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

    fun initSixView() {
        six = findViewById(R.id.six)
        six.setOnClickListener {
            setConditionField(six.text.toString())
        }
    }

    fun initSevenView() {
        seven = findViewById(R.id.seven)
        seven.setOnClickListener {
            setConditionField(seven.text.toString())
        }
    }

    fun initEightView() {
        eight = findViewById(R.id.eight)
        eight.setOnClickListener {
            setConditionField(eight.text.toString())
        }
    }

    fun initNineView() {
        nine = findViewById(R.id.nine)
        nine.setOnClickListener {
            setConditionField(nine.text.toString())
        }
    }

    fun initPlusView() {
        plus = findViewById(R.id.plus)
        plus.setOnClickListener {
            setConditionField(plus.text.toString())
        }
    }

    fun initMinusView() {
        minus = findViewById(R.id.minus)
        minus.setOnClickListener {
            setConditionField(minus.text.toString())
        }
    }

    fun initMultiplyView() {
        multiply = findViewById(R.id.multiply)
        multiply.setOnClickListener {
            setConditionField(multiply.text.toString())
        }
    }

    fun initDivideView() {
        divide = findViewById(R.id.divide)
        divide.setOnClickListener {
            setConditionField(divide.text.toString())
        }
    }

    fun initPointView() {
        point = findViewById(R.id.point)
        point.setOnClickListener {
            setConditionField(point.text.toString())
            //  isPoint = true
        }
    }

    fun calculation(expression: String) {
        val result = ExpressionBuilder(expression).build().evaluate().toString()
        setResultField(result)
    }

    fun initPercentView() {
        percent = findViewById(R.id.percent)
        percent.setOnClickListener {
            setConditionField(percent.text.toString())

            var resultStringWithPercent = ""
            var stringBeforePercent = ""
            var quantityOfPercent = ""

            var position = resultString.length - 2
            var conditionArray = resultString.toCharArray()

            while (isNumber(conditionArray[position].toString())) {
                position--
            }
            stringBeforePercent = conditionString.dropLast(conditionString.length - position)

            quantityOfPercent = resultString.substring(position + 1, resultString.length - 1)

            var countOfPercent = ((quantityOfPercent.toDouble() / 100) * stringBeforePercent.toDouble())

            resultStringWithPercent =
                    stringBeforePercent + conditionArray[position] + countOfPercent.toString()
            calculation(resultStringWithPercent)
        }
    }

    fun initEquallView() {
        equall = findViewById(R.id.equall)
        equall.setOnClickListener {
            calculation(resultString)
        }
    }

    fun initClearView() {
        clear = findViewById(R.id.clear)
        clear.setOnClickListener {
            val conditionString = condition.text.toString()
            if (conditionString.isNotEmpty()) {
                condition.text = conditionString.dropLast(1)
            }
        }
    }

    fun initResetView() {
        reset = findViewById(R.id.reset)
        reset.setOnClickListener {
            condition.text = "0"
            result.text = ""
        }
    }

    fun initZeroView() {
        zero = findViewById(R.id.zero)
        zero.setOnClickListener {
            setConditionField(zero.text.toString())
        }
    }

    fun initialization() {
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
        initEquallView()
        initPointView()
    }

}
