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

    private fun defineConditionString(): String{
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

    private fun setEmptyString(value: String) {
        if(conditionString.isEmpty() && !(value =="*" || value == "/")){
            condition.text = value
        }
        else {
            condition.text = ""
        }
    }

    private fun setOperator(value: String) {
        conditionString = conditionString.dropLast(1)
        condition.text =  pasteSymbol(value)
    }

    private fun setNumber(value: String) {
        conditionString = defineConditionString()
        condition.text = pasteSymbol(value)
        resultString = defineConditionString()
    }

    private fun setConditionField(value: String) {
        conditionString = defineConditionString()

        if(conditionString.isEmpty()){
            setEmptyString(value)
        }
        else if (isOperation(value)) {
            setOperator(value)
        }
        else {
            setNumber(value)
        }
    }

    private fun isOperation(value: String): Boolean {
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
        }
    }

    private fun initMinusView() {
        minus = findViewById(R.id.minus)
        minus.setOnClickListener {
            setConditionField(minus.text.toString())
        }
    }

    private fun initMultiplyView() {
        multiply = findViewById(R.id.multiply)
        multiply.setOnClickListener {
            setConditionField(multiply.text.toString())
        }
    }

    private fun initDivideView() {
        divide = findViewById(R.id.divide)
        divide.setOnClickListener {
            setConditionField(divide.text.toString())
        }
    }

    private fun initPointView() {
        point = findViewById(R.id.point)
        point.setOnClickListener {
            pointExist = checkPoint()
            if (!pointExist) {
                setPoint()
            }
        }
    }

    private fun setPoint() {
        setConditionField(point.text.toString())
        pointExist = true
    }

    private fun getLastPosition(): Int{
        conditionString = defineConditionString()
        return conditionString.length - 2
    }

    private fun checkPoint(): Boolean {
        conditionString = defineConditionString()
        val numberArray = findLastNumber().toCharArray()
        var index = 0
        while(index != numberArray.size){
            return numberArray[index] == '.'
        }
        return false
    }

    private fun isOperatorExist(position: Int): Boolean {
        val conditionArray = conditionString.toCharArray()
        return !((isNumber(conditionArray[position].toString()) && position != 0)||conditionArray[position]== '.')
    }

    private fun initPercentView() {
        percent = findViewById(R.id.percent)
        percent.setOnClickListener {
            setPercent()
        }
    }

    private fun setPercent(){
        conditionString = defineConditionString()

        if (conditionString.isEmpty()) {
            clearFields()
        } else {
            enterPercentInField()
        }
    }

   private fun enterPercentInField() {
       setConditionField(percent.text.toString())

       resultString = stringAfterPercenting()
       clearFields()
       setResultField(resultString)
       setConditionField(resultString)
   }

    private  fun findPositionOfLastNumber(): Int {
        conditionString = defineConditionString()
        var position = getLastPosition()

        while (!isOperatorExist(position)) {
            position--
        }
        return position
    }

    private fun findLastNumber(): String {
        val position = findPositionOfLastNumber()
        if (findPositionOfLastNumber() == 1){
            return "0"
        }
        return conditionString.substring(position + 1, conditionString.length - 1)
    }

    private fun stringWithoutLastNumber(): String{
        conditionString = defineConditionString()
        return conditionString.substring(0,findPositionOfLastNumber()+1)
    }

    private fun countOfPercent(positionOfPercentNumber: Int): String {
        conditionString = defineConditionString()

        return if (positionOfPercentNumber == 0) {
            (conditionString.dropLast(1).toDouble() / 100).toString()
        } else {
                ((findLastNumber().toDouble() / 100) * (ExpressionBuilder(stringWithoutLastNumber().dropLast(1)).build()
                    .evaluate())).toString()
        }
    }

    private fun stringAfterPercenting(): String {
        return if (findPositionOfLastNumber() == 0) {
            countOfPercent(findPositionOfLastNumber())
        } else {
            return stringWithoutLastNumber() + countOfPercent(findPositionOfLastNumber())
        }
    }

    private fun initClearView() {
        clear = findViewById(R.id.clear)
        clear.setOnClickListener {
           conditionString = defineConditionString()
            condition.text = conditionString.dropLast(1)
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
