package chimera.epic_rpg_thing.view;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import chimera.epic_rpg_thing.R;
import chimera.epic_rpg_thing.presenter.musicPresenter;

@SuppressWarnings("DanglingJavadoc")
public class newCharacterActivity extends AppCompatActivity {

    //TODO: Fix the evasion and mana not being updated when int and dex are changed

    private String choice;
    private String name;
    private short finalIntelligence;
    private short finalDexterity;
    private short finalStrength;
    private int finalHealth;
    private double finalDamage;
    private double finalMana;
    private double finalEvasion;

    /*
    * Further notes:
    * Dexterity should probably increase critical hit chance
    * Dexterity and how it affects dodge chance should probably be a % based on the dexterity
    * Possibly the same as the above but with how strength affects damage
    * There needs to be a cap on how high you can increase stats; Can be fixed by treating it like D&D poshort buy (ie increasing poshort cost the more you spend in one place)
    * (I have the logic already done for a poshort buy system)
    * Need to figure out how much each poshort increases a stat
    * Just STR, DEX, HP and MP? Any other stats we need to add?
    *
    * Also, NONE of this is currently tied to a class. Those aren't even implemented here yet. On
    * submition of the new character, the values here should be set to their respective classes.
    */

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_new_character);

        //QOL: This just capitalizes the first word when entering text
        TextView txtCapitalize = findViewById(R.id.characterName);
        txtCapitalize.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_WORDS);

        //This adds a black border around each of the 4 class choice buttons
        final ImageButton clericButton = findViewById(R.id.clericButton);
        final ImageButton warriorButton = findViewById(R.id.warriorButton);
        final ImageButton rogueButton = findViewById(R.id.rogueButton);
        final ImageButton mageButton = findViewById(R.id.mageButton);
        final Button selectSkills = findViewById(R.id.selectSkills);

        final ImageButton str_up = findViewById(R.id.str_up);
        final ImageButton str_down = findViewById(R.id.str_down);

        final ImageButton dex_up = findViewById(R.id.dex_up);
        final ImageButton dex_down = findViewById(R.id.dex_down);

        final ImageButton int_up = findViewById(R.id.int_up);
        final ImageButton int_down = findViewById(R.id.int_down);

        selectSkills.setEnabled(true); //TODO: Set this to false until stuff has been selected

            clericButton.setBackground(getDrawable(R.drawable.black_border));
            warriorButton.setBackground(getDrawable(R.drawable.black_border));
            rogueButton.setBackground(getDrawable(R.drawable.black_border));
            mageButton.setBackground(getDrawable(R.drawable.black_border));


        /***********************************************************************************
         *  These next 4 listeners let you select a class button and will change the displayed
         *  stats based on the class selection.
         *  //TODO: Will have to ` the values back to the default when changing class to prevent issues
         ************************************************************************************/
        clericButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                    displayInfo("cleric");
                    setChoice("Cleric");
            }});
        warriorButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                    displayInfo("warrior");
                setChoice("Warrior");
            }});
        mageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                    displayInfo("mage");
                setChoice("Mage");
            }});
        rogueButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                displayInfo("rogue");
                setChoice("Rogue");
            }});

        /*********************************************************************************
        * STRENGTH UP
        **********************************************************************************/
        str_up.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                final TextView strengthValue = findViewById(R.id.strengthValue);
                final TextView points = findViewById(R.id.points);
                final TextView damageValue = findViewById(R.id.damageValue);
                final TextView healthValue = findViewById(R.id.healthValue);
                short remainingPoshorts = Short.parseShort(String.valueOf(points.getText()));
                short strength = Short.parseShort(String.valueOf(strengthValue.getText()));
                double damage = Double.parseDouble(String.valueOf(damageValue.getText()));
                short currentHealth = Short.parseShort(String.valueOf(healthValue.getText()));
                short baseHealth = currentHealth;
                short increaseCost = 1;

                    switch (strength){
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                            increaseCost = 1;
                            break;
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                            increaseCost = 2;
                            break;
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                            increaseCost = 3;
                            break;
                    }

                if (remainingPoshorts - increaseCost >= 0){
                    if (choice.equals("rogue")) {
                        strength++;
                        strengthValue.setText(String.valueOf(strength));
                        remainingPoshorts -= increaseCost;
                        points.setText(String.valueOf(remainingPoshorts));
                        damage += 0.5;
                        damageValue.setText(String.valueOf(damage));
                        setFinalStrength(strength);
                        setFinalDamage(damage);
                    } else {
                        strength++;
                        strengthValue.setText(String.valueOf(strength));
                        setFinalStrength(strength);
                        remainingPoshorts -= increaseCost;
                        points.setText(String.valueOf(remainingPoshorts));
                        damage++;
                        damageValue.setText(String.valueOf(damage));
                        setFinalDamage(damage);
//                        Log.d("debug", String.valueOf(120 + (strength * 2.2)) + " " + Math.floor(Double.parseDouble(String.valueOf(100 + (strength * 2.2)))));
                    }

                    //To calculate the hp/mana/evasion via different multipliers
                    switch (choice){
                        case "warrior":
                            healthValue.setText(String.valueOf(Math.round(baseHealth + 3)));
                            setFinalHealth(baseHealth);
                        break;

                        case "rogue":
                        case "mage":
                        case "cleric":
                            healthValue.setText(String.valueOf(Math.round(baseHealth + 2)));
                            setFinalHealth(baseHealth);
                        break;
                    }

                }
            }});

        //1.2 evasion for non rogue, rogue gets 1.6 mod
        //2.2 mod for warrior str+hp
        //2.0 for others hp maybe
        //1.9 for cleric mana
        //1.5 for rogue/warrior mana


        /*********************************************************************************
         * STRENGTH DOWN
         **********************************************************************************/
        str_down.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                final TextView strengthValue = findViewById(R.id.strengthValue);
                final TextView points = findViewById(R.id.points);
                final TextView damageValue = findViewById(R.id.damageValue);
                final TextView healthValue = findViewById((R.id.healthValue));
                short remainingPoshorts = Short.parseShort(String.valueOf(points.getText()));
                short strength = Short.parseShort(String.valueOf(strengthValue.getText()));
                double damage = Double.parseDouble(String.valueOf(damageValue.getText()));
                short currentHealth = Short.parseShort(String.valueOf(healthValue.getText()));
                short baseHealth = currentHealth;
                short increaseCost = 1;

                    switch (strength) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            increaseCost = 1;
                            break;
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                            increaseCost = 2;
                            break;
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                            increaseCost = 3;
                            break;
                    }

                if (remainingPoshorts + increaseCost <= 15 && strength != 0){
                    if (choice.equals("rogue")) {
                        remainingPoshorts += increaseCost;
                        points.setText(String.valueOf(remainingPoshorts));
                        damage -= 0.5;
                        damageValue.setText(String.valueOf(damage));
                        setFinalDamage(damage);
                        strength--;
                        strengthValue.setText(String.valueOf(strength));
                        setFinalStrength(strength);
                        setFinalDamage(damage);
                    } else {
                        strength--;
                        strengthValue.setText(String.valueOf(strength));
                        setFinalStrength(strength);
                        remainingPoshorts += increaseCost;
                        points.setText(String.valueOf(remainingPoshorts));
                        damage--;
                        damageValue.setText(String.valueOf(damage));
                        setFinalDamage(damage);
                    }

                    switch (choice){
                        case "warrior":
                            healthValue.setText(String.valueOf(baseHealth - 3));
                            break;

                        case "rogue":
                        case "mage":
                        case "cleric":
                            healthValue.setText(String.valueOf(baseHealth - 2));
                            break;
                    }

                }
            }});

        /*********************************************************************************
         * DEXTERITY UP
         **********************************************************************************/
        dex_up.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                final TextView dexterityValue = findViewById(R.id.dexterityValue);
                final TextView points = findViewById(R.id.points);
                final TextView damageValue = findViewById(R.id.damageValue);
                final TextView evasionValue = findViewById((R.id.evasionValue));
                short remainingPoshorts = Short.parseShort(String.valueOf(points.getText()));
                short dexterity = Short.parseShort(String.valueOf(dexterityValue.getText()));
                double damage = Double.parseDouble(String.valueOf(damageValue.getText()));
                double evasion = Double.parseDouble(String.valueOf(evasionValue.getText()));
                short increaseCost = 1;

                switch (dexterity){
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        increaseCost = 1;
                        break;
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        increaseCost = 2;
                        break;
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        increaseCost = 3;
                        break;
                }

                DecimalFormat df = new DecimalFormat("#.0");

                if (remainingPoshorts - increaseCost >= 0){
                    if (choice.equals("rogue")) {
                        dexterity++;
                        dexterityValue.setText(String.valueOf(dexterity));
                        setFinalDexterity(dexterity);
                        remainingPoshorts -= increaseCost;
                        points.setText(String.valueOf(remainingPoshorts));
                        damage++;
                        damageValue.setText(String.valueOf(damage));
                        setFinalDamage(damage);
                    } else {
                        dexterity++;
                        dexterityValue.setText(String.valueOf(dexterity));
                        setFinalDexterity(dexterity);
                        remainingPoshorts -= increaseCost;
                        points.setText(String.valueOf(remainingPoshorts));
                        damage += 0.5;
                        damageValue.setText(String.valueOf(damage));
                        setFinalDamage(damage);
                    }

                    switch (choice){
                        case "warrior":
                        case "mage":
                        case "cleric":
                            evasionValue.setText(String.valueOf(df.format((evasion + 1.2))));
                            setFinalEvasion(evasion);
                            break;

                        case "rogue":
                            evasionValue.setText(String.valueOf(df.format((evasion + 1.6))));
                            setFinalEvasion(evasion);
                            break;
                    }

                }
            }});

        /*********************************************************************************
         * DEXTERITY DOWN
         **********************************************************************************/
        dex_down.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                final TextView dexterityValue = findViewById(R.id.dexterityValue);
                final TextView points = findViewById(R.id.points);
                final TextView damageValue = findViewById(R.id.damageValue);
                short remainingPoshorts = Short.parseShort(String.valueOf(points.getText()));
                short dexterity = Short.parseShort(String.valueOf(dexterityValue.getText()));
                double damage = Double.parseDouble(String.valueOf(damageValue.getText()));
                final TextView evasionValue = findViewById((R.id.evasionValue));
                double evasion = Double.parseDouble(String.valueOf(evasionValue.getText()));
                short increaseCost = 1;

                switch (dexterity) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        increaseCost = 1;
                        break;
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                        increaseCost = 2;
                        break;
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        increaseCost = 3;
                        break;
                }

                DecimalFormat df = new DecimalFormat("#.0");

                if (remainingPoshorts + increaseCost <= 15 && dexterity != 0){
                    if (choice.equals("rogue")) {
                        remainingPoshorts += increaseCost;
                        points.setText(String.valueOf(remainingPoshorts));
                        damage--;
                        damageValue.setText(String.valueOf(damage));
                        dexterity--;
                        dexterityValue.setText(String.valueOf(dexterity));
                        setFinalDexterity(dexterity);
                        setFinalDamage(damage);
                    } else {
                        dexterity--;
                        dexterityValue.setText(String.valueOf(dexterity));
                        remainingPoshorts += increaseCost;
                        points.setText(String.valueOf(remainingPoshorts));
                        damage -= 0.5;
                        damageValue.setText(String.valueOf(damage));
                        finalDamage =  damage;
                        setFinalDexterity(dexterity);
                    }

                    switch (choice){
                        case "warrior":
                        case "mage":
                        case "cleric":
                            evasionValue.setText(String.valueOf(df.format((evasion - 1.2))));
                            setFinalEvasion(evasion);
                            break;

                        case "rogue":
                            evasionValue.setText(String.valueOf(df.format((evasion - 1.6))));
                            setFinalEvasion(evasion);
                            break;
                    }
                }
            }});

        /*********************************************************************************
         * INTELLIGENCE UP
         **********************************************************************************/
        int_up.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                final TextView intelligenceValue = findViewById(R.id.intelligenceValue);
                final TextView points = findViewById(R.id.points);
                final TextView manaValue = findViewById(R.id.manaValue);
                short remainingPoshorts = Short.parseShort(String.valueOf(points.getText()));
                short intelligence = Short.parseShort(String.valueOf(intelligenceValue.getText()));
                double mana = Double.parseDouble(String.valueOf(manaValue.getText()));
                short increaseCost = 1;

                switch (intelligence){
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        increaseCost = 1;
                        break;
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        increaseCost = 2;
                        break;
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        increaseCost = 3;
                        break;
                }

                DecimalFormat df = new DecimalFormat("#.0");

                if (remainingPoshorts - increaseCost >= 0){
                        intelligence++;
                        intelligenceValue.setText(String.valueOf(intelligence));
                        setFinalIntelligence(intelligence);
                        remainingPoshorts -= increaseCost;
                        points.setText(String.valueOf(remainingPoshorts));

                    switch (choice){
                        case "warrior":
                        case "rogue":
                            manaValue.setText(String.valueOf(df.format((mana + 1.5))));
                            setFinalMana(mana);
                        break;

                        case "mage":
                            manaValue.setText(String.valueOf(df.format((mana + 2.2))));
                            setFinalMana(mana);
                        break;

                        case "cleric":
                            manaValue.setText(String.valueOf(df.format((mana + 1.9))));
                            setFinalMana(mana);
                        break;
                    }
                }
            }});

        //1.2 evasion for non rogue, rogue gets 1.6 mod
        //2.2 mod for warrior str+hp
        //2.0 for others hp maybe
        //1.9 for cleric mana
        //1.5 for rogue/warrior mana


        /*********************************************************************************
         * INTELLIGENCE DOWN
         **********************************************************************************/
        int_down.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                final TextView intelligenceValue = findViewById(R.id.intelligenceValue);
                final TextView points = findViewById(R.id.points);
                final TextView manaValue = findViewById(R.id.manaValue);
                short remainingPoshorts = Short.parseShort(String.valueOf(points.getText()));
                short intelligence = Short.parseShort(String.valueOf(intelligenceValue.getText()));
                double mana = Double.parseDouble(String.valueOf(manaValue.getText()));
                short increaseCost = 1;

                switch (intelligence) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        increaseCost = 1;
                        break;
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                        increaseCost = 2;
                        break;
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        increaseCost = 3;
                        break;
                }

                DecimalFormat df = new DecimalFormat("#.0");

                if (remainingPoshorts + increaseCost <= 15 && intelligence != 0){
                        remainingPoshorts += increaseCost;
                        points.setText(String.valueOf(remainingPoshorts));
                        intelligence--;
                        intelligenceValue.setText(String.valueOf(intelligence));
                        setFinalIntelligence(intelligence);

                    switch (choice){
                        case "warrior":
                        case "rogue":
                            manaValue.setText(String.valueOf(df.format((mana - 1.5))));
                            finalMana = mana;
                            break;

                        case "mage":
                            manaValue.setText(String.valueOf(df.format((mana - 2.2))));
                            finalMana = mana;
                            break;

                        case "cleric":
                            manaValue.setText(String.valueOf(df.format((mana - 1.9))));
                            finalMana = mana;
                            break;
                    }
                }
            }});
    }

    /***********************************************************************************
     *  DisplayInfo - Displays the current class information on screen via the class
     *  selection imageButtons
     ************************************************************************************/
     @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
     public void displayInfo(String choice){
         TextView classLabel = findViewById(R.id.level_class_label);
         String classText;

         final ImageButton clericButton = findViewById(R.id.clericButton);
         final ImageButton warriorButton = findViewById(R.id.warriorButton);
         final ImageButton rogueButton = findViewById(R.id.rogueButton);
         final ImageButton mageButton = findViewById(R.id.mageButton);
         final ImageButton dex_up = findViewById(R.id.dex_up);
         final ImageButton int_up = findViewById(R.id.int_up);
         final ImageButton str_up = findViewById(R.id.str_up);
         final ImageButton str_down = findViewById(R.id.str_down);
         final ImageButton dex_down = findViewById(R.id.dex_down);
         final ImageButton int_down = findViewById(R.id.int_down);

         final TextView healthLabel = findViewById(R.id.healthLabel);
         final TextView manaLabel = findViewById(R.id.manaLabel);
         final TextView strengthLabel = findViewById(R.id.strengthLabel);
         final TextView dexterityLabel = findViewById(R.id.dexterityLabel);
         final TextView points = findViewById(R.id.points);
         final TextView pointsLabel = findViewById(R.id.pointsLabel);
         final TextView evasionLabel = findViewById(R.id.evasionLabel);
         final TextView evasionValue = findViewById(R.id.evasionValue);

         final TextView healthValue = findViewById(R.id.healthValue);
         final TextView manaValue = findViewById(R.id.manaValue);
         final TextView strengthValue = findViewById(R.id.strengthValue);
         final TextView dexterityValue = findViewById(R.id.dexterityValue);
         final TextView intelligenceLabel = findViewById(R.id.intelligenceLabel);
         final TextView intelligenceValue = findViewById(R.id.intelligenceValue);

         final TextView damageLabel = findViewById(R.id.damageLabel);
         final TextView damageValue = findViewById(R.id.damageValue);

         //TODO: Next up, rework the layout here to include the increase skill buttons and stuff, and move all of the skill select stuff to the next screen

         //Sets all of the borders to black. Is changed to red when choice is made
             warriorButton.setBackground(getDrawable(R.drawable.black_border));
             clericButton.setBackground(getDrawable(R.drawable.black_border));
             rogueButton.setBackground(getDrawable(R.drawable.black_border));
             mageButton.setBackground(getDrawable(R.drawable.black_border));

         switch (choice){
             case "cleric":
                 clericButton.setBackground(getDrawable(R.drawable.red_border));
                 classText = "Level 1 " +  "Cleric";
                 classLabel.setText(classText);
                 healthValue.setText(String.valueOf(100));
                 manaValue.setText(String.valueOf(50));
                 strengthValue.setText(String.valueOf(0));
                 dexterityValue.setText(String.valueOf(0));
                 intelligenceValue.setText(String.valueOf(0));
                 damageValue.setText(String.valueOf(6));
                 evasionValue.setText(String.valueOf(1));
             break;

             case "mage":
                 mageButton.setBackground(getDrawable(R.drawable.red_border));
                 classText = "Level 1 " +  "Mage";
                 classLabel.setText(classText);
                 healthValue.setText(String.valueOf(75));
                 manaValue.setText(String.valueOf(100));
                 strengthValue.setText(String.valueOf(0));
                 dexterityValue.setText(String.valueOf(0));
                 intelligenceValue.setText(String.valueOf(0));
                 damageValue.setText(String.valueOf(2));
                 evasionValue.setText(String.valueOf(1));
              break;

             case "warrior":
                 warriorButton.setBackground(getDrawable(R.drawable.red_border));
                 classText = "Level 1 " +  "Warrior";
                 classLabel.setText(classText);
                 healthValue.setText(String.valueOf(120));
                 manaValue.setText(String.valueOf(20));
                 strengthValue.setText(String.valueOf(0));
                 dexterityValue.setText(String.valueOf(0));
                 intelligenceValue.setText(String.valueOf(0));
                 damageValue.setText(String.valueOf(10));
                 evasionValue.setText(String.valueOf(1));
             break;

             case "rogue":
                 rogueButton.setBackground(getDrawable(R.drawable.red_border));
                 classText = "Level 1 " +  "Rogue";
                 classLabel.setText(classText);
                 healthValue.setText(String.valueOf(80));
                 manaValue.setText(String.valueOf(20));
                 strengthValue.setText(String.valueOf(0));
                 dexterityValue.setText(String.valueOf(0));
                 intelligenceValue.setText(String.valueOf(0));
                 damageValue.setText(String.valueOf(5));
                 evasionValue.setText(String.valueOf(1));
             break;
         }

         //Reset the points value
         points.setText(String.valueOf(15));

         //Displays the hidden content on the page
         classLabel.setVisibility(View.VISIBLE);
         healthLabel.setVisibility(View.VISIBLE);
         manaLabel.setVisibility(View.VISIBLE);
         strengthLabel.setVisibility(View.VISIBLE);
         dexterityLabel.setVisibility(View.VISIBLE);
         healthValue.setVisibility(View.VISIBLE);
         manaValue.setVisibility(View.VISIBLE);
         strengthValue.setVisibility(View.VISIBLE);
         dexterityValue.setVisibility(View.VISIBLE);
         str_up.setVisibility(View.VISIBLE);
         dex_up.setVisibility(View.VISIBLE);
         int_up.setVisibility(View.VISIBLE);
         str_down.setVisibility(View.VISIBLE);
         dex_down.setVisibility(View.VISIBLE);
         int_down.setVisibility(View.VISIBLE);
         intelligenceLabel.setVisibility(View.VISIBLE);
         intelligenceValue.setVisibility(View.VISIBLE);
         damageLabel.setVisibility(View.VISIBLE);
         damageValue.setVisibility(View.VISIBLE);
         points.setVisibility(View.VISIBLE);
         pointsLabel.setVisibility(View.VISIBLE);
         evasionLabel.setVisibility(View.VISIBLE);
         evasionValue.setVisibility(View.VISIBLE);
     }

     public void selectSkills(View view){

         TextView nameField = findViewById(R.id.characterName);

         if (nameField == null || nameField.getText().toString().equals("")){
             Toast.makeText(getApplicationContext(), "Enter a name to continue", Toast.LENGTH_LONG).show();
             return;
         } else {
             setName(nameField.getText().toString());
         }

             Intent i = new Intent(this, selectSkillsActivity.class);

             i.putExtra("class", choice);
             i.putExtra("name", name);
             i.putExtra("intelligence", finalIntelligence);
             i.putExtra("dexterity", finalDexterity);
             i.putExtra("strength", finalStrength);
             i.putExtra("health", finalHealth);
             i.putExtra("mana", finalMana);
             i.putExtra("evasion", finalEvasion);
             i.putExtra("damage", finalDamage);

             startActivity(i);
         }

    public short getFinalIntelligence() {
        return finalIntelligence;
    }

    public void setFinalIntelligence(short finalIntelligence) {
        this.finalIntelligence = finalIntelligence;
    }

    public short getFinalDexterity() {
        return finalDexterity;
    }

    public void setFinalDexterity(short finalDexterity) {
        this.finalDexterity = finalDexterity;
    }

    public short getFinalStrength() {
        return finalStrength;
    }

    public void setFinalStrength(short finalStrength) {
        this.finalStrength = finalStrength;
    }

    public int getFinalHealth() {
        return finalHealth;
    }

    public void setFinalHealth(int finalHealth) {
        this.finalHealth = finalHealth;
    }

    public double getFinalDamage() {
        return finalDamage;
    }

    public void setFinalDamage(double finalDamage) {
        this.finalDamage = finalDamage;
    }

    public double getFinalMana() {
        return finalMana;
    }

    public void setFinalMana(double finalMana) {
        this.finalMana = finalMana;
    }

    public double getFinalEvasion() {
        return finalEvasion;
    }

    public void setFinalEvasion(double finalEvasion) {
        this.finalEvasion = finalEvasion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChoice(String choice) {this.choice = choice;}
    public String getChoice() { return choice; }
}
