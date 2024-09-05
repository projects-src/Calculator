package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //数値を保持する変数
        var value : Int = 0
        // AC(All Clear)フラグ
        var ac : Boolean = false
        //計算を行うかを判断するフラグ
        var checkCalculator : Boolean = false
        //実行予定の演算子を保持しておく変数
        var operator : String = "no"

        //各ボタン情報
        val buttonZero      : Button = findViewById(R.id.zero)
        val buttonOne        : Button = findViewById(R.id.one)
        val buttonTwo        : Button = findViewById(R.id.two)
        val buttonThree      : Button = findViewById(R.id.three)
        val buttonFour       : Button = findViewById(R.id.four)
        val buttonFive       : Button = findViewById(R.id.five)
        val buttonSix        : Button = findViewById(R.id.six)
        val buttonSeven      : Button = findViewById(R.id.seven)
        val buttonEight      : Button = findViewById(R.id.eight)
        val buttonNine       : Button = findViewById(R.id.nine)
        val buttonAdd        : Button = findViewById(R.id.add)
        val buttonMultiply   : Button = findViewById(R.id.multiply)
        val buttonSub        : Button = findViewById(R.id.sub)
        val buttonDiv        : Button = findViewById(R.id.div)
        val buttonEqual      : Button = findViewById(R.id.equal)
        val buttonAc         : Button = findViewById(R.id.ac)

        //計算結果の表示
        val resultView : TextView = findViewById(R.id.result)

      fun numberButtonAction(number : String) {
        resultView.text = if(resultView.text.toString() != "0" && !ac) {
          resultView.text.toString() + number
        } else {
          ac = false
          number
        }
        checkCalculator = true
      }

      //計算する際の演算子を確認する
      fun calculation(op : String) : Int {
        return if(op == "+") {
          value + resultView.text.toString().toInt()
        } else if(op == "-") {
          value - resultView.text.toString().toInt()
        } else if(op == "*") {
          value * resultView.text.toString().toInt()
        } else if(op == "/") {
          value / resultView.text.toString().toInt()
        } else {
          resultView.text.toString().toInt()
        }
      }

      //計算を行う時の処理
      fun calculationButtonAction(op : String) {
        if (checkCalculator) {
          value = calculation(operator)
          ac = true
          checkCalculator = false
          resultView.text = value.toString()
        }
        operator = op
      }
      //イコールボタンを押した時の関数
      fun equalButtonAction() {
        if(checkCalculator) {
          value = calculation(operator)
          checkCalculator = false
          ac = true
          resultView.text = value.toString()
          operator = "no"
        }
      }
      //ACを押した時の関数
      fun acButtonAction() {
        resultView.text = "0"
        value = 0
        operator = "no"
        ac = false
        checkCalculator = false
      }
      //ボタンが押されたことを検知する処理
      buttonAc.setOnClickListener() {
          acButtonAction()
      }
      buttonZero.setOnClickListener() {
        numberButtonAction("0")
      }
      buttonOne.setOnClickListener() {
        numberButtonAction("1")
      }
      buttonTwo.setOnClickListener() {
        numberButtonAction("2")
      }
      buttonThree.setOnClickListener() {
        numberButtonAction("3")
      }
      buttonFour.setOnClickListener() {
        numberButtonAction("4")
      }
      buttonFive.setOnClickListener() {
        numberButtonAction("5")
      }
      buttonSix.setOnClickListener() {
        numberButtonAction("6")
      }
      buttonSeven.setOnClickListener() {
        numberButtonAction("7")
      }
      buttonEight.setOnClickListener() {
        numberButtonAction("8")
      }
      buttonNine.setOnClickListener() {
        numberButtonAction("9")
      }
      buttonAdd.setOnClickListener() {
        calculationButtonAction("+")
      }
      buttonSub.setOnClickListener() {
        calculationButtonAction("-")
      }
      buttonMultiply.setOnClickListener() {
        calculationButtonAction("*")
      }
      buttonDiv.setOnClickListener() {
        calculationButtonAction("/")
      }
      buttonEqual.setOnClickListener() {
        equalButtonAction()
      }
    }
}
