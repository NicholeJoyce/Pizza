package com.example.ma2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MainActivity extends AppCompatActivity {

    RadioGroup rdBurger, rdPizza, rdBev, rdPayment, rdSize;
    RadioButton rbChicken, rbBeef, rbVeg, rbSmall, rbMedium, rbLarge, rbJumbo, rbCoke, rbSprite, rbRoyal, rbCoffee, rbTea, rbReg, rbLargeBev, rbCash, rbGD, rbCredit;
    EditText etQuan, etQuan2, etQuan3;
    CheckBox cbMush, cbOn, cbOl, cbSausage, cbPeperoni, cbCheese;
    Button btnOrder;
    RadioButton rbSize;
    final double smallPizza= 75;
    final double mediumPizza = 150;
    final double largePizza = 250;
    final double jumboPizza = 400;
    final double Chicken = 50;
    final double Beef = 75;
    final double Veg = 60;
    final double regularDrink = 35;
    final double largeDrink = 75;
    final double regularCoffee = 30;
    final double largeCoffee = 50;
    final double regularTea = 25;
    final double largeTea = 40;
    String tab = "\t\t\t\t\t\t\t";

    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //radio button
        rdBurger = findViewById(R.id.rdBurger);
        rdPizza = findViewById(R.id.rdPizza);
        rdBev = findViewById(R.id.rdBev);
        rdPayment = findViewById(R.id.rdPayment);
        rdSize = findViewById(R.id.rdSize);
        //radio button
        rbChicken = findViewById(R.id.rbChicken);
        rbBeef = findViewById(R.id.rbBeef);
        rbVeg = findViewById(R.id.rbVeg);
        rbSmall = findViewById(R.id.rbSmall);
        rbMedium = findViewById(R.id.rbMedium);
        rbLarge = findViewById(R.id.rbLarge);
        rbJumbo = findViewById(R.id.rbJumbo);
        rbCoke = findViewById(R.id.rbCoke);
        rbSprite = findViewById(R.id.rbSprite);
        rbRoyal = findViewById(R.id.rbRoyal);
        rbCoffee = findViewById(R.id.rbCoffee);
        rbTea = findViewById(R.id.rbTea);
        rbReg = findViewById(R.id.rbReg);
        rbLargeBev = findViewById(R.id.rbLargeBev);
        rbCash = findViewById(R.id.rbCash);
        rbGD = findViewById(R.id.rbGD);
        rbCredit = findViewById(R.id.rbCredit);
        //edit text
        etQuan = findViewById(R.id.etQuan);
        etQuan2 = findViewById(R.id.etQuan2);
        etQuan3 = findViewById(R.id.etQuan3);
        //checkbox
        cbMush = findViewById(R.id.cbMush);
        cbOn = findViewById(R.id.cbOn);
        cbOl = findViewById(R.id.cbOl);
        cbSausage= findViewById(R.id.cbSausage);
        cbPeperoni = findViewById(R.id.cbPeperoni);
        cbCheese = findViewById(R.id.cbCheese);
        //button
        btnOrder = findViewById(R.id.btnOrder);
        builder = new AlertDialog.Builder(this);


        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder result = new StringBuilder();
                result.append("You Ordered the following \n\n");
                int total =0;
                int toppings = 0;
                int qty =0;
                double amount = 0;
                int IdPizza  = rdPizza.getCheckedRadioButtonId();
                RadioButton selected = findViewById(IdPizza);

                // PIZZA
                if(IdPizza == -1){
                    Toast.makeText(MainActivity.this, "Nothing selected, please select 1", Toast.LENGTH_SHORT).show();
                }else {
                   if(rbSmall.getId() == IdPizza){
                       qty = Integer.parseInt(etQuan.getText().toString());
                       amount = qty*smallPizza;
                       selected =rbSmall;

                   }else if(rbMedium.getId() == IdPizza){
                      qty = Integer.parseInt(etQuan.getText().toString());
                       amount = qty*mediumPizza;
                       selected =rbMedium;

                   }else if(rbLarge.getId() == IdPizza){
                       qty = Integer.parseInt(etQuan.getText().toString());
                       amount = qty*largePizza;
                       selected=rbLarge;
                   }else if(rbJumbo.getId()== IdPizza){
                       qty = Integer.parseInt(etQuan.getText().toString());
                       amount = qty*jumboPizza;
                       selected=rbJumbo;

                   }
                }
                //PIZZA ADDITIONAL TOPPINGS
                result.append(qty + " " + selected.getText().toString() + " Pizza: " + tab+  + (amount));
                result.append("\nWith the following additional toppings: \n");
                if(cbMush.isChecked()){
                    builder.setMessage(result.append("Mushroom \n"));
                    toppings += 20;
                }
                if(cbOn.isChecked()){
                    builder.setMessage(result.append("Onion \n"));
                    toppings += 20;
                }
                if(cbOl.isChecked()){
                    builder.setMessage(result.append("Olive \n"));
                    toppings += 20;
                }
                if(cbCheese.isChecked()){
                    builder.setMessage(result.append("More Cheese \n"));
                    toppings += 20;
                }
                if(cbSausage.isChecked()){
                    builder.setMessage(result.append("Sausage \n"));
                    toppings += 20;
                }
                if(cbPeperoni.isChecked()){
                    builder.setMessage(result.append("Peperoni \n"));
                    toppings += 20;
                }
                qty = Integer.parseInt(etQuan.getText().toString());
                int totalAmountPizza = toppings*qty;
                builder.setMessage(result.append( "Additional Toppings: " + totalAmountPizza + "\n"));

               result.append("\n" + qty + " " + selected.getText().toString() + " Pizza: " + tab+ + (amount+totalAmountPizza) + "\n");

               //BURGER
                double BurgerAmount =0;
                int IdBurger  = rdBurger.getCheckedRadioButtonId();
                RadioButton BurgerSelect = findViewById(IdBurger);

                if(rbChicken.getId() == IdBurger){
                    qty = Integer.parseInt(etQuan2.getText().toString());
                    BurgerAmount = qty*Chicken;
                    BurgerSelect =rbChicken;
                }
                if(rbBeef.getId() == IdBurger){
                    qty = Integer.parseInt(etQuan2.getText().toString());
                    BurgerAmount = qty*Beef;
                    BurgerSelect =rbBeef;
                }
                if(rbVeg.getId() == IdBurger){
                    qty = Integer.parseInt(etQuan2.getText().toString());
                    BurgerAmount = qty*Veg;
                    BurgerSelect =rbVeg;
                }
                result.append(qty + " " + BurgerSelect.getText().toString() +": " + tab + (BurgerAmount));

                //BEVERAGES
                String SelectedBeverage = null;
                String SelectedBevSize = null;
                double drinksAmount =0;

                if(rbCoke.isChecked()){
                    SelectedBeverage = rbCoke.getText().toString();
                }else if(rbSprite.isChecked()){
                    SelectedBeverage = rbSprite.getText().toString();
                }else if(rbRoyal.isChecked()){
                    SelectedBeverage = rbRoyal.getText().toString();
                }else if(rbCoffee.isChecked()){
                    SelectedBeverage = rbCoffee.getText().toString();
                }else if(rbTea.isChecked()){
                    SelectedBeverage = rbTea.getText().toString();
                }

                if(rbReg.isChecked()){
                    SelectedBevSize = rbReg.getText().toString();
                }else if(rbLargeBev.isChecked()){
                    SelectedBevSize = rbLargeBev.getText().toString();
                }

                if(SelectedBeverage.equals("Coke") || SelectedBeverage.equals("Sprite") || SelectedBeverage.equals("Royal")){
                    if(SelectedBevSize.equals("Regular")){
                        qty = Integer.parseInt(etQuan3.getText().toString());
                        drinksAmount = qty * regularDrink;
                    }else{
                        qty = Integer.parseInt(etQuan3.getText().toString());
                        drinksAmount = qty * largeDrink;
                    }
                }else if(SelectedBeverage.equals("Coffee")){
                    if(SelectedBevSize.equals("Regular")){
                        qty = Integer.parseInt(etQuan3.getText().toString());
                        drinksAmount = qty * regularCoffee;
                    }else{
                        qty = Integer.parseInt(etQuan3.getText().toString());
                        drinksAmount = qty * largeCoffee;
                    }
                }else if(SelectedBeverage.equals("Tea")) {
                    if (SelectedBevSize.equals("Regular")) {
                        qty = Integer.parseInt(etQuan3.getText().toString());
                        drinksAmount = qty * regularTea;
                    } else {
                        qty = Integer.parseInt(etQuan3.getText().toString());
                        drinksAmount = qty * largeTea;
                    }
                }

                result.append("\n" + qty + " " + SelectedBeverage+ " " + SelectedBevSize+": "+tab+(drinksAmount));

                //TOTAL PRICE OVER ALL
                result.append("\n" + "Total Amount: " + tab + (amount + totalAmountPizza + BurgerAmount + drinksAmount));

                double totalAmount = amount + totalAmountPizza + BurgerAmount + drinksAmount;
                //PAYMENT
                double realTotalAmount = 0;
                String selectedPayment = null;
                if(rbCash.isChecked()){
                    selectedPayment = rbCash.getText().toString();
                    realTotalAmount = totalAmount;
                }
                if(rbGD.isChecked()){
                    selectedPayment = rbGD.getText().toString();
                    double transpose = totalAmount * 0.05;
                    realTotalAmount = transpose + totalAmount;
                }
                if(rbCredit.isChecked()){
                    selectedPayment = rbCredit.getText().toString();
                    double transpose = totalAmount * 0.1;
                    realTotalAmount = transpose + totalAmount;
                }

                result.append("\n" + "Payment thru: " + tab+ selectedPayment);

                result.append("\n" + "Total Amount is: " + tab + "P "+ (realTotalAmount));
                result.append("\nPay Now?");

                builder.setCancelable(true).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Payment Made", Toast.LENGTH_SHORT).show();


                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "You choose to order more", Toast.LENGTH_SHORT);
                    }
                });
                AlertDialog alert = builder.create();
                alert.setTitle("Confirm Orders at PIZZ'SENSATION");
                alert.setMessage(result.toString());
                alert.show();
            }
        });

    }
}